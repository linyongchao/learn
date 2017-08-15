package my.learn.designpattern.adapter.objectadapter;

import my.learn.designpattern.adapter.Source;
import my.learn.designpattern.adapter.Targetable;

public class Test {
	public static void main(String[] args) {
		Source source = new Source();
		Targetable target = new Adapter(source);
		target.method1();
		target.method2();
	}
}
