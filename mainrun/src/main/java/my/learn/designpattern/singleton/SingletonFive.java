package my.learn.designpattern.singleton;

/**
 * @Description: 非懒加载，线程安全，JVM内部的机制能够保证当一个类被加载的时候，这个类的加载过程是线程互斥的
 * @author lin
 * @date 2017年8月11日 下午6:10:33
 */
public class SingletonFive {
	private static SingletonFive instance = new SingletonFive();

	private SingletonFive() {
	}

	public static SingletonFive getInstance() {
		return instance;
	}
}
