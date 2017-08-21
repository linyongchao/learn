package my.learn.designpattern.proxy.dynamic;

public interface IMovieStar {
	/**
	 * 演电影
	 * 
	 * @param money
	 *            演电影的片酬
	 */
	void movieShow(int money);

	/**
	 * 演电视剧
	 * 
	 * @param money
	 *            演电视剧的片酬
	 */
	void tvShow(int money);
}
