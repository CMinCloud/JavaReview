package leetcode.day1;

import java.util.*;

public class ransomNote {

    public static void main(String[] args) {
        System.out.println(canConstruct("gb", "bage"));
    }

    /*public static boolean canConstruct(String ransomNote, String magazine) {
*//*        char[] noteChars = ransomNote.toCharArray();
        char[] magaChars = magazine.toCharArray();
        if(noteChars.length > magaChars.length){
            return false;
        }
        LinkedList<Character> list = new LinkedList<>();

        for (char noteChar : noteChars) {
            list.addLast(noteChar);
        }

        for (char magaChar : magaChars) {
            if(list.getFirst() == magaChar){
                list.removeFirst();
            }
            if(list.size() == 0) return true;
        }
        return false;*//*
        Map<Character, Integer> mapN = new LinkedHashMap<>();  //按键排序
        Map<Character, Integer> mapM = new LinkedHashMap<>();
        for (char c : ransomNote.toCharArray()) {
            if (!mapN.containsKey(c)) {
                mapN.put(c, 1);
            } else mapN.put(c, mapN.get(c) + 1);
        }
        for (char c : magazine.toCharArray()) {
            if (!mapM.containsKey(c)) {
                mapM.put(c, 1);
            } else mapM.put(c, mapM.get(c) + 1);
        }
        System.out.println(mapN);
        System.out.println(mapM);
        Set<Character> set = mapN.keySet();
        for (Character character : set) {
            if ( mapM.get(character) == null  || !(mapN.get(character) <= mapM.get(character)))
                return false;
        }
        return true;
    }*/

    public static boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] arr = new int[26];

        char[] rchar = magazine.toCharArray();
        for (char aChar : rchar) {
            arr[aChar - 'a']++;
        }
        char[] schar = ransomNote.toCharArray();
        for (char c : schar) {
            --arr[c - 'a'];
            if (arr[c - 'a'] < 0) {    //说明左边大于右边
                return false;
            }
        }
        return true;
    }
}
