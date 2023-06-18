package decorate;


//具体的构建
public class FriedRice extends FastFood {


    public FriedRice() {
        super(10, "炒饭");
    }

    @Override
    public float cost() {
        return super.getPrice();
    }

}
