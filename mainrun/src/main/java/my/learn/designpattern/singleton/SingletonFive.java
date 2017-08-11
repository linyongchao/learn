package my.learn.designpattern.singleton;

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
