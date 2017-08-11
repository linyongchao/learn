package my.learn.designpattern.singleton;

import java.util.Vector;

/**
 * @Description:采用"影子实例"的办法为单例对象的属性同步更新
 * @author lin
 * @date 2017年8月11日 下午5:19:11
 */
public class SingletonTest {
	private static SingletonTest instance = null;
	private Vector<?> properties = null;

	public Vector<?> getProperties() {
		return properties;
	}

	private SingletonTest() {
	}

	private static synchronized void syncInit() {
		if (instance == null) {
			instance = new SingletonTest();
		}
	}

	public static SingletonTest getInstance() {
		if (instance == null) {
			syncInit();
		}
		return instance;
	}

	public void updateProperties() {
		SingletonTest shadow = new SingletonTest();
		properties = shadow.getProperties();
	}

}
