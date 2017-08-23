package my.learn.designpattern.command;

import org.junit.Test;

public class CommandTest {

	@Test
	public void test() {
		Receiver receiver = new Receiver();
		Command cmd = new MyCommand(receiver);
		Invoker invoker = new Invoker(cmd);
		invoker.action();
	}

}
