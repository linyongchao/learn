package my.learn.jdktest.methodreferences;

import java.util.Arrays;

public class TestObject {
	public static void main(String[] args) {
		Person[] persons = new Person[10];
		ComparisonProvider provider = new ComparisonProvider();
		// lambda表达式
		Arrays.sort(persons, (p1, p2) -> p1.age.compareTo(p2.age));
		// 方法引用，对象的实例方法
		Arrays.sort(persons, provider::compare);
	}
}
