package my.learn.designpattern.proxy;

public class Proxy implements Sourceable {
	private Source source;

	public Proxy() {
		super();
		this.source = new Source();
	}

	public Proxy(Source source) {
		this.source = source;
	}

	@Override
	public void method() {
		System.out.println("before proxy");
		source.method();
		System.out.println("after proxy");

	}

}
