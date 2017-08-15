package my.learn.designpattern.adapter.objectadapter;

import my.learn.designpattern.adapter.Source;
import my.learn.designpattern.adapter.Targetable;

public class Adapter implements Targetable {
	private Source source;

	public Adapter(Source source) {
		super();
		this.source = source;
	}

	@Override
	public void method1() {
		source.method1();
	}

	@Override
	public void method2() {
		System.out.println("from adapter");
	}

}
