package my.learn.designpattern.singleton;

public class SingletonFiveTest extends Thread {
	@Override
	public void run() {
		System.out.println(SingletonFive.getInstance().hashCode());
	}

	public static void main(String[] args) {

		SingletonFiveTest[] mts = new SingletonFiveTest[10];
		for (int i = 0; i < mts.length; i++) {
			mts[i] = new SingletonFiveTest();
		}

		for (int j = 0; j < mts.length; j++) {
			mts[j].start();
		}
	}
}
