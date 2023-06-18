package com.oop1.d4_genericity;

import java.util.ArrayList;
import java.util.List;

//泛型方法对不同类型的数组元素进行打印,需要在返回值前加上泛型参数
public class genericMethod {
    public static <E> void printArray(E[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(i == array.length - 1 ? array[i] : array[i] + ", ");
        }
    }

    public static void main(String[] args) {

        // 创建不同类型数组： Integer, Double 和 Character
        Integer[] intArray = {1, 2, 3, 4, 5};
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4};
        Character[] charArray = {'H', 'E', 'L', 'L', 'O'};

        System.out.println("整型数组元素为:");
        printArray(intArray); // 传递一个整型数组

        System.out.println("\n双精度型数组元素为:");

        printArray(doubleArray); // 传递一个双精度型数组

        System.out.println("\n字符型数组元素为:");

        printArray(charArray); // 传递一个字符型数组


        System.out.println("---------泛型擦除实验-----------");
        List<String> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();

        System.out.println(l1.getClass()+","+l2.getClass());
        System.out.println(l1.getClass() == l2.getClass());
        System.out.println();



    }



}
