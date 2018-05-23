package my.learn.book.test;

import my.learn.book.dao.BookWeb;
import my.learn.book.impl.BQG;

public class TestBQG {
	public static void main(String[] args) throws Exception {
		BookWeb bi = new BQG();
		// 唐朝好地主
		// bi.only("/Users/lin/spider/笔趣阁", "9_9805");
		// 大唐贞观第一纨绔
		// bi.only("/Users/lin/spider/笔趣阁", "20_20851");
		// bi.export("/Users/lin/spider/笔趣阁", "大唐贞观第一纨绔");
		// 剑道之王
		// bi.only("/Users/lin/spider/笔趣阁", "4_4878");
		bi.all("/Users/lin/spider/笔趣阁");
		System.out.println("--over--");
	}
}
