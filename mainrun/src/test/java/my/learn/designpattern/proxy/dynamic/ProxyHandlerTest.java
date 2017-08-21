package my.learn.designpattern.proxy.dynamic;

import org.junit.Test;

public class ProxyHandlerTest {

	@Test
	public void test() {
		Star huangBo = new Star("HuangBo");
		ProxyHandler proxyHandler = new ProxyHandler(huangBo);
		Object proxy = proxyHandler.getProxy();
		IMovieStar agent = (IMovieStar) proxy;
		agent.movieShow(10000);
		agent.tvShow(50);

		ISingerStar sing = (ISingerStar) proxy;
		sing.sing(100);
	}

}
