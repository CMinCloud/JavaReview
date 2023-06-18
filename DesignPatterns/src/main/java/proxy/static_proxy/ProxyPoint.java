package proxy.static_proxy;

public class ProxyPoint {

    private TranStation tranStation = new TranStation();


    public void sell(){
        System.out.println("代理对象调用~");
        tranStation.sell();
    }
}
