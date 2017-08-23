package my.learn.designpattern.observer;

import org.junit.Test;

public class SubjectOfMyTest {

	@Test
	public void test() {
		SubjectOfMy sub = new SubjectOfMy();
		sub.add(new Observer1());
		sub.add(new Observer2());
		sub.operation();
	}

}
