package my.learn.designpattern.singleton;

/**
 * @Description:
 *               <p>
 *               使用内部类来维护单例的实现，是线程安全的
 *               </p>
 *               <p>
 *               JVM内部的机制能够保证当一个类被加载的时候，这个类的加载过程是线程互斥的
 *               </p>
 * 
 * @author lin
 * @date 2017年8月11日 下午5:00:58
 */
public class SingletonFour {
	/* 私有构造方法，防止被实例化 */
	private SingletonFour() {
	}

	/* 此处使用一个内部类来维护单例 */
	private static class SingletonFactory {
		private static SingletonFour instance = new SingletonFour();
	}

	/* 获取实例 */
	public static SingletonFour getInstance() {
		return SingletonFactory.instance;
	}

	/* 如果该对象被用于序列化，可以保证对象在序列化前后保持一致 */
	public Object readResolve() {
		return getInstance();
	}
}
