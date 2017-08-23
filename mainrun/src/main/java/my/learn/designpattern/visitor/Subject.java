package my.learn.designpattern.visitor;

public interface Subject {

	// accept方法，接受将要访问它的对象
	public void accept(Visitor visitor);

	// getSubject()获取将要被访问的属性
	public String getSubject();
}
