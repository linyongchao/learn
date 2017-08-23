package my.learn.designpattern.flyweight.composite;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import my.learn.designpattern.flyweight.ConcreteFlyweight;
import my.learn.designpattern.flyweight.Flyweight;

public class FlyweightFactory {
	private Map<Character, Flyweight> map = new HashMap<>();

	/**
	 * 复合享元工厂方法
	 */
	public Flyweight factory(List<Character> compositeState) {
		ConcreteCompositeFlyweight compositeFly = new ConcreteCompositeFlyweight();
		for (Character state : compositeState) {
			compositeFly.add(state, this.factory(state));
		}
		return compositeFly;
	}

	/**
	 * 单纯享元工厂方法
	 */
	public Flyweight factory(Character state) {
		Flyweight fly = map.get(state);
		if (fly == null) {
			fly = new ConcreteFlyweight(state);
			map.put(state, fly);
		}
		return fly;
	}
}
