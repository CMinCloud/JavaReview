package factory.config_factory;

public abstract class Coffee {

    public abstract String getName();

    public void addMilk() {
        System.out.println("加奶");
    }

    public void addSugar() {
        System.out.println("加糖");
    }

    public void test() throws RuntimeException{
        System.out.println("test");

    }

    @Override
    public String toString() {
        return getName();
    }
}
