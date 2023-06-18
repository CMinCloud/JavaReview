package proxy.jdk_proxy;

public class TranStation implements SellTickets {


    @Override
    public void sell() {
        System.out.println("卖出了票");
    }
}
