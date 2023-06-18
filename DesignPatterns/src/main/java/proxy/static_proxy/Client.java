package proxy.static_proxy;

import java.util.Properties;

public class Client {
    public static void main(String[] args) {

//       创建静态代理类，每一个代理方法需要手动实现
        ProxyPoint p = new ProxyPoint();
        p.sell();
    }
}
