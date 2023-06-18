package tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author：CM
 * @Package：tests
 * @Project：JavaReview
 * @name：instanceOF
 * @Date：2023/6/4 9:17
 * @Filename：instanceOF
 */
public class instanceOF {


    public static void main(String[] args) {
        Integer integer = new Integer(9);
        boolean b = integer instanceof Object;
        System.out.println(b);
        char myChar = 'g';
        String s = Character.toString(myChar);
        System.out.println(s);
        String s1 = String.valueOf(myChar);
        System.out.println(s1);
        Integer a = Integer.valueOf(myChar);
        System.out.println(a);
        List<Integer> list = Arrays.asList(1, 2, 3);
        Collections.emptyList();
    }
}
