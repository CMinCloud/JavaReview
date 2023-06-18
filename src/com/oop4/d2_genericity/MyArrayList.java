package com.oop4.d2_genericity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MyArrayList<E> {

    private ArrayList<E> list = new ArrayList<>();

    public void add(E e) {
        list.add(e);
    }

    public void remove(E e) {
        list.remove(e);
    }


    public  void testPrint(List<?> myList) {
        System.out.println(myList);
    }

    @Override
    public String toString() {
        return list + "";
    }

    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.testPrint(Arrays.asList("aaa","bbb"));
        myArrayList.testPrint(Arrays.asList(111,222));
    }
}


