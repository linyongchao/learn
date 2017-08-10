package my.learn.designpattern.factory.stat;

import my.learn.designpattern.factory.modal.Sender;

public class FactoryTest {
	public static void main(String[] args) {
		Sender produce1 = SendFactory.produceMail();
		produce1.send();

		Sender produce2 = SendFactory.produceSms();
		produce2.send();
	}
}
