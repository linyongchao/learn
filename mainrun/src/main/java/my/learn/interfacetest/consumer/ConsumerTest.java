package my.learn.interfacetest.consumer;

import java.util.function.Consumer;

public class ConsumerTest {
	public static void main(String[] args) {
		Student student = new Student(1, "lin", 20);
		System.out.println(student.toString());

		Consumer<Student> c1 = s -> s.setName("chen");
		c1.accept(student);
		System.out.println(student.toString());
	}
}
