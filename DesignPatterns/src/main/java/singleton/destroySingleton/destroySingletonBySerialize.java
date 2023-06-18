package singleton.destroySingleton;


import java.io.*;

/**
 * 使用序列化反序列化破坏单例模式
 */
public class destroySingletonBySerialize {

    public static void main(String[] args) throws Exception {
        writeObject();
//        实现序列化实体类中的readObject()方法，可以解决序列化破坏单例模式
        Singleton singleton2 = readObject();
        Singleton singleton3 = readObject();
        System.out.println(singleton2 + ",\n" + singleton3);
    }

    public static Singleton writeObject() throws Exception {
        Singleton instance = Singleton.getInstance();

        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("F:\\workplace(Java)\\JavaReview\\DesignPatterns\\src\\main\\java\\singleton\\destroySingleton\\a.txt")
        );
        oos.writeObject(instance);
        oos.close();
        return instance;
    }

    public static Singleton readObject() throws Exception {
        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("F:\\workplace(Java)\\JavaReview\\DesignPatterns\\src\\main\\java\\singleton\\destroySingleton\\a.txt")
        );
        Singleton o = (Singleton) ois.readObject();
        ois.close();
        return o;
    }


}
