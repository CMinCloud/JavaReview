package com.algorithm.hash;

public class HashSetTest {


    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();

        hashSet.add("adada");

        hashSet.add("vadqa");

        hashSet.add("gfasda");

        System.out.println(hashSet);

        System.out.println(hashSet.contains("vadqa"));

        hashSet.remove("adada");

        System.out.println(hashSet);
    }
}
