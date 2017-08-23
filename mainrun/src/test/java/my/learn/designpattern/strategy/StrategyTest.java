package my.learn.designpattern.strategy;

import org.junit.Test;

import junit.framework.Assert;

public class StrategyTest {


	@Test
	public void plus() {
		String exp = "2+8";
		ICalculator cal = new Plus();
		int result = cal.calculate(exp);
		Assert.assertEquals(10, result);
	}

	@Test
	public void minus() {
		String exp = "8-2";
		ICalculator cal = new Minus();
		int result = cal.calculate(exp);
		Assert.assertEquals(6, result);
	}

	@Test
	public void multiply() {
		String exp = "2*8";
		ICalculator cal = new Multiply();
		int result = cal.calculate(exp);
		Assert.assertEquals(16, result);
	}

}
