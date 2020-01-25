package my.learn.pattern.clone;

/**
 * 深克隆、浅克隆测试类
 *
 * @author lin
 * @return
 * @date 2019/11/26 16:17
 **/
public class TestClone {
    public static void main(String[] args) throws CloneNotSupportedException {
        String name = "test";
        int age = 18;

        PersonShallow personShallow = new PersonShallow(name, age);
        PersonShallow personShallowClone = (PersonShallow) personShallow.clone();
        System.out.println(personShallow == personShallowClone);
        //证明是浅克隆
        System.out.println(personShallow.getName() == personShallowClone.getName());
        System.out.println(personShallow.getAge() == personShallowClone.getAge());

        System.out.println("----------------");

        PersonDeep personDeep = new PersonDeep(name, age);
        PersonDeep personDeepClone = (PersonDeep) personDeep.clone();
        System.out.println(personDeep == personDeepClone);
        //证明是深克隆
        System.out.println(personDeep.getName() == personDeepClone.getName());
        System.out.println(personDeep.getAge() == personDeepClone.getAge());
    }
}
