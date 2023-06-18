package com.oop1.d4_genericity;


public class Box<T> {
//    构建一个T类型的对象属性作为类型参数
    private T t;

    public void add(T t){
        this.t = t;
    }

    public T get(){
        return t;
    }

    public static <V> V show(V o){
        System.out.println("在静态方法中不能使用泛型类声明的泛型类型~"+o);
        return null;
    }

    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<Integer>();
        Box<String> stringBox = new Box<String>();
        // T类型参数只能为引用类型Integer
        integerBox.add(new Integer(10));
        stringBox.add(new String("菜鸟教程"));

        System.out.printf("整型值为 :%d\n\n", integerBox.get());
        System.out.printf("字符串为 :%s\n", stringBox.get());

        Box.show(new Object());

    }

}
