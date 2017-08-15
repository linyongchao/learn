package my.learn.designpattern.adapter.classadapter;

import my.learn.designpattern.adapter.Source;
import my.learn.designpattern.adapter.Targetable;

public class Adapter extends Source implements Targetable {

	@Override
	public void method2() {
		System.out.println("from adapter");
	}


}
