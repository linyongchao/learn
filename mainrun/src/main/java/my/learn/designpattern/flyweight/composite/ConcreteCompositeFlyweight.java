package my.learn.designpattern.flyweight.composite;

import java.util.HashMap;
import java.util.Map;

import my.learn.designpattern.flyweight.Flyweight;

public class ConcreteCompositeFlyweight implements Flyweight {

	private Map<Character, Flyweight> map = new HashMap<>();

	/**
	 * 增加一个新的单纯享元对象到聚集中
	 */
	public void add(Character key, Flyweight value) {
		map.put(key, value);
	}

	/**
	 * 外蕴状态作为参数传入到方法中
	 */
	@Override
	public void operation(String state) {
		Flyweight fly = null;
		for (Object o : map.keySet()) {
			fly = map.get(o);
			fly.operation(state);
		}
	}

}
