package factory.before;


/**
 * 模拟工厂，根据不同的需求生产不同的咖啡
 */
public class CoffeeFactory {

    public static Coffee orderAmericanCoffee(){
        return new AmericanCoffee();
    }

    public static Coffee orderLatteCoffe(){
        return new LatteCoffee();
    }

}
