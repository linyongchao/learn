package my.learn.designpattern.singleton;

public class SingletonThreeTest extends Thread {
	@Override
	public void run() {
		System.out.println(SingletonThree.getInstance().hashCode());
	}

	public static void main(String[] args) {

		SingletonThreeTest[] mts = new SingletonThreeTest[10];
		for (int i = 0; i < mts.length; i++) {
			mts[i] = new SingletonThreeTest();
		}

		for (int j = 0; j < mts.length; j++) {
			mts[j].start();
		}
	}
}
