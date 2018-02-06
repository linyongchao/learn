package my.learn.book.test;

import my.learn.book.dao.BookDb;
import my.learn.book.dao.BookWeb;
import my.learn.book.impl.BQG;
import my.learn.book.impl.BookDbImpl;

public class TestBookDbImpl {
	public static void main(String[] args) {
		// testInsert();
		testExist();
		testExport();
		System.out.println("--over--");
	}

	public static void testInsert() {
		BookDb db = new BookDbImpl();
		long bookId = db.insertName("aa");
		long titleId = db.insertTitle(bookId, "bb");
		long contextId = db.insertContext(titleId, "cc");
		System.out.println(bookId);
		System.out.println(titleId);
		System.out.println(contextId);
	}

	public static void testExist() {
		BookDb db = new BookDbImpl();
		long bookId1 = db.existName("唐朝好地主");
		long bookId2 = db.existName("朝思暮想");
		System.out.println(bookId1);
		System.out.println(bookId2);

		long titleId1 = db.existTitle(bookId1, "第一章 武德四年");
		long titleId2 = db.existTitle(bookId1, "朝三暮四");
		System.out.println(titleId1);
		System.out.println(titleId2);

		long contextId1 = db.existContext(titleId1);
		long contextId2 = db.existContext(12345L);
		System.out.println(contextId1);
		System.out.println(contextId2);
	}

	public static void testExport() {
		BookWeb db = new BQG();
		db.export("/Users/lin", "唐朝好地主");
	}
}
