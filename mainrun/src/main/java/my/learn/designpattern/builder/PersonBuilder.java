package my.learn.designpattern.builder;

/**
 * @Description:为创建一个Product对象的各个部件指定抽象接口
 * @author lin
 * @date 2017年8月15日 下午4:19:01
 */
public interface PersonBuilder {
	void buildHead();

	void buildBody();

	void buildFoot();

	Person buildPerson();
}
