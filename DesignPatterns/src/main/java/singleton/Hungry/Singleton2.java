package singleton.Hungry;


/**
 * 使用静态代码块实现饿汉式 单例模式
 */
public class Singleton2 {

    private Singleton2() {
    }

    private static Singleton2 singleton;

    static {
        singleton = new Singleton2();
    }

    public static Singleton2 getInstance() {
        return singleton;
    }
}
