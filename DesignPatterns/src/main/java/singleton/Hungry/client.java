package singleton.Hungry;

public class client {


    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance11 = Singleton.getInstance();

        System.out.println(instance1 == instance11);

        Singleton2 instance2 = Singleton2.getInstance();
        Singleton2 instance22 = Singleton2.getInstance();

        System.out.println(instance2 == instance22);
    }
}
