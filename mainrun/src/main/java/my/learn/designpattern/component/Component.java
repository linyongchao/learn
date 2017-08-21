package my.learn.designpattern.component;

/**
 * @Description:组合中的对象声明接口，在适当的情况下，实现所有类共有接口的默认行为
 * @author lin
 * @date 2017年8月21日 下午2:25:00
 */
public abstract class Component {
	protected String name;

	public Component(String name) {
		this.name = name;
	}

	public abstract void add(Component c);

	public abstract void remove(Component c);

	public abstract void display(int depth);
}
