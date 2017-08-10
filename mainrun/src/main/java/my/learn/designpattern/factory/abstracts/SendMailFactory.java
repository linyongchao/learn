package my.learn.designpattern.factory.abstracts;

import my.learn.designpattern.factory.modal.MailSender;
import my.learn.designpattern.factory.modal.Sender;

public class SendMailFactory implements Provider {

	@Override
	public Sender produce() {
		return new MailSender();
	}

}
