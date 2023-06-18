package com.oop4.collectionReview;

import java.util.Comparator;
import java.util.TreeMap;

public class MapDemo {


    public static void main(String[] args) {
        TreeMap<Person, String> treeMap = new TreeMap<>((o1, o2) -> o1.getAge() - o2.getAge());


        treeMap.put(new Person(28), "28");
        treeMap.put(new Person(12), "12");
        treeMap.put(new Person(25), "25");
        treeMap.put(new Person(1), "1");

        treeMap.entrySet().stream().forEach(e -> {
            System.out.println(e.getValue());
        });


    }
}


class Person {
    private Integer age;


    public Person(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }
}
