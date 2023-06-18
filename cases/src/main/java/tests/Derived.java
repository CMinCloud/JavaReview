package tests;

/**
 * @Author：CM
 * @Package：tests
 * @Project：JavaReview
 * @name：Base
 * @Date：2023/5/20 19:53
 * @Filename：Base
 */
class Base {


    public Base(String s){
        System.out.println(s);
    }

}

public class Derived extends Base{
    public Derived(String s) {
        super(s);
        System.out.println("D");
    }

    public static void main(String[] args) {
        new Derived("C");
    }
}


