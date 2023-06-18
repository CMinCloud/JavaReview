package stragety;

/**
 * @Author：CM
 * @Package：stragety
 * @Project：JavaReview
 * @name：SellBooks
 * @Date：2023/4/24 17:06
 * @Filename：SellBooks
 */
public class SellBooks {

    private discount discount;

    public SellBooks(discount discount) {
        this.discount = discount;
    }


    public void sell() {
        System.out.println("买书消费了:" + discount.PlusDiscount() * 300);
    }
}
