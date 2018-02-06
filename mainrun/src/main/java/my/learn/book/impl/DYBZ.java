package my.learn.book.impl;

import java.io.File;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import my.learn.book.dao.BookWeb;
import my.learn.utils.FileTools;
import my.learn.utils.HttpUtils;

/**
 * 第一版主
 * 
 * @author lin
 * @date 2018年1月31日 下午5:50:54
 */
public class DYBZ implements BookWeb {
	private String base = "https://www.diyibanzhu.xyz/";

	@Override
	public void only(String path, String book) throws Exception {
		Document doc = Jsoup.connect(base + book + "/").get();
		String name = doc.getElementsByTag("h2").get(1).text();
		Element list = doc.getElementsByClass("dd").get(0);
		StringBuffer sb = new StringBuffer();
		sb.append(name).append("\r\n");
		Elements as = list.select("a");
		for (Element a : as) {
			if (a.text().contains("改编") || a.text().contains("续写")) {
				continue;
			}
			System.out.println(a.text());
			sb.append(a.text()).append("\r\n");
			int random = (int) Math.floor(Math.random() * 100 + 200);
			String url = base + book + "/" + a.attr("href");
			String result = HttpUtils.get(url, null, "gb2312");
			Document txt = Jsoup.parse(result);
			Elements pages = txt.getElementsByClass("chapterPages");
			if (pages.size() > 0) {
				Elements select = txt.getElementsByClass("chapterPages").get(0).select("a");
				for (Element element : select) {
					url = base + book + "/" + element.attr("href");
					result = HttpUtils.get(url, null, "gb2312");
					txt = Jsoup.parse(result);
					Element content = txt.getElementsByClass("box_box").get(0);
					content.select("script").remove();
					sb.append(content.html().replaceAll("<br>", "").replaceAll("&nbsp;", ""));
				}
			} else {
				Element content = txt.getElementsByClass("box_box").get(0);
				content.select("script").remove();
				sb.append(content.html().replaceAll("<br>", "").replaceAll("&nbsp;", ""));
			}
			Thread.sleep(random);
		}

		FileTools.appendWrite(path + File.separatorChar + name + ".txt", sb.toString());
	}

	@Override
	public void all(String folder) {

	}

}
