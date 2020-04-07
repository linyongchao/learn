package my.learn.annotationtest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 时间日志注解切面
 *
 * @author lin
 * @return
 * @date 2020/4/7 12:04
 **/
@Aspect
@Component
public class TimeLogAspect {

    @Pointcut("@annotation(my.learn.annotationtest.TimeLog)")
    private void controllerAspect() {
    }

    @Around("controllerAspect()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("---around start---");
        Object object = joinPoint.proceed();
        System.out.println("---around end---");
        return object;
    }

    @Before("controllerAspect()")
    public void before() {
        System.out.println("---before---");
    }

    @After("controllerAspect()")
    public void after() {
        System.out.println("---after---");
    }

    @AfterReturning(pointcut = "controllerAspect()", returning = "res")
    public void afterReturning(JoinPoint joinPoint, Object res) throws Throwable {
        System.out.println("---afterReturning start---");
        //类名
        String targetName = joinPoint.getTarget().getClass().getSimpleName();
        System.out.println("类名:" + targetName);
        MethodSignature ms = (MethodSignature) joinPoint.getSignature();
        //方法名
        String methodName = ms.getName();
        System.out.println("方法名:" + methodName);
        //入参key
        String[] parameterNames = ms.getParameterNames();
        //入参value
        Object[] arguments = joinPoint.getArgs();
        for (int i = 0; i < parameterNames.length; i++) {
            System.out.println("参数" + i + ":" + parameterNames[i] + "=" + arguments[i]);
        }
        //方法的注解对象
        Method method = ms.getMethod();
        TimeLog timeLog = method.getAnnotation(TimeLog.class);
        System.out.println("方法描述：" + timeLog.description());
        System.out.println("方法名:" + method.getName());

        //有类名、方法名、方法描述、参数，即可记录日志

        System.out.println("---afterReturning end---");
    }

    @AfterThrowing("controllerAspect()")
    public void afterThrowing() {
        System.out.println("---afterThrowing---");
    }

}
