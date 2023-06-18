package builder.demo1;


/**
 * 指挥者，用来创建实例
 */
public class Director {


    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public Bike construct() {
        builder.buildFrame();
        builder.buildSeat();
        return builder.createBike();
    }
}
