package my.learn.jdktest.methodreferences;

import java.util.Arrays;
import java.util.Comparator;

public class TestStatic {
	public static void main(String[] args) {
		Person[] persons = new Person[10];
		// 匿名内部类
		Arrays.sort(persons, new Comparator<Person>() {
			@Override
			public int compare(Person p1, Person p2) {
				return p1.age.compareTo(p2.age);
			}
		});
		// lambda表达式
		Arrays.sort(persons, (p1, p2) -> p1.age.compareTo(p2.age));
		// lambda和类的静态方法
		Arrays.sort(persons, (p1, p2) -> Person.compareByAge(p1, p2));
		// 方法引用，静态方法
		Arrays.sort(persons, Person::compareByAge);
	}
}
