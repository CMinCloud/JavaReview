package factory.abstractFactory;

public abstract class Coffee {

    public abstract String getName();

    public void addMilk() {
        System.out.println("加奶");
    }

    public void addSugar() {
        System.out.println("加糖");
    }

    @Override
    public String toString() {
        return getName();
    }
}
