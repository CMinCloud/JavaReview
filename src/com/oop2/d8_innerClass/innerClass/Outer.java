package com.oop2.d8_innerClass.innerClass;

public class Outer {
    private String name;
    public void OuterShow(){
        System.out.println(name);
    }


    /**
     * 成员内部类，不能加static修饰 属于外部类对象
     * 类似成员方法
     */
    public class Inner{
        private String name;
        public int age;
//        public static int size; //jdk16才开始允许定义静态成员

        public Inner(String name, int age) {
            this.name = name;
            this.age = age;
        }

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

        public void InnerShow(){
            System.out.println(name);
            OuterShow(); //访问外部类方法
        }

    }


    public static void main(String[] args) {


        Inner inner = new Outer().new Inner("zs",18);

    }
}
