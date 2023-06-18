package singleton.Hungry;


/**
 * 使用静态变量实现饿汉式 单例模式
 */
public class Singleton {

    private Singleton(){}


    private static Singleton singleton = new Singleton();

    public static Singleton getInstance(){
        return singleton;
    }
}
