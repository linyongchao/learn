package my.learn.designpattern.singleton;

public class SingletonOneTest extends Thread {
	@Override
	public void run() {
		System.out.println(SingletonOne.getInstance().hashCode());
	}

	public static void main(String[] args) {

		SingletonOneTest[] mts = new SingletonOneTest[10];
		for (int i = 0; i < mts.length; i++) {
			mts[i] = new SingletonOneTest();
		}

		for (int j = 0; j < mts.length; j++) {
			mts[j].start();
		}
	}
}
