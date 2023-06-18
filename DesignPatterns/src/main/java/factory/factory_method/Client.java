package factory.factory_method;

/**
 * 之后如果需要添加新的咖啡，新建一个Coffee的子类，再新建一个coffeeFactory的实现类
 * 然后将其作为参数传给CoffeeStore
 */
public class Client {
    public static void main(String[] args) {

        CoffeeStore coffeeStore = new CoffeeStore();
//        调用工厂方法
        coffeeStore.setCoffeeFactory(new AmericanCoffeeFactory());

        Coffee coffee = coffeeStore.orderCoffee();
        System.out.println(coffee);
    }
}
