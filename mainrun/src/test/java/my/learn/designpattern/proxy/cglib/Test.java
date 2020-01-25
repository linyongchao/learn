package my.learn.designpattern.proxy.cglib;

public class Test {
    public static void main(String[] args) {
        String name = "World";
        CgLibProxy cgLibProxy = new CgLibProxy();
        TargetOne resultOne = cgLibProxy.enhance(new TargetOne());
        resultOne.sayHello(name);
        TargetTwo resultTwo = cgLibProxy.enhance(new TargetTwo());
        resultTwo.byebye(name);
    }
}
