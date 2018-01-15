package my.learn.jdktest.lambda;

public class RunnableTest {
	public static void main(String[] args) {
		// 传统方式实现Runnable接口
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("before JDK1.8");
			}
		}).start();

		// 使用lambda表达式替换匿名类
		new Thread(() -> System.out.println("use lambda")).start();
	}
}
