package my.learn.designpattern.singleton;

public class SingletonFourTest extends Thread {
	@Override
	public void run() {
		System.out.println(SingletonFour.getInstance().hashCode());
	}

	public static void main(String[] args) {

		SingletonFourTest[] mts = new SingletonFourTest[10];
		for (int i = 0; i < mts.length; i++) {
			mts[i] = new SingletonFourTest();
		}

		for (int j = 0; j < mts.length; j++) {
			mts[j].start();
		}
	}
}
