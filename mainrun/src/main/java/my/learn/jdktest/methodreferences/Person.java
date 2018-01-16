package my.learn.jdktest.methodreferences;

import java.util.Date;

public class Person {
	Date age;

	public static int compareByAge(Person p1, Person p2) {
		return p1.age.compareTo(p2.age);
	}
}
