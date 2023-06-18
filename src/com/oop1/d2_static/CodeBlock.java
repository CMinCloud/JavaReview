package com.oop1.d2_static;

public class CodeBlock {
    private String name;
    private int age;
    public static int m = 100;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static int num = 10086;

    public CodeBlock() {
        System.out.println("generate...");
        this.name = "zs";
        this.age = 18;
    }

    public static void print() {
        System.out.println("static method..." + num);
    }


    static {
        m = 300;
        System.out.println("static block..." + num);
    }

    {
        System.out.println("normal block..." + num);
    }

    public static void main(String[] args) {
        System.out.println("main...");
        CodeBlock codeBlock = new CodeBlock();
        CodeBlock codeBlock2 = new CodeBlock();


    }
}
