package my.learn.jdktest.predicatetest;

import java.util.function.Predicate;

import my.learn.jdktest.predicatetest.Student.Sex;

public class Test2 {

	public static void main(String[] args) {
		Student s1 = new Student("lin", Sex.MALE, 80);
		Student s2 = new Student("chen", Sex.FEMALE, 50);

		Predicate<Student> grade = s -> s.grade > 60;
		Predicate<Student> sex = s -> s.sex == Sex.FEMALE;
		Predicate<Student> name = s -> s.name.startsWith("c");

		Predicate<Student> and = grade.and(sex).and(name);
		Predicate<Student> or = grade.or(sex).or(name);

		System.out.println("and1=" + and.test(s1));
		System.out.println("and2=" + and.test(s2));

		System.out.println("or1=" + or.test(s1));
		System.out.println("or2=" + or.test(s2));
	}

}
