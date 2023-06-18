package singleton.destroySingletonByReflect;

import java.lang.reflect.Constructor;

public class destroySingletonByReflect {


    public static void main(String[] args) throws Exception {
        Singleton instance = Singleton.getInstance();
        System.out.println("原始对象："+instance);

        Class<Singleton> singletonClass = Singleton.class;
        Constructor<Singleton> constructor = singletonClass.getDeclaredConstructor();
        constructor.setAccessible(true);        // 强制执行
        Singleton instance1 = constructor.newInstance();
//        Singleton instance2 = constructor.newInstance();

        System.out.println("反射得到的对象:"+instance1+",");
    }
}
