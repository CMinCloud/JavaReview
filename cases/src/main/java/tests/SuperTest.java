package tests;

import java.util.Date;

/**
 * @Author：CM
 * @Package：tests
 * @Project：JavaReview
 * @name：classPrint
 * @Date：2023/6/18 10:16
 * @Filename：classPrint
 */
public class SuperTest extends Date {

    private static final long serialVersionUID = 1L;
    private void test(){
        System.out.println(super.getClass().getName());
    }

    public static void main(String[] args) {
        new SuperTest().test();
    }
}
