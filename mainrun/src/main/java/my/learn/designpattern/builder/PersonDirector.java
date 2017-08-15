package my.learn.designpattern.builder;

/**
 * @Description:构造一个使用Builder接口的对象。
 * @author lin
 * @date 2017年8月15日 下午4:20:14
 */
public class PersonDirector {
	public Person constructPerson(PersonBuilder pb) {
		pb.buildHead();
		pb.buildBody();
		pb.buildFoot();
		return pb.buildPerson();
	}
}
