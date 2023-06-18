package factory.before;

public class Client {


    public static void main(String[] args) {
        Coffee coffee = CoffeeFactory.orderAmericanCoffee();
        System.out.println(coffee);
    }
}
