package my.learn.designpattern.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CgLibProxy {
    public <T> T enhance(T obj) {
        // 实例化增强器
        Enhancer enhancer = new Enhancer();
        // 设置被代理类（目标类）
        enhancer.setSuperclass(obj.getClass());
        // 设置回调对象
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object object, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println(method.getName() + "开始");
                Object result = methodProxy.invokeSuper(object, objects);
                System.out.println(method.getName() + "结束");
                return result;
            }
        });
        // 生成代理实例
        return (T) enhancer.create();
    }
}
