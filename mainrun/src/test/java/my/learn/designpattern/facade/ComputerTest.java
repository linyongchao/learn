package my.learn.designpattern.facade;

import org.junit.Before;
import org.junit.Test;

public class ComputerTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		Computer computer = new Computer();
		computer.startup();
		System.out.println("---");
		computer.shutdown();
	}

}
