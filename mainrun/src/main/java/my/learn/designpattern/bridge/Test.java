package my.learn.designpattern.bridge;

public class Test {
	public static void main(String[] args) {
		// 白色
		Color white = new White();
		Shape rectangle = new Rectangle();
		rectangle.setColor(white);
		rectangle.draw();
		Gray gray = new Gray();
		rectangle.setColor(gray);
		rectangle.draw();
		Shape circle = new Circle();
		circle.setColor(white);
		circle.draw();
	}
}
