package my.learn.designpattern.flyweight.simple;

import org.junit.Before;
import org.junit.Test;

import my.learn.designpattern.flyweight.Flyweight;

public class FlyweightFactoryTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		FlyweightFactory factory = new FlyweightFactory();
		Flyweight fly = factory.factory(new Character('a'));
		System.out.println(fly.hashCode());
		fly.operation("first");
		fly = factory.factory(new Character('b'));
		System.out.println(fly.hashCode());
		fly.operation("second");
		fly = factory.factory(new Character('a'));
		System.out.println(fly.hashCode());
		fly.operation("third");
	}

}
