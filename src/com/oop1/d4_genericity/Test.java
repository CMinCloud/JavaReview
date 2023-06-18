package com.oop1.d4_genericity;

import java.util.Date;

public class Test {

    public static void main(String[] args) {
        DateInter dateInter = new DateInter();
        Pair<Date> pair = new DateInter();
        pair.setValue(new Date());
        System.out.println(pair.getValue());
        dateInter.setValue(new Date());
        System.out.println(dateInter.getValue());
//        dateInter.setValue(new Object()); //编译错误

    }





}

class Pair<T> {

    public Pair(){
        System.out.println("父类构造方法=》");
    }

    private T value;

    public T getValue() {
        System.out.println("父类方法");
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}

class DateInter extends Pair<Date> {

    public DateInter(){
        System.out.println("子类构造方法");
    }

    @Override
    public void setValue(Date value) {
        super.setValue(value);
    }

    @Override
    public Date getValue() {
        System.out.println("子类方法");
        return super.getValue();
    }
}

class op implements genericInterface<Number>{

    @Override
    public void add(Number number) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(Number number) {

    }
}
