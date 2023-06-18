package com.oop4.d3_collection_set;

import java.util.*;
import java.util.stream.Collectors;

public class SetDemo2 {

    public static void main(String[] args) {

        Set<Student> sets = new HashSet<>();
        Student s1 = new Student(22,"zzs");
        Student s2 = new Student(23,"dada0");
        Student s3 = new Student(21,"zys");
        sets.add(s1);
        sets.add(s2);
        sets.add(s3);
        System.out.println("students");
        System.out.println(sets);

        Teacher s4 = new Teacher(23,"zys");
        Teacher s5 = new Teacher(22,"dada0");
        Teacher s6 = new Teacher(21,"zzs");
        List<Teacher> list = new ArrayList<>();
        list.add(s4);
        list.add(s5);
        list.add(s6);
        System.out.println("teachers");
        System.out.println(list);

//        实现Comparator接口
        System.out.println("Teacher实现Comparable接口");
        Collections.sort(list, new Comparator<Teacher>() {
            @Override
            public int compare(Teacher o1, Teacher o2) {
                return o1.getAge() - o2.getAge() > 0 ? 1 : -1;
            }
        });
        System.out.println("自定义排序接口Comparator<Teacher>");
        System.out.println(list);
    }
}
