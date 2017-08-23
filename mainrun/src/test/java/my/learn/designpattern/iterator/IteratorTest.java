package my.learn.designpattern.iterator;

import org.junit.Test;

public class IteratorTest {


	@Test
	public void test() {
		Collection collection = new MyCollection();
		Iterator iterator = collection.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

}
