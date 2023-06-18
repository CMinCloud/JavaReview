package factory.config_factory;



public class AmericanCoffee extends Coffee {
    @Override
    public String getName() {

        return "给阿姨上一杯美式咖啡";
    }


/*    private void test(){
//        子类
        System.out.println("test~");
    }*/

    /**
     * 子类不能抛出比父类更同级或者更高级的异常）
     * @throws IllegalArgumentException
     */
    @Override
    public void test() throws IllegalArgumentException {

    }
}
