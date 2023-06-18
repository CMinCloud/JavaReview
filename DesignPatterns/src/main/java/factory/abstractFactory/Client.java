package factory.abstractFactory;


public class Client {


    public static void main(String[] args) {


        DessertFactory factory = new ItalyDessertFactory();
//        产出的都是意大利风味的产品
        Coffee coffee1 = factory.createCoffee();
        Dessert dessert1 = factory.createDessert();
        Dessert hamburger1 = factory.createHamburger();
        System.out.println(coffee1+"\n"+dessert1);
        System.out.println(hamburger1);



        System.out.println("===============不同的工厂，所生产的产品类型不同================");

        DessertFactory factory1 = new AmericanDessertFactory();
//        产出的都是美式风味的产品
        Coffee coffee2 = factory1.createCoffee();
        Dessert dessert2 = factory1.createDessert();
        Dessert hamburger2 = factory1.createHamburger();
        System.out.println(coffee2+"\n"+dessert2);
        hamburger2.show();
    }
}
