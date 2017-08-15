package my.learn.designpattern.adapter.classadapter;

import my.learn.designpattern.adapter.Targetable;

public class Test {
	public static void main(String[] args) {
		Targetable target = new Adapter();
		target.method1();
		target.method2();
	}
}
