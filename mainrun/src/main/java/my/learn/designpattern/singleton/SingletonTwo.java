package my.learn.designpattern.singleton;

/**
 * @Description: 懒加载，线程安全，但性能较低
 * @author lin
 * @date 2017年8月11日 下午4:48:56
 */
public class SingletonTwo {
	private static SingletonTwo instance = null;

	private SingletonTwo() {
	}

	public static synchronized SingletonTwo getInstance() {
		if (instance == null) {
			instance = new SingletonTwo();
		}
		return instance;
	}
}
