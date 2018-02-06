package my.learn.book.test;

import my.learn.book.dao.BookWeb;
import my.learn.book.impl.DYBZ;

public class TestDYBZ {
	public static void main(String[] args) throws Exception {
		BookWeb bi = new DYBZ();
		// 重生赵志敬
		// bi.only("/Users/lin/", "0/30");
		// 沉欲之小西的美母教师
		// bi.only("/Users/lin/", "0/329");
		// [同人]小西的美母教师番外篇(纪容的回忆)
		// bi.only("/Users/lin/", "0/623");
		// 神都
		// bi.only("/Users/lin/", "0/525");
		// 权力的体香
		bi.only("/Users/lin/小说", "1/1502");
		System.out.println("--over--");
	}
}
