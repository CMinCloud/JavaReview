package com.oop4.d3_collection_set;

import java.util.Objects;


/**
 * 用来学习TreeSet自定义对象排序规则
 */
public class Teacher implements Comparable<Teacher> {
    private int age;
    private String name;

    public Teacher(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //重写equals和hashcode方法后，就可以直接比较成员变量的值来判断两个对象是否相同，，，在set中存入不重复的对象  (因为不同对象默认hashcode不相同)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher t = (Teacher) o;
        return this.age == t.age && Objects.equals(name, t.name);
    }

    @Override
    public int hashCode() {            // 以age和name来判断是否是同一个对象
        return Objects.hash(age, name);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    /**
     * 自定义比较规则，重写compareTo方法后，就不会通过equals来判断对象是否相同，而会走compareTo方法了
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(Teacher o) {
//        return this.age - o.age;   //会去掉值相同的元素，相同返回0
        return this.age - o.age > 0 ? -1 : 1;   //会保留相同元素
    }
}
