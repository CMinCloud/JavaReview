package com.oop4.d2_genericity;

public class test {

    public static void main(String[] args) {
            MyArrayList<Integer> myArrayList = new MyArrayList<>();

            myArrayList.add(1);
            myArrayList.add(2);

        System.out.println(myArrayList);
    }
}
