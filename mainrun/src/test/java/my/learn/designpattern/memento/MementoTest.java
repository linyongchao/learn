package my.learn.designpattern.memento;

import org.junit.Test;

public class MementoTest {

	@Test
	public void test() {
		// 创建原始类
		Original original = new Original("egg");
		// 创建备忘录
		Storage storage = new Storage(original.createMemento());
		System.out.println("初始化状态为：" + original.getValue());
		// 修改原始类的状态
		original.setValue("niu");
		System.out.println("修改后的状态为：" + original.getValue());
		// 回复原始类的状态
		original.restoreMemento(storage.getMemento());
		System.out.println("恢复后的状态为：" + original.getValue());
	}

}
