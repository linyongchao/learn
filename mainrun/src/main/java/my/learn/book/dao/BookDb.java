package my.learn.book.dao;

public interface BookDb {
	public long insertName(String name);

	public long insertTitle(long bookId, String title);

	public long insertContext(long titleId, String context);

}
