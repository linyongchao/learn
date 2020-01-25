package my.learn.book.test;

import my.learn.book.dao.BookWeb;
import my.learn.book.impl.DYBZ;

public class TestDYBZ {
	public static void main(String[] args) throws Exception {
		String path = "/Users/lin/spider/第一版主";
		BookWeb bi = new DYBZ();
		bi.only(path, "14/14568");
		// bi.export(path, "生日愿望（终极版）");
		System.out.println("--over--");
	}
}
