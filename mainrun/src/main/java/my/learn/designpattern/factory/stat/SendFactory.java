package my.learn.designpattern.factory.stat;

import my.learn.designpattern.factory.modal.MailSender;
import my.learn.designpattern.factory.modal.Sender;
import my.learn.designpattern.factory.modal.SmsSender;

/**
 * @Description:静态工厂
 * @author lin
 * @date 2017年8月10日 下午8:24:11
 */
public class SendFactory {
	public static Sender produceMail() {
		return new MailSender();
	}

	public static Sender produceSms() {
		return new SmsSender();
	}
}
