package my.learn.jdktest.predicatetest;

import java.util.function.Consumer;
import java.util.function.Predicate;

import my.learn.jdktest.predicatetest.Student.Sex;

public class Test3 {

	public static void main(String[] args) {
		Student s1 = new Student("lin", Sex.MALE, 80);
		Student s2 = new Student("chen", Sex.FEMALE, 50);
		System.out.println("计算前：" + s1.toString());
		System.out.println("计算前：" + s2.toString());

		Predicate<Student> isPass = s -> s.grade >= 60;
		Consumer<Student> discount = s -> s.tuition = s.tuition * (100 - s.grade) / 100;

		s1.actualTuition(s1, isPass, discount);
		s2.actualTuition(s2, isPass, discount);
		System.out.println("计算后：" + s1.toString());
		System.out.println("计算后：" + s2.toString());
	}

}
