package my.learn.designpattern.proxy;

public class Source implements Sourceable {

	@Override
	public void method() {
		System.out.println("from source");
	}

}
