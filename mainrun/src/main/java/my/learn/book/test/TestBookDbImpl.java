package my.learn.book.test;

import my.learn.book.dao.BookDb;
import my.learn.book.impl.BookDbImpl;

public class TestBookDbImpl {
	public static void main(String[] args) {
		BookDb db = new BookDbImpl();
		long bookId = db.insertName("aa");
		long titleId = db.insertTitle(bookId, "bb");
		long contextId = db.insertContext(titleId, "cc");
		System.out.println(bookId);
		System.out.println(titleId);
		System.out.println(contextId);
	}
}
