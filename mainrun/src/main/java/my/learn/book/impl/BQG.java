package my.learn.book.impl;

import java.io.File;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import my.learn.book.dao.BookDb;
import my.learn.book.dao.BookWeb;
import my.learn.book.utils.Agent;
import my.learn.utils.FileTools;

/**
 * 笔趣阁
 * 
 * @author lin
 * @date 2018年2月3日 下午9:44:27
 */
public class BQG implements BookWeb {
	private String base = "http://www.biqugetw.com/";

	@Override
	public void only(String path, String book) throws Exception {
		BookDb db = new BookDbImpl();
		Document doc = Jsoup.connect(base + book + "/").get();
		String name = doc.getElementsByTag("h1").get(0).text();
		long bookId = db.insertName(name);
		Element list = doc.getElementById("list");
		int size = list.getElementsByTag("dd").size();
		int i = 0;
		Element dt = list.getElementsByTag("dt").get(0).nextElementSibling();
		while ("dd".equals(dt.nodeName())) {
			i++;
			dt = dt.nextElementSibling();
		}
		StringBuffer sb = new StringBuffer();
		sb.append(name).append("\r\n\r\n");
		String agent = Agent.PC_AGENT.get(String.valueOf((int) Math.floor(Math.random() * 10)));
		while (i < size) {
			i++;
			dt = dt.nextElementSibling();
			Element a = dt.select("a").get(0);
			String title = a.text();
			long titleId = db.insertTitle(bookId, title);
			System.out.println(title);
			sb.append(title).append("\r\n\r\n");
			int random = (int) Math.floor(Math.random() * 100 + 200);
			if (i % 30 == 0) {
				String key = String.valueOf((int) Math.floor(Math.random() * 10) + 1);
				System.out.println(key);
				agent = Agent.PC_AGENT.get(key);
			}
			Document txt = Jsoup.connect(base + a.attr("href")).userAgent(agent).get();
			Element content = txt.getElementById("content");
			String c = content.html().replaceAll("&nbsp;", " ").replaceAll("<br>", "");
			db.insertContext(titleId, c);
			sb.append(c).append("\r\n\r\n");
			Thread.sleep(random);
		}
		FileTools.appendWrite(path + File.separatorChar + name + ".txt", sb.toString());
	}

	@Override
	public void all(String folder) {

	}

}
