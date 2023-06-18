package adaptor.class_adaptor;

public class Client {

    public static void main(String[] args) {
        Computer computer = new Computer();
        System.out.println("--------直接使用SD接口------------");
        SDCard sdCard = new SDCardImpl();
        System.out.println(computer.readSD(sdCard));
        System.out.println("--------将TF接口转为SD接口------------");
        SDAdapterTF adapterTF = new SDAdapterTF();
        System.out.println(computer.readSD(adapterTF));
    }
}
