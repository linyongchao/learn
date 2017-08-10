package my.learn.designpattern.factory.abstracts;

import my.learn.designpattern.factory.modal.Sender;

/**
 * @Description:抽象工厂
 * @author lin
 * @date 2017年8月10日 下午8:38:11
 */
public class FactoryTest {
	public static void main(String[] args) {
		Provider factory = new SendMailFactory();
		Sender sender = factory.produce();
		sender.send();
	}
}
