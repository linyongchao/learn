package my.learn.annotationtest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 时间日志注解
 *
 * @author lin
 * @return
 * @date 2020/4/7 12:03
 **/
//注解会在class中存在，运行时可通过反射获取
//注解到方法
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface TimeLog {
    /**
     * 方法描述
     *
     * @param
     * @return
     * @author lin
     * @date 2020/4/7 12:03
     **/
    String description();
}
