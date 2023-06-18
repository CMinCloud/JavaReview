package singleton.Lazy;

public class Client {


    public static void main(String[] args) {

        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                Singleton2 instance = Singleton2.getInstance();
                System.out.println(Thread.currentThread().getName() +":"+instance);
            },String.valueOf(i)).start();
        }
    }
}
