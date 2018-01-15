package my.learn.interfacetest.consumer;

import java.util.function.Consumer;

public class ConsumerAndThenTest {
	public static void main(String[] args) {
		Student student = new Student(1, "lin", 20);
		System.out.println(student.toString());

		Consumer<Student> c1 = s -> s.setId(2);
		Consumer<Student> c2 = s -> s.setName("chen");
		Consumer<Student> c3 = s -> s.setAge(18);
		c3.andThen(c2).andThen(c1).accept(student);
		System.out.println(student.toString());
	}
}
