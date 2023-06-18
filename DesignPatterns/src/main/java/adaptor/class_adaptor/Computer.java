package adaptor.class_adaptor;

public class Computer {

/*    private SDAdapterTF adapter = new SDAdapterTF();

    public String readSD() {
        return adapter.readSD();
    }*/

    public String readSD(SDCard sdCard) {
        if (sdCard == null) {
            throw new NullPointerException("sd card null");
        }
        return sdCard.readSD();
    }
}
