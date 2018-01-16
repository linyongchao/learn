package my.learn.jdktest.methodreferences;

import java.util.Arrays;
import java.util.Comparator;

public class TestInstance {
	public static void main(String[] args) {
		String[] strings = { "Hello", "World" };
		// 匿名内部类
		Arrays.sort(strings, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s1.compareTo(s2);
			}
		});
		// lambda表达式
		Arrays.sort(strings, (s1, s2) -> s1.compareTo(s2));
		// 方法引用，类型的任意对象的实例方法
		Arrays.sort(strings, String::compareTo);
	}
}
