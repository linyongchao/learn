package my.learn.designpattern.singleton;

/**
 * @Description:加入synchronized关键字，线程安全，但是性能比较低
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
