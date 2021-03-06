package my.learn.designpattern.builder;

/**
 * @Description:实现Builder的接口以构造和装配该产品的各个部件<br>
 * 定义并明确它所创建的表示<br>
 * 提供一个检索产品的接口。
 * 
 * @author lin
 * @date 2017年8月15日 下午4:22:23
 */
public class ManBuilder implements PersonBuilder {
	Person person;

	public ManBuilder() {
		person = new Man();
	}

	public void buildBody() {
		person.setBody("建造男人的身体");
	}

	public void buildFoot() {
		person.setFoot("建造男人的脚");
	}

	public void buildHead() {
		person.setHead("建造男人的头");
	}

	public Person buildPerson() {
		return person;
	}
}
