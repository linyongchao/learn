package my.learn.designpattern.observer;

public class SubjectOfMy extends SubjectAbstract {

	@Override
	public void operation() {
		System.out.println("update self");
		notifyObservers();
	}

}
