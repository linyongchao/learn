package my.learn.designpattern.state;

import org.junit.Test;

public class StateTest {

	@Test
	public void test() {
		State state = new State();
		Context context = new Context(state);

		// 设置第一种状态
		state.setValue("state1");
		context.method();

		// 设置第二种状态
		state.setValue("state2");
		context.method();
	}

}
