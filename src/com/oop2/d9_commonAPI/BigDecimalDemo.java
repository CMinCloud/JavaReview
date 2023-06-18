package com.oop2.d9_commonAPI;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalDemo {
    public static void main(String[] args) {
//        浮点型数据直接运算时可能会导致失真(精度丢失)
        System.out.println(0.09/100);
        System.out.println(1.0 - 0.32);
        System.out.println(1.015*100);
        System.out.println("---------------------------");
        double a = 0.1;
        double b = 0.2;
        double c = a+b;
        System.out.println(c);
        System.out.println("----------------------------");
//        包装浮点型对象成为大数据对象:
        BigDecimal d1 = new BigDecimal(c);  //不建议这种做法,存在精度丢失风险
        BigDecimal d2 = BigDecimal.valueOf(c);

        BigDecimal c1 = BigDecimal.valueOf(a);   // 0.1
        BigDecimal c2 = BigDecimal.valueOf(b);   // 0.2
        BigDecimal c3 = new BigDecimal("0.4");
        System.out.println(c2.doubleValue());       //返回double类型数据
        System.out.println(c2.add(c1));      // 0.3     不会出现精度损失
        System.out.println(c2.multiply(c1));            // 相乘
        System.out.println(c2.multiply(c3));

//        注意BigDecimal是一定要做精度运算的...,如直接 divide(10.0/3.0) 会报错
        System.out.println(c2.divide(c1,3, RoundingMode.HALF_UP));   //以四舍五入的形式保留两位小数做除法

        System.out.println(c2.divide(c3,4,RoundingMode.HALF_UP));


        System.out.println(BigDecimal.valueOf(1.0).subtract(BigDecimal.valueOf(0.32)));

//        System.out.println(d1+","+d2);


    }
}
