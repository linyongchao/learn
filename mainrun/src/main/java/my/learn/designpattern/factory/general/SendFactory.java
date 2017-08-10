package my.learn.designpattern.factory.general;

import my.learn.designpattern.factory.modal.MailSender;
import my.learn.designpattern.factory.modal.Sender;
import my.learn.designpattern.factory.modal.SmsSender;

public class SendFactory {
	public Sender produce(String type) {
		if ("mail".equals(type)) {
			return new MailSender();
		}
		if ("sms".equals(type)) {
			return new SmsSender();
		}
		System.out.println("type error");
		return null;
	}
}
