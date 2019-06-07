package my.learn.book.test;

import my.learn.book.dao.BookDb;
import my.learn.book.impl.BookDbImpl;

public class TestDeleteBook {
	public static void main(String[] args) {
		BookDb db = new BookDbImpl();
		int result = db.deleteBook(27L);
		System.out.println(result);
	}
}
