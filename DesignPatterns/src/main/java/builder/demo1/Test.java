package builder.demo1;

public class Test {

    public static void main(String[] args) {
//        创建指挥者对象
        Director director = new Director(new OfoBikeBuilder());
//        指挥者只会创建对象
        Bike bike = director.construct();
        System.out.println(bike.getFrame()+","+bike.getSeat());
    }
}
