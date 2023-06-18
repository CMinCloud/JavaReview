package factory.config_factory;

public class Client {

    public static void main(String[] args) {
        Coffee coffee = (Coffee) CoffeeFactory.createCoffee("american");

        System.out.println(coffee);


        Coffee coffee2 = (Coffee) CoffeeFactoryDemo.createCoffee("latte");

        System.out.println(coffee2);


    }
}
