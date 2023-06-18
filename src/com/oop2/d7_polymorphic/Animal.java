package com.oop2.d7_polymorphic;

public abstract class Animal {
    public int type = 0;
    public void run(){
        System.out.println("animal run...");
    }

    public abstract void eat();
}
