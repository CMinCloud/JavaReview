package com.oop2.d8_apiStringBuilder;

import java.util.Objects;

public class test {
    public static void main(String[] args) {
//
//        String a = new String("123");
//        String b = new String("123");
//        System.out.println(a==b);
//        System.out.println(a.equals(b));
//        System.out.println(Objects.equals(a,b));

        StringBuilder builder  = new StringBuilder();
        builder.append("a");
        //        支持链式编程
        builder.append("b").append("c").append(1.1).append(false);
        System.out.println(builder);
//      ---------------------------------------------
        /**
         * 注意：
         * StringBuilder只是拼接字符串的手段，效率好！
         * 最终还是要恢复成String类型（因为一般方法的返回值都是String类型）
         */
        String s = builder.reverse().toString();   //转换为String类型
        System.out.println(builder);

    }

}
