package com.oop1.d2_inheritance;

public class Son extends Father{
    private String name;
//    public static String sex = "男";

    public Son(){
        super("f",18);
        System.out.println("son的无参构造方法");
    }

    public Son(String name){
//        默认调用父类的无参构造方法
//        super("小亮");
        this.name = name;
        System.out.println("son的构造方法");
        System.out.println("从父亲那继承过来的静态属性:"+sex);
    }

//    public void eat(){
//        System.out.println(name+"吃饭饭~");
//    }

    public static void main(String[] args) {
        Son son = new Son("小迪");
        son.eat(son.name);
    }
}
