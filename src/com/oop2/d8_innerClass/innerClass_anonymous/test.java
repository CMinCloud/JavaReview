package com.oop2.d8_innerClass.innerClass_anonymous;

public class test {
    public static void main(String[] args) {
        Animal animal = new Animal() {   //实际是采用了多态的原理
            @Override
            public void run() {
                System.out.println("animal run...");
            }
        };
        animal.run();
    }

}

class dog extends Animal{
    public void run(){
        System.out.println("dog...run...");
    }
}

abstract class Animal{
    public void run(){};
}
