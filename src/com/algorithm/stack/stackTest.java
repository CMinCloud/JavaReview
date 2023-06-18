package com.algorithm.stack;

public class stackTest {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        stack.push("aaa");
        stack.push("bbb");
        stack.push("ccc");
//        stack.push("ddd");

        for (String s : stack) {
            System.out.println(s);
        }


        System.out.println(stack.size());
        System.out.println("--------------------");

        System.out.println(stack.pop());
        System.out.println(stack.size());

//        java内置的栈结构
        System.out.println("-------java内置的栈结构--------");
        java.util.Stack stack1 = new java.util.Stack();
        stack1.push("1");
        stack1.push("2");
        stack1.push("3");
        for (Object o : stack1) {
            System.out.println(o);
        }
        String pop = (String)stack1.pop();
        System.out.println(pop);
        System.out.println(stack1.size());


    }
}
