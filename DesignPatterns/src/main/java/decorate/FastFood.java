package decorate;

/**
 * 抽象构件
 */
public abstract class FastFood {    //抽象类通过匿名函数实例化

    private float price;
    private String desc;

    public FastFood(){}

    public FastFood(float price, String desc) {
        this.price = price;
        this.desc = desc;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public abstract float cost();  //获取价格
}
