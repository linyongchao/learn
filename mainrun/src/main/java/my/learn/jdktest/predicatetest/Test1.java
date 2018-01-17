package my.learn.jdktest.predicatetest;

import java.util.function.Predicate;

import my.learn.jdktest.predicatetest.Student.Sex;

public class Test1 {

	public static void main(String[] args) {
		Student s1 = new Student("lin", Sex.MALE, 80);
		Student s2 = new Student("chen", Sex.FEMALE, 50);

		Predicate<Student> grade = s -> s.grade > 60;

		System.out.println("test1=" + grade.test(s1));
		System.out.println("test2=" + grade.test(s2));

		System.out.println("negate1=" + grade.negate().test(s1));
		System.out.println("negate2=" + grade.negate().test(s2));

		Predicate<Student> equal = Predicate.isEqual(s1);
		System.out.println("isEqual1=" + equal.test(s1));
		System.out.println("isEqual2=" + equal.test(s2));
	}

}
