package factory.before;


/**
 * 模拟工厂，根据不同的需求生产不同的咖啡
 */
public class CoffeeStore {

    public static Coffee orderCoffee(String type) {
        Coffee coffee = null;
        if ("american".equals(type)) {
            coffee = new AmericanCoffee();
        } else if ("latte".equals(type)) {
            coffee = new LatteCoffee();
        }else {
            System.out.println("没有该咖啡哦~");
        }
//        添加配料
        coffee.addMilk();
        coffee.addSugar();
        return coffee;
    }

}
