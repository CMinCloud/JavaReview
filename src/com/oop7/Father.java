package com.oop7;


import java.io.File;
import java.io.IOException;



//  子类集成父类，抛出的异常不能大于父类
/**
 * 理由：  在使用多态方式向上造型，将子类对象赋值给父类引用
 * 编译看左边也就是父类，检查try catch中父类抛出的IOException可以被捕获
 * 而运行阶段则发现子类抛出的Exception大于IOException， 会在运行中出现错误
 */
public class Father {
    public void father_function() throws IOException {
        new File("a.txt");
    }

    public static void f(int a){
    }
}

class Son extends Father {
    @Override
    public void father_function() /*throws Exception*/ {
        new File("b.txt");
    }

//    子类不能重写父类的static类型的方法，这里相当于重新声明了；   因为static方法是跟随类的声明被产生的
    public static void f(int a){
        System.out.println("aa");
    }
}

class Test {
    public static void main(String[] args) {
        Father fs = new Son();
        try {
            fs.father_function();
        }catch (IOException ie) {
            System.out.println("发生了异常");
        }
    }
}

