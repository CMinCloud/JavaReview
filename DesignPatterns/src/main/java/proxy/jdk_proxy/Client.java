package proxy.jdk_proxy;

public class Client {
    public static void main(String[] args) {
        ProxyFactory factory = new ProxyFactory(new TranStation());
//        创建代理对象:说明代理类实现了我们的接口
        SellTickets proxyObject = factory.getProxyObject();
        proxyObject.sell();
        System.out.println(proxyObject.getClass());         //得到对象是代理对象，该代理对象实现了目标接口
    }
}
