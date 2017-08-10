package my.learn.designpattern.factory.abstracts;

import my.learn.designpattern.factory.modal.Sender;
import my.learn.designpattern.factory.modal.SmsSender;

public class SendSmsFactory implements Provider {

	@Override
	public Sender produce() {
		return new SmsSender();
	}

}
