package my.learn.designpattern.template;

import org.junit.Test;

import junit.framework.Assert;

public class TemplateTest {

	@Test
	public void test() {
		String exp = "8+8";
		AbstractCalculator cal = new Plus();
		int result = cal.calculate(exp, "\\+");
		Assert.assertEquals(16, result);
	}

}
