package my.learn.book.test;

import my.learn.book.dao.BookWeb;
import my.learn.book.impl.BQG;

public class TestBQG {
	public static void main(String[] args) throws Exception {
		BookWeb bi = new BQG();
		// 唐朝好地主
		bi.only("/Users/lin/", "9_9805");
		System.out.println("--over--");
	}
}
