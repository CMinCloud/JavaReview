package factory.factory_method;


/**
 * 提供咖啡
 */
public class CoffeeStore {

    private CoffeeFactory coffeeFactory;

    public void setCoffeeFactory(CoffeeFactory factory) {
        this.coffeeFactory = factory;
    }

    //    咖啡点咖啡，调用咖啡工厂的制造功能
    public Coffee orderCoffee() {
        Coffee coffee = coffeeFactory.createCoffee();
        coffee.addMilk();
        coffee.addSugar();
        return coffee;
    }
}
