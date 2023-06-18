package singleton.destroySingleton;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 懒汉式单例模式: 使用静态内部类方式，静态内部类只有在调用时才会加载
 * 不需要加锁也能实现并发安全
 */
public class Singleton implements Serializable {

    //    静态内部类
    private static class SingletonHolder {
        //  在内部类中声明并初始化外部类的对象
        private static final Singleton singleton = new Singleton();

    }

    public Singleton(){
        System.out.println("调用了构造方法~~~");
    }

    public static Singleton getInstance() {
        return SingletonHolder.singleton;
    }

    //    当进行反序列化时，会自动调用该方法
    public Object readResolve() {
        return SingletonHolder.singleton;
    }
}
