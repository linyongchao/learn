package my.learn.designpattern.factory.modal;

public class SmsSender implements Sender {

	@Override
	public void send() {
		System.out.println("this is Sms Sender");
	}

}
