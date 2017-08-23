package my.learn.designpattern.flyweight.simple;

import java.util.HashMap;
import java.util.Map;

import my.learn.designpattern.flyweight.ConcreteFlyweight;
import my.learn.designpattern.flyweight.Flyweight;

public class FlyweightFactory {
	private Map<Character, Flyweight> map = new HashMap<>();

	public Flyweight factory(Character state) {
		Flyweight fly = map.get(state);
		if (fly == null) {
			fly = new ConcreteFlyweight(state);
			map.put(state, fly);
		}
		return fly;
	}

}
