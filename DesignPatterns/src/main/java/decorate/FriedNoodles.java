package decorate;


//具体的构建
public class FriedNoodles extends FastFood {


    public FriedNoodles() {
        super(12, "炒面");
    }

    @Override
    public float cost() {
        return super.getPrice();
    }

}
