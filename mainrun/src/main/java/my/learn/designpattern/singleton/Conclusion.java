package my.learn.designpattern.singleton;

/**
 * 总结
 *
 * @author lin
 * @return
 * @date 2019/12/25 17:37
 **/
public class Conclusion {
    /**
     * 不能使用第一种（线程不安全）、第二种（性能较低）
     * 建议使用第五种（饿汉式）、第六种（枚举）
     * 明确需要懒加载使用第三种（双重校验锁）、第四种（静态内部类）
     **/
}
