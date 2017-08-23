package my.learn.designpattern.visitor;

import org.junit.Test;

public class VisitorTest {

	@Test
	public void test() {
		Visitor visitor = new MyVisitor();
		Subject sub = new MySubject();
		sub.accept(visitor);
	}

}
