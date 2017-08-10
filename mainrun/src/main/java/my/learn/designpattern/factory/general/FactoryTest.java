package my.learn.designpattern.factory.general;

import my.learn.designpattern.factory.modal.Sender;

public class FactoryTest {
	public static void main(String[] args) {
		SendFactory factory = new SendFactory();

		Sender produce1 = factory.produce("sms");
		produce1.send();

		Sender produce2 = factory.produce("mail");
		produce2.send();
	}
}
