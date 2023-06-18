package tests.cloneDemo;

import java.util.stream.Collectors;

/**
 * @Author：CM
 * @Package：tests.cloneDemo
 * @Project：JavaReview
 * @name：client
 * @Date：2023/5/26 22:04
 * @Filename：client
 */
public class client {

    public static void main(String[] args) {


        A a = new A();
        System.out.println(a);
        System.out.println(a.getB());

        A clone = null;
        try {
            clone = (A) a.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println(clone);
        System.out.println(clone.getB());

        StringBuilder sb = new StringBuilder(String.valueOf("111122"));
        String reverse = sb.reverse().toString();
        System.out.println(reverse);

    }
}
