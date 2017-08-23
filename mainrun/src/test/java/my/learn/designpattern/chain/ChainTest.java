package my.learn.designpattern.chain;

import org.junit.Test;

public class ChainTest {

	@Test
	public void test() {
		MyHandler h1 = new MyHandler("h1");
		MyHandler h2 = new MyHandler("h2");
		MyHandler h3 = new MyHandler("h3");
		h1.setHandler(h2);
		h2.setHandler(h3);

		h1.operator();
	}

}
