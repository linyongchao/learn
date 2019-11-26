package my.learn.pattern.clone;

/**
 * 浅克隆对象<br/>
 * 浅克隆需要实现 Cloneable 接口<br/>
 *
 * @author lin
 * @return
 * @date 2019/11/26 16:06
 **/
public class PersonShallow implements Cloneable {
    private String name;
    private int age;

    public PersonShallow(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
