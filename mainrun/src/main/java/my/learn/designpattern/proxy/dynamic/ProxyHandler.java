package my.learn.designpattern.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyHandler implements InvocationHandler {
	private Object target;

	public ProxyHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		String name = method.getName();
		if (name.equals("movieShow") || name.equals("tvShow")) {
			if (args[0] instanceof Integer && (int) args[0] < 100) {
				System.out.println(((int) args[0]) + "块钱？！雇不了演员！");
				return null;
			}
		}
		return method.invoke(target, args);
	}

	public Object getProxy() {
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}

}
