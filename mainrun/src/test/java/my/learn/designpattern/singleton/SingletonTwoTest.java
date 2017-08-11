package my.learn.designpattern.singleton;

public class SingletonTwoTest extends Thread {
	@Override
	public void run() {
		System.out.println(SingletonTwo.getInstance().hashCode());
	}

	public static void main(String[] args) {

		SingletonTwoTest[] mts = new SingletonTwoTest[10];
		for (int i = 0; i < mts.length; i++) {
			mts[i] = new SingletonTwoTest();
		}

		for (int j = 0; j < mts.length; j++) {
			mts[j].start();
		}
	}
}
