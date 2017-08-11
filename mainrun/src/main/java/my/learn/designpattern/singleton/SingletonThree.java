package my.learn.designpattern.singleton;

/**
 * @Description:看起来线程安全，实际上不安全
 * @author lin
 * @date 2017年8月11日 下午4:51:50
 */
public class SingletonThree {
	private static SingletonThree instance = null;

	private SingletonThree() {
	}

	public static SingletonThree getInstance() {
		if (instance == null) {
			synchronized (instance) {
				if (instance == null) {
					instance = new SingletonThree();
				}
			}
		}
		return instance;
	}
}
