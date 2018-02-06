package my.learn.book.dao;

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

}
