package my.learn.designpattern.observer;

import java.util.Enumeration;
import java.util.Vector;

public abstract class SubjectAbstract implements Subject {
	private Vector<Observer> vector = new Vector<>();

	@Override
	public void add(Observer observer) {
		vector.add(observer);
	}

	@Override
	public void del(Observer observer) {
		vector.remove(observer);
	}

	@Override
	public void notifyObservers() {
		Enumeration<Observer> elements = vector.elements();
		while (elements.hasMoreElements()) {
			elements.nextElement().update();
		}

	}

}
