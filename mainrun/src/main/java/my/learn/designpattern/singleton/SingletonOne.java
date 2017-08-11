package my.learn.designpattern.singleton;

/**
 * @Description:线程不安全
 * @author lin
 * @date 2017年8月11日 下午4:46:39
 */
public class SingletonOne {
	private static SingletonOne instance = null;

	private SingletonOne() {
	}

	public static SingletonOne getInstance() {
		if (instance == null) {
			instance = new SingletonOne();
		}
		return instance;
	}

}
