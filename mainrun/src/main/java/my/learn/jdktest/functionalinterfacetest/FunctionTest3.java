package my.learn.jdktest.functionalinterfacetest;

/**
 * 如果抽象方法是重写Object对象中的方法则不列入抽象方法的统计<br>
 * FunctionTest3依然是一个有且仅有一个抽象方法的接口
 * 
 * @author lin
 * @date 2018年1月11日 下午6:48:10
 */
@FunctionalInterface
public interface FunctionTest3 {
	public void test();

	@Override
	int hashCode();

	@Override
	boolean equals(Object obj);

	String toString();
}
