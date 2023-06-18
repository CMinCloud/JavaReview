package singleton.Lazy;


/**
 * 懒汉式单例模式: 使用静态内部类方式，静态内部类只有在调用时才会加载
 * 不需要加锁也能实现并发安全
 */
public class Singleton2 {


    private Singleton2() {
    }
    //    静态内部类
    private static class SingletonHolder {
        //  在内部类中声明并初始化外部类的对象
        private static final Singleton2 singleton = new Singleton2();
    }

    public static Singleton2 getInstance() {
        return SingletonHolder.singleton;
    }
}
