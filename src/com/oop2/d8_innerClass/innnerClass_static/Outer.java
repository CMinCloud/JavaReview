package com.oop2.d8_innerClass.innnerClass_static;

public class Outer {
    private static int A = 1;
    private String name;

    public void OuterShow(){
        System.out.println(A);
    }

    public Outer(){
        System.out.println("外部类构造器");
    }


    public class aa{}

    public class bb{}
    /**
     * 静态成员内部类(可以有多个public修饰的内部类)
     */
    public static class Inner{
        private String str;
        private int a;
        public static String type;

        public Inner(String str, int a) {
            this.str = str;
            this.a = a;
        }

        public Inner(){
            System.out.println("静态内部类构造器");
        }

        public String getStr() {
            return str;
        }

        public void setStr(String str) {
            this.str = str;
        }

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }

        public void show(){
            System.out.println(A);
        }
    }


    public static void main(String[] args) {
    }
}
