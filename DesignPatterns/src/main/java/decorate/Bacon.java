package decorate;

public class Bacon extends Garnish {


    public Bacon(FastFood fastFood) {
        super(fastFood, 2, "培根");
    }

    public float cost() {
        return getPrice() + getFastFood().cost();
    }

    public String getDesc() {
        return super.getDesc() + getFastFood().getDesc();
    }
}
