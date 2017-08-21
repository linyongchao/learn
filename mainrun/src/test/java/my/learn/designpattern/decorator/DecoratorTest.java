package my.learn.designpattern.decorator;

import org.junit.Test;

public class DecoratorTest {

	@Test
	public void testMethod() {
		Source source = new Source();
		Decorator decorator = new Decorator(source);
		decorator.method();
	}

}
