package singleton.Enums;

public class Client {

    public static void main(String[] args) {
        Singleton singleton = Singleton.INSTANCE;
        Singleton singleton2 = Singleton.INSTANCE;

        System.out.println(singleton == singleton2);
    }
}
