package com.algorithm.digraph;

public class Test {

//    用final修饰的成员变量不一定要在声明的时候就赋初值
    private final Integer value;

    public static final Integer order;
    public Test() {
        this.value = 1;
    }
    static {
        order = null;
    }


    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.value);
    }


}
