package com.oop2.d8_innerClass.menberInnerClass;

public class Outer {


    public Outer(){
        System.out.println();
    }

    private int  m = 0;

//    成员方法
    public void test1(){
        System.out.println("外部成员变量方法test1()");
    }


    /**
     * 定义一个成员内部类：
     */
    class Inner {

        public Inner(){
            System.out.println();
        }

        private int n = 1;
        void show1(){
            System.out.println("外部成员变量：m="+m);
            test1();   //外部成员方法
        }

        void show2(){
            System.out.println("内部成员变量方法");
        }
    }

    void test2(){
//        定义外部类方法，访问内部类变量和方法
        Inner inner = new Inner();      // 实例化内部类对象inner
        System.out.println("在外部类方法中实例化内部类对象:"+inner);
        System.out.println("内部成员变量 n = " + inner.n);
        inner.show2();
    }


    public static void main(String[] args) {

//       实例化外部类对象
        Outer outer = new Outer();
//        实例化内部类对象
        Inner inner = outer.new Inner();
        System.out.println("使用外部类直接实例化内部类:"+inner);
        inner.show1();
        outer.test2();
    }

}
