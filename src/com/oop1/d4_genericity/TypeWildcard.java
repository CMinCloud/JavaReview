package com.oop1.d4_genericity;

import java.util.ArrayList;
import java.util.List;

public class TypeWildcard {

    public static void main(String[] args) {
        List<String> name = new ArrayList<String>();
        List<Integer> age = new ArrayList<Integer>();
        List<Number> number = new ArrayList<Number>();
        name.add("icon");
        age.add(18);
        number.add(314);
//对不同类型的List赋值
        getData(name);
        getData(age);
        getData(number);

        getUperNumber(age);
        getUperNumber(number);
    }
//    表示不知道传进来的类型是什么类型，也就可以传入不同的类型
//    public static <E> void getData(List<E> data){  // 使用？代替具体的参数
//        System.out.println("data:" +data.get(0));
//    }

    public static void getData(List<?> data) {
        System.out.println("data:" + data.get(0));
    }

    //    类型通配符上限通过形如List来定义，如此定义就是通配符泛型值接受Number及其下层子类类型。
    public static void getUperNumber(List<? extends Number> data) {
        System.out.println("data :" + data.get(0));
    }
}
