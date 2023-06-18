package stragety;

/**
 * @Author：CM
 * @Package：stragety
 * @Project：JavaReview
 * @name：Client
 * @Date：2023/4/24 17:12
 * @Filename：Client
 */
public class Client {

    public static void main(String[] args) {
        SellBooks sellBooks = new SellBooks(new discountImpl3());       //根据不同的策略，有不同的结果
        sellBooks.sell();


        new SellBooks(new discount() {
            @Override
            public double PlusDiscount() {
                return 0.85;
            }
        }).sell();

    }
}
