package proxy.cglib_proxy;

public class Client {


    public static void main(String[] args) {
        //    创建代理工厂
        ProxyFactory factory = new ProxyFactory();
        Transaction proxyObject = factory.getProxyObject();
        proxyObject.sell();
    }


}
