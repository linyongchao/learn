package my.learn.book.impl;

import java.io.File;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import my.learn.book.dao.BookDb;
import my.learn.book.dao.BookWeb;
import my.learn.book.modal.Book;
import my.learn.utils.FileTools;
import my.learn.utils.HttpUtils;

/**
 * 第一版主
 * 
 * @author lin
 * @date 2018年1月31日 下午5:50:54
 */
public class DYBZ implements BookWeb {
	private String base = "https://www.diyibanzhu9.pro/";

	@Override
	public void only(String path, String book) throws Exception {
		Document doc = Jsoup.connect(base + book + "/").get();
		// 获取文章名称并入库
		String name = doc.getElementsByTag("h1").get(0).text();
		BookDb db = new BookDbImpl();
		long bookId = db.existName(name);
		if (bookId == 0) {
			bookId = db.insertName(name);
			System.out.println("获取文章名称并入库：" + name);
		} else {
			System.out.println("文章名称已存在，id=" + bookId);
		}
		// 获取最大页数
		String endPage = doc.getElementsByClass("endPage").get(0).attr("href");
		endPage = endPage.replace("/", "");
		int location = endPage.indexOf("_");
		int totalPage = Integer.valueOf(endPage.substring(location + 1));
		System.out.println("获取最大页数：" + totalPage);
		for (int i = 1; i < totalPage + 1; i++) {
			String tmpBook = i == 1 ? book : book + "_" + i;
			Document arrayPage = Jsoup.connect(base + tmpBook + "/").get();
			Element list = arrayPage.getElementsByClass("bd").get(4);
			Elements as = list.select("a");
			for (Element a : as) {
				// 过滤掉改编或者续写的章节
				String chapterName = a.text();
				if (chapterName.contains("改编") || chapterName.contains("续写")) {
					continue;
				}
				long titleId = db.existTitle(bookId, chapterName);
				if (titleId == 0) {
					titleId = db.insertTitle(bookId, chapterName);
					System.out.println("获取章节名称并入库：" + chapterName);
				} else {
					System.out.println("章节名称已存在，id=" + chapterName);
				}
				long contextId = db.existContext(titleId);
				if (contextId == 0) {
					String chapterUrl = base + a.attr("href");
					String chapterContext = everyChapter(chapterUrl, chapterName, book);
					db.insertContext(titleId, chapterContext);
					System.out.println("获取章节内容并入库");
				} else {
					System.out.println("章节内容已存在");
				}
			}
			System.out.println("------------第" + i + "页完毕-------------");
		}
	}

	public String everyChapter(String chapterUrl, String chapterName, String book) throws Exception {
		StringBuffer sb = new StringBuffer();
		String result = HttpUtils.get(chapterUrl, null, "gb2312");
		Document txt = Jsoup.parse(result);
		Elements pages = txt.getElementsByClass("chapterPages");
		if (pages.size() > 0) {
			Elements select = txt.getElementsByClass("chapterPages").get(0).select("a");
			int i = 1;
			for (Element element : select) {
				System.out.println("章节" + chapterName + "第" + i++ + "部分");
				String url = base + book + "/" + element.attr("href");
				result = HttpUtils.get(url, null, "gb2312");
				txt = Jsoup.parse(result);
				Element content = txt.getElementsByClass("page-content font-large").get(0);
				content.select("script").remove();
				sb.append(content.html().replaceAll("<br>", "\r\n").replaceAll("&nbsp;", ""));
			}
		} else {
			Element content = txt.getElementsByClass("box_box").get(0);
			content.select("script").remove();
			sb.append(content.html().replaceAll("<br>", "\r\n").replaceAll("&nbsp;", ""));
		}
		int random = (int) Math.floor(Math.random() * 100 + 200);
		Thread.sleep(random);
		return sb.toString();
	}

	@Override
	public void all(String folder) {

	}

	@Override
	public void export(String path, String name) {
		BookDb db = new BookDbImpl();
		long bookId = db.existName(name);
		if (bookId == 0) {
			return;
		}
		List<Book> books = db.getBook(bookId);
		StringBuffer sb = new StringBuffer();
		sb.append(name).append("\r\n\r\n");
		for (Book book : books) {
			sb.append(book.getTitle()).append("\r\n\r\n");
			sb.append(book.getContext()).append("\r\n\r\n");
		}
		String resultPath = path + File.separatorChar + name + ".txt";
		FileTools.appendWrite(resultPath, sb.toString());
		DYBZExport.analysis(resultPath);
	}

}
