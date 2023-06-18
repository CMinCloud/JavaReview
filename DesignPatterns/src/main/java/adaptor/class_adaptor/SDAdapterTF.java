package adaptor.class_adaptor;


/**
 * 使SD接口的电脑能够兼容TF接口
 * 继承TF，从而能够调用父类方法
 * 实现SD，满足SD接口
 */
public class SDAdapterTF extends TFCardImpl implements SDCard{

//    通过引用的方式来实现转换
//    private TFCard tfCard = new TFCardImpl();

    public String readSD(){
        System.out.println("adapter read tf card ");
        return super.readTF();  // 继承父类方法
    }

    public void writeSD(String msg){
        System.out.println("adapter write tf card");
        super.writeTF(msg); //调用父类方法
    }
}
