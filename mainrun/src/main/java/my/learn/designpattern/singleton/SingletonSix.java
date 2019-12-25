package my.learn.designpattern.singleton;

/**
 * @author lin
 * @Description: 非懒加载，线程安全，实现单例模式的最佳方法，更简洁，自动支持序列化机制，绝对防止多次实例化
 * @date 2019/12/25 17:32
 **/
public enum SingletonSix {
    INSTANCE;

    public SingletonSix getInstance() {
        return INSTANCE;
    }
}
