package my.learn.utils.math;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class SquareTest {

	private static Calculator calculator = new Calculator();
	private int param;
	private int result;

	@Parameters
	public static Collection<?> data() {
		System.out.println("-1-");
		return Arrays.asList(new Object[][] { { 2, 4 }, { 0, 0 }, { -3, 9 }, });
	}

	// 构造函数，对变量进行初始化
	public SquareTest(int param, int result) {
		System.out.println("-2-");
		this.param = param;
		this.result = result;
	}

	@Test
	public void square() {
		System.out.println("-3-");
		calculator.square(param);
		assertEquals(result, calculator.getResult());
	}

}