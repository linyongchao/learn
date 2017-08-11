package my.learn.designpattern.singleton;

/**
 * @Description:线程安全
 * @author lin
 * @date 2017年8月11日 下午6:10:33
 */
public class SingletonFive {
	private static SingletonFive instance = null;

	private SingletonFive() {
	}

	private static synchronized void syncInit() {
		if (instance == null) {
			instance = new SingletonFive();
		}
	}

	public static SingletonFive getInstance() {
		if (instance == null) {
			syncInit();
		}
		return instance;
	}
}
