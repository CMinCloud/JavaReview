package singleton.destroySingletonByReflect;


import java.io.Serializable;

/**
 * 懒汉式单例模式: 使用静态内部类方式，静态内部类只有在调用时才会加载
 * 不需要加锁也能实现并发安全
 */
public class Singleton implements Serializable {

    private static boolean flag = false;

    private Singleton() {
        synchronized (singleton.destroySingleton.Singleton.class) {
            if (flag) {
                throw new RuntimeException("不能使用反射构造多个对象");
            }
            flag = true;
        }
    }

    //    静态内部类
    private static class SingletonHolder {
        //  在内部类中声明并初始化外部类的对象
        private static final Singleton singleton = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHolder.singleton;
    }


}
