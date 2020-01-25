package my.learn.designpattern.singleton;

/**
 * @Description: 懒加载，线程安全，且高性能，双重校验锁（DCL，即 double-checked locking）
 * @author lin
 * @date 2017年8月11日 下午4:51:50
 */
public class SingletonThree {
	private volatile static SingletonThree instance = null;

	private SingletonThree() {
	}

	public static SingletonThree getInstance() {
		if (instance == null) {
			synchronized (SingletonThree.class) {
				if (instance == null) {
					instance = new SingletonThree();
				}
			}
		}
		return instance;
	}
}
