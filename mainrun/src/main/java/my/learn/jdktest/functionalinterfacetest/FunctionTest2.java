package my.learn.jdktest.functionalinterfacetest;

/**
 * 有多个抽象方法的接口无法被声明为@FunctionalInterface，会报错
 * 
 * @author lin
 * @date 2018年1月11日 下午6:48:44
 */
// @FunctionalInterface
public interface FunctionTest2 {
	public void test1();

	public void test2();
}
