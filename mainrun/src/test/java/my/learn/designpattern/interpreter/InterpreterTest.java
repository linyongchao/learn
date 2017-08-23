package my.learn.designpattern.interpreter;

import org.junit.Test;

import junit.framework.Assert;

public class InterpreterTest {

	@Test
	public void test() {
		Context c1 = new Context(2, 9);
		int r1 = new Plus().interpret(c1);
		Assert.assertEquals(11, r1);
		Context c2 = new Context(r1, 8);
		new Minus().interpret(c2);
		int r2 = new Minus().interpret(c2);
		Assert.assertEquals(3, r2);
	}

}
