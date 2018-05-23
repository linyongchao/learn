package my.learn.book.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import my.learn.book.dao.BookWeb;
import my.learn.book.impl.DYBZ;

public class TestDYBZ {
	public static void main(String[] args) throws Exception {
		BookWeb bi = new DYBZ();
		// 重生赵志敬
		// bi.only("/Users/lin/spider/第一版主", "0/30");
		// 沉欲之小西的美母教师
		// bi.only("/Users/lin/spider/第一版主", "0/329");
		// [同人]小西的美母教师番外篇(纪容的回忆)
		// bi.only("/Users/lin/spider/第一版主", "0/623");
		// 神都
		// bi.only("/Users/lin/spider/第一版主", "0/525");
		// 权力的体香
		// bi.only("/Users/lin/spider/第一版主", "1/1502");
		// 大明天下
		// bi.only("/Users/lin/spider/第一版主", "2/2643");
		// 黄蓉系列
		// bi.only("/Users/lin/spider/第一版主", "2/2739");
		// bi.only("/Users/lin/spider/第一版主", "6/6954");
		// bi.only("/Users/lin/spider/第一版主", "6/6830");
		// bi.only("/Users/lin/spider/第一版主", "0/217");
		// bi.only("/Users/lin/spider/第一版主", "4/4944");
		// bi.only("/Users/lin/spider/第一版主", "4/4102");
		// bi.only("/Users/lin/spider/第一版主", "4/4093");
		// bi.only("/Users/lin/spider/第一版主", "4/4084");
		// bi.only("/Users/lin/spider/第一版主", "3/3907");
		// bi.only("/Users/lin/spider/第一版主", "3/3432");
		// bi.only("/Users/lin/spider/第一版主", "2/2956");
		// bi.only("/Users/lin/spider/第一版主", "1/1227");
		// bi.only("/Users/lin/spider/第一版主", "0/766");
		// bi.only("/Users/lin/spider/第一版主", "0/397");
		// bi.only("/Users/lin/spider/第一版主", "0/284");
		// bi.only("/Users/lin/spider/第一版主", "0/269");
		System.out.println("--over--");

		Date d = new Date(1701556726845448504L);
		String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(d);
		System.out.println(format);
	}
}
