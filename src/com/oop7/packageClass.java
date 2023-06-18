package com.oop7;


//bytye，short，Integer封装类的内部缓存
public class packageClass {

    public static void main(String[] args) {
        Integer i1 = 66;
        Integer i2 = 66;
        int h1 = i1.hashCode();
        int h2 = i2.hashCode();
        Integer i3 = 356;
        Integer i4 = 356;
        int h3 = i3.hashCode();
        int h4 = i4.hashCode();
        System.out.println(i1 == i2);
        System.out.println(i3 == i4);


        System.out.println(i1);
    }

}
