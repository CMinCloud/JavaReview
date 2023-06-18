package com.oop4.d3_collection_set;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo3 {

    public static void main(String[] args) {

//        Set<Teacher> set = new TreeSet<>(new Comparator<Teacher>() {
//            @Override
//            public int compare(Teacher o1, Teacher o2) {
//                return o2.getAge() - o1.getAge();
//            }
//        });

        Set<Teacher> set = new TreeSet<>((o1, o2) ->
                o2.getAge() - o1.getAge() > 0 ?  1 : -1);


        set.add(new Teacher(70, "aaa"));
        set.add(new Teacher(50, "aaa"));
        set.add(new Teacher(20, "zzs"));

        set.add(new Teacher(20, "zzs"));
        set.add(new Teacher(50,"asa"));

        System.out.println(set);
    }
}
