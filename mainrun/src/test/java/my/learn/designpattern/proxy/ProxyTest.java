package my.learn.designpattern.proxy;

import org.junit.Before;
import org.junit.Test;

public class ProxyTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		Proxy proxy = new Proxy();
		proxy.method();
	}

}
