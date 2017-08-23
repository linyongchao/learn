package my.learn.designpattern.flyweight;

public class ConcreteFlyweight implements Flyweight {
	private Character inState = null;

	/**
	 * 构造函数，内蕴状态做为参数传入
	 * 
	 * @param state
	 */
	public ConcreteFlyweight(Character state) {
		this.inState = state;
	}

	/**
	 * 
	 */
	@Override
	public void operation(String state) {
		System.out.println("Intrinsic State = " + this.inState);
		System.out.println("Extrinsic State = " + state);
	}


}
