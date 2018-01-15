package my.learn.jdktest.functiontest;

/**
 * 静态方法和默认方法也不会被认为是抽象方法
 * 
 * @author lin
 * @date 2018年1月11日 下午6:48:10
 */
@FunctionalInterface
public interface FunctionTest4 {
	public void test();

	default String getName() {
		return this.getName();
	}

	static void print() {
		System.out.println("now in FunctionTest4");
	}
}
