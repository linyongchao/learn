package my.learn.book.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import my.learn.book.dao.BookDb;
import my.learn.book.dao.BookWeb;
import my.learn.book.modal.Book;
import my.learn.book.utils.Agent;

/**
 * 笔趣阁
 * 
 * @author lin
 * @date 2018年2月3日 下午9:44:27
 */
public class BQG5 implements BookWeb {
	private String base = "https://www.biquge5.com/";

	@Override
	public void only(String path, String book) throws Exception {
		BookDb db = new BookDbImpl();
		String url = base + book + "/";
		System.out.println(url);
		Document doc = Jsoup.connect(base + book + "/").get();
		String name = doc.getElementsByTag("h1").get(0).text();
		Book book2 = db.getBook(name);
		long bookId = 0;
		if (book2 == null) {
			bookId = db.insertName(name);
		} else if (book2.getIsEnd() == 1) {
			if (book2.getIsExport() == 0) {
				BookWeb bw = new BQG5();
				bw.export(path, name);
				db.updateBook(book2.getId(), true, true);
			}
			System.out.println("skip:" + name);
			return;
		} else {
			bookId = book2.getId();
		}
		List<Book> booklist = db.getBook(bookId);
		Map<String, Long> titleMap = new HashMap<>();
		for (Book b : booklist) {
			titleMap.put(b.getTitle(), b.getTitleId());
		}

		Element list = doc.getElementById("list");
		int i = 1;
		Element ul = list.getElementsByTag("ul").get(0);
		Elements lis = ul.getElementsByTag("li");
		Element li = lis.get(0);
		int size = lis.size();
		String agent = Agent.PC_AGENT.get(String.valueOf((int) Math.floor(Math.random() * 10) + 1));
		while (i < size) {
			if (li.select("a").size() == 0) {
				li = li.nextElementSibling();
				i++;
				continue;
			}
			Element a = li.select("a").get(0);
			String title = a.text();
			long titleId = titleMap.containsKey(title) ? titleMap.get(title) : 0;
			if (titleId == 0) {
				titleId = db.insertTitle(bookId, title);
			} else {
				System.out.println("skip:" + title);
				li = li.nextElementSibling();
				i++;
				continue;
			}
			System.out.println(name + "--:--" + title);
			int random = (int) Math.floor(Math.random() * 100 + 300);
			if (i % 10 == 0) {
				String key = String.valueOf((int) Math.floor(Math.random() * 10) + 1);
				agent = Agent.PC_AGENT.get(key);
			}
			StringBuilder sb = new StringBuilder();
			getOnePage(a.attr("href"), book, null, agent, sb);
			db.insertContext(titleId, sb.toString());
			Thread.sleep(random);
			li = li.nextElementSibling();
			i++;
		}
		db.updateBook(bookId, true, false);
		BookWeb bw = new BQG5();
		bw.export(path, name);
		db.updateBook(bookId, true, true);
	}

	private void getOnePage(String url, String id, String page, String agent, StringBuilder sb) throws IOException {
		Document txt = Jsoup.connect(url).userAgent(agent).get();
		String c = getContext(txt);
		sb.append(c);
		Element b = txt.getElementsByClass("bottem2").get(0);
		Element next = b.select("a").get(3);
		page = next.attr("href");
		if ("下一页".equals(next.text())) {
			url = base + id + "/" + page;
			getOnePage(url, id, page, agent, sb);
		}
	}

	private String getContext(Document txt) {
		Element content = txt.getElementById("content");
		return content.html().replaceAll("&nbsp;", " ").replaceAll("<br>", "").replaceAll("'", "");
	}

	@Override
	public void all(String folder) throws Exception {
		ExecutorService pool = Executors.newFixedThreadPool(4);
		Document doc = Jsoup.connect(base).get();
		Elements elements = doc.getElementsByClass("novelslist");
		for (Element element : elements) {
			Elements as = element.select("a");
			for (Element a : as) {
				pool.execute(new Runnable() {
					@Override
					public void run() {
						try {
							System.out.println(a.text());
							only(folder, a.attr("href").replaceAll(base, "").replaceAll("/", ""));
						} catch (Exception e) {
							System.out.println("error:" + a.text());
							e.printStackTrace();
						}
					}
				});
			}
		}
	}

}
