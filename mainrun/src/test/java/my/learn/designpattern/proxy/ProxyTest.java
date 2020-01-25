package my.learn.designpattern.proxy;

import org.junit.Test;

public class ProxyTest {

    @Test
    public void test0() {
        Sourceable proxy = new Source();
        proxy.method();
    }

    @Test
    public void test() {
        Sourceable proxy = new Proxy();
        proxy.method();
    }

    @Test
    public void test2() {
        Sourceable proxy = new Proxy(new Source());
        proxy.method();
    }

}
