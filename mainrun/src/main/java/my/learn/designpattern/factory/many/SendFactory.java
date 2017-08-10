package my.learn.designpattern.factory.many;

import my.learn.designpattern.factory.modal.MailSender;
import my.learn.designpattern.factory.modal.Sender;
import my.learn.designpattern.factory.modal.SmsSender;

public class SendFactory {
	public Sender produceMail() {
		return new MailSender();
	}

	public Sender produceSms() {
		return new SmsSender();
	}
}
