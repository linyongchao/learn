package my.learn.book.dao;

import java.util.List;

import my.learn.book.modal.Book;

public interface BookDb {
	/**
	 * 插入书名
	 * 
	 * @param name
	 * @return
	 * @author lin
	 * @date 2018年2月6日 下午5:04:18
	 */
	public long insertName(String name);

	/**
	 * 插入书标题
	 * 
	 * @param bookId
	 * @param title
	 * @return
	 * @author lin
	 * @date 2018年2月6日 下午5:04:27
	 */
	public long insertTitle(long bookId, String title);

	/**
	 * 插入书正文
	 * 
	 * @param titleId
	 * @param context
	 * @return
	 * @author lin
	 * @date 2018年2月6日 下午5:04:38
	 */
	public long insertContext(long titleId, String context);

	/**
	 * 书名是否存在，存在返回id，否则返回0
	 * 
	 * @param name
	 * @return
	 * @author lin
	 * @date 2018年2月6日 下午5:04:47
	 */
	public long existName(String name);

	/**
	 * 标题是否存在，存在返回id，否则返回0
	 * 
	 * @param bookId
	 * @param title
	 * @return
	 * @author lin
	 * @date 2018年2月6日 下午5:04:57
	 */
	public long existTitle(long bookId, String title);

	/**
	 * 正文是否存在，存在返回id，否则返回0
	 * 
	 * @param titleId
	 * @return
	 * @author lin
	 * @date 2018年2月6日 下午5:05:03
	 */
	public long existContext(long titleId);

	/**
	 * 查询一本书，包含其所有章节
	 * 
	 * @param bookId
	 * @return
	 * @author lin
	 * @date 2018年2月6日 下午5:38:00
	 */
	public List<Book> getBook(Long bookId);

	/**
	 * 查询某一本书
	 * 
	 * @param name
	 * @return
	 * @author lin
	 * @date 2018年2月8日 下午2:17:05
	 */
	public Book getBook(String name);

	/**
	 * 修改某一本书
	 * 
	 * @param bookId
	 * @param isEnd
	 * @param isExport
	 * @return
	 * @author lin
	 * @date 2018年2月8日 下午2:18:50
	 */
	public int updateBook(Long bookId, boolean isEnd, boolean isExport);

	/**
	 * 删除某一本书
	 * 
	 * 
	 * @param bookId
	 * @return
	 * @author lin
	 * @date 2019年6月8日 上午2:39:38
	 */
	public int deleteBook(Long bookId);

}
