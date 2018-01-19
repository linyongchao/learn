package my.learn.jdktest.iteratortest;

import java.util.Arrays;
import java.util.List;

/**
 * forEachRemaining
 * 
 * @author lin
 * @date 2018年1月19日 上午10:53:40
 */
public class Test {
	public static void main(String[] args) {
		List<Student> b = Arrays.asList(new Student("lin"), new Student("chen"));
		b.forEach(s -> System.out.println(s.toString()));
		b.iterator().forEachRemaining(s -> s.setName(s.getName() + "-baby"));
		b.forEach(s -> System.out.println(s.toString()));
	}
}
