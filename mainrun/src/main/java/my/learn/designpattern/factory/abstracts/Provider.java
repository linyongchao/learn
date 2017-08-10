package my.learn.designpattern.factory.abstracts;

import my.learn.designpattern.factory.modal.Sender;

public interface Provider {
	public Sender produce();
}
