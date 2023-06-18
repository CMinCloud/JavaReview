package proxy.static_proxy;

public class TranStation implements SellTickets{


    @Override
    public void sell() {
        System.out.println("卖出了票");
    }
}
