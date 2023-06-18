package com.oop1.d4_genericity;

import java.util.ArrayList;

//在Test类中对该自定义泛型类进行测试
public class MyArrayList<E> {

    ArrayList<E> arrayList = new ArrayList<>();

    public void add(E  e){
        arrayList.add(e);
    }

    public void remove(E e){
        arrayList.remove(e);
    }

    public E get(int index){
        return arrayList.get(index);
    }

    public int getSize(){
        return arrayList.size();
    }
}


