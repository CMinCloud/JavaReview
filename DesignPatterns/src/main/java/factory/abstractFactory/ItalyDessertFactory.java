package factory.abstractFactory;


/**
 * 抽象方法工厂实现类
 */
public class ItalyDessertFactory implements DessertFactory {
    @Override
    public Coffee createCoffee() {
        return new LatteCoffee();
    }

    @Override
    public Dessert createDessert() {
        return new Tiramisu();
    }

    @Override
    public Dessert createHamburger() {
        return new ItalyHamburger();
    }
}
