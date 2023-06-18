package builder.demo2;

public class test {

    public static void main(String[] args) {

        Phone phone = new Phone.Builder()
                .cpu("intel")
                .mainboard("华硕")
                .memory("金士顿")
                .screen("三星")
                .build();

        System.out.println(phone);
    }
}
