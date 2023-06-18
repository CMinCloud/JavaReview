package factory.abstractFactory;


/**
 * 抽象方法工厂实现类
 */
public class AmericanDessertFactory implements DessertFactory {
    @Override
    public Coffee createCoffee() {
        return new AmericanCoffee();
    }

    @Override
    public Dessert createDessert() {
        return new MatchaMousse();
    }

    @Override
    public Dessert createHamburger() {
        return new AmericanHamburger();
    }


}
