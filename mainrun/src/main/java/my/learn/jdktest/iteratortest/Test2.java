package my.learn.jdktest.iteratortest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Test2 {
	public static void main(String[] args) {
		List<Student> b = new ArrayList<Student>(
				Arrays.asList(new Student("lin"), new Student("chen"), new Student("remove")));
		b.forEach(s -> System.out.print(s.toString()));
		System.out.println();
		Iterator<Student> iterator = b.iterator();
		while (iterator.hasNext()) {
			Student next = iterator.next();
			if (next.getName().startsWith("r")) {
				iterator.remove();
			}
		}
		b.forEach(s -> System.out.print(s.toString()));
	}
}
