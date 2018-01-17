package my.learn.jdktest.predicatetest;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class Student {

	String name;
	Sex sex;
	int grade;
	// 基础学费
	double tuition = 10000.0;

	public Student(String name, Sex sex, int grade) {
		this.name = name;
		this.sex = sex;
		this.grade = grade;
	}

	enum Sex {
		MALE, FEMALE
	}

	public void actualTuition(Student student, Predicate<Student> isPass, Consumer<Student> discount) {
		// 一旦考试及格就可以学费打折
		if (isPass.test(student)) {
			discount.accept(student);
		}
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", sex=" + sex + ", grade=" + grade + ", tuition=" + tuition + "]";
	}

}
