package my.learn.designpattern.factory.many;

import my.learn.designpattern.factory.modal.Sender;

public class FactoryTest {
	public static void main(String[] args) {
		SendFactory factory = new SendFactory();

		Sender produce1 = factory.produceMail();
		produce1.send();

		Sender produce2 = factory.produceSms();
		produce2.send();
	}
}
