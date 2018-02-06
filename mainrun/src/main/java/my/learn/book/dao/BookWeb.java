package my.learn.book.dao;

import java.io.File;
import java.util.List;

import my.learn.book.impl.BookDbImpl;
import my.learn.book.modal.Book;
import my.learn.utils.FileTools;

public interface BookWeb {

	/**
	 * 某一本书
	 * 
	 * @param path
	 * @param book
	 * @throws Exception
	 * @author lin
	 * @date 2018年2月3日 下午10:22:07
	 */
	public void only(String path, String book) throws Exception;

	/**
	 * 所有书
	 * 
	 * @param folder
	 * @author lin
	 * @date 2018年2月3日 下午10:22:31
	 */
	public void all(String folder);

	/**
	 * 从数据库导出某一本书
	 * 
	 * @param path
	 * @param name
	 * @author lin
	 * @date 2018年2月6日 下午5:48:58
	 */
	default void export(String path, String name) {
		BookDb db = new BookDbImpl();
		long bookId = db.existName(name);
		if (bookId == 0) {
			return;
		}
		List<Book> books = db.getBook(bookId);
		StringBuffer sb = new StringBuffer();
		sb.append(name).append("\r\n\r\n");
		for (Book book : books) {
			sb.append(book.getTitle()).append("\r\n\r\n");
			sb.append(book.getContext()).append("\r\n\r\n");
		}
		FileTools.appendWrite(path + File.separatorChar + name + ".txt", sb.toString());
	}

}
