package singleton.Lazy;


/**
 * 懒汉式单例模式
 */
public class Singleton {


    private Singleton() {
    }

    private static Singleton singleton;

    public static Singleton getInstance() {
//        防止并发访问
        if (singleton != null) {
            return singleton;
        }
        synchronized (Singleton.class) {
            if (singleton == null) {        // 双重判定，防止重新new
                singleton = new Singleton();
            }
            return singleton;
        }
    }
}
