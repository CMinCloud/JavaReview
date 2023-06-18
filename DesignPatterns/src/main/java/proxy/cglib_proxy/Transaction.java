package proxy.cglib_proxy;

//实现该类的代理对象（得到该类的子类）
public class Transaction {

    public void sell() {
        System.out.println("火车站卖票");
    }
}
