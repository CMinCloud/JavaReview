package adaptor.object_adaptor;

public class SDAdapterTF implements SDCard{

    private TFCard tfCard;
    // 将TF对象作为参数接入，在方法内部调用
    public SDAdapterTF(TFCard tfCard){
        this.tfCard = tfCard;
    }

    public String readSD(){
        System.out.println("adapter read tf card ");
        return tfCard.readTF();
    }

    @Override
    public void writeSD(String msg) {
        System.out.println("adapter write tf card");
        tfCard.writeTF(msg);
    }
}
