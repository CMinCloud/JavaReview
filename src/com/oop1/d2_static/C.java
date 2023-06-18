package com.oop1.d2_static;

public class C {

    public C(){
        System.out.println("C public");
    }

    public static void main(String[] args) {
        B b = new B();
    }

    static class A{
        static{
            System.out.println("A");
        }

        public A(){
            System.out.println("A public");
        }

        public A(int i){
            System.out.println(i);
        }
    }

    static class B extends A{
        static{
            System.out.println("B");
        }

        public B(){
            super(1);
            System.out.println("B public");
        }

    }
}
