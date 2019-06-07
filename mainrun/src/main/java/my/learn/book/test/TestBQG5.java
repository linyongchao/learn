package my.learn.book.test;

import my.learn.book.dao.BookWeb;
import my.learn.book.impl.BQG5;

public class TestBQG5 {
	public static void main(String[] args) throws Exception {
		BookWeb book = new BQG5();
		book.only("/Users/lin/spider/笔趣阁", "7_7397");
		System.out.println("--over--");
	}
}
