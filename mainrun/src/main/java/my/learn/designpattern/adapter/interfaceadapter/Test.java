package my.learn.designpattern.adapter.interfaceadapter;

import my.learn.designpattern.adapter.Targetable;

public class Test {
	public static void main(String[] args) {
		Targetable source1 = new Source1();
		source1.method1();
		source1.method2();
		System.out.println("--");
		Targetable source2 = new Source2();
		source2.method1();
		source2.method2();

	}
}
