package leetcode.string;

import java.util.*;

public class solution {


    //    整数反转
    public static int reverse(int x) {
        char[] chars = String.valueOf(x).toCharArray();
//        反转字符数组
        int begin = 0;    //设置开始的起始数字位置，防止第一个元素为符号
        if (chars[0] < '0' || chars[0] > '9') {
            begin = 1;
        }
        for (int i = begin, j = chars.length - 1; i < chars.length && i < j; i++, j--) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
//        重新转换为字符串，之后再以整型返回
        String s = String.valueOf(chars);
        return Integer.valueOf(s);
    }

//    字符串中的第一个唯一字符：方法一
 /*   public static int firstUniqChar(String s) {
        // 使用LinkedHashMap（保证以put顺序读出）存储每一个元素，第一次出现就填入其下标，如果第二次出现则填-1
        // 之后遍历ValueSet()，找到第一个value不为-1的值即可
        char[] chars = s.toCharArray();
        HashMap<Character,Integer> map = new LinkedHashMap<>();

        for(int i = 0; i<chars.length; i++){
            if(!map.containsKey(chars[i])){     //第一次填入
                map.put(chars[i],i);            //存入该值和对应下标
            }else{
                map.put(chars[i],-1);           //第二次存入，修改value为-1
            }
        }

        Set<Map.Entry<Character, Integer>> set = map.entrySet();
        for(Map.Entry<Character, Integer> t: set){
            if(t.getValue() != -1){
                return t.getValue();    // 返回第一个下标不为-1的元素，既为字符串中第一个不重复元素
            }
        }
        return -1;
    }*/

    //    字符串中的第一个唯一字符：方法一
    public static int firstUniqChar(String s) {

//        如果每一个元素的第一次出现位置和最后一次出现的位置相同,那么它也就是唯一出现的
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(String.valueOf(chars[i])) == s.lastIndexOf(String.valueOf(chars[i]))) {
                return i;
            }
        }
        return -1;
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] charsCount = new int[26];   //存储每一个字母出现的次数，两个字符串出现次数相同则-1

        for (int i = 0; i < s.length(); i++) {
            charsCount[s.charAt(i) - 'a']++;
            charsCount[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < s.length(); i++) {
            if (charsCount[s.charAt(i) - 'a'] != 0) {
                return false;
            }
        }
        return true;
    }


    //    验证回文串，去除所有非字符 元素后，正着读和反着读一样
/*    public static boolean isPalindrome(String s) {
        //        定义正则表达式判断所有字符数字的字符
        String regex = "[^a-zA-Z0-9]";
        String temp = s.toLowerCase().replaceAll(regex, "");
//         //转换为小写字符
//        char[] chars = temp.toCharArray();
//        for (int i = 0, j = chars.length - 1; i < chars.length / 2 && i < j; i++, j--) {
//            if(chars[i] != chars[j])
//                return false;
//        }
        String reverse = new StringBuilder(temp).reverse().toString();
        return temp.equals(reverse);
    }*/

    //    采用快指针慢指针写法
    public static boolean isPalindrome(String s) {
//        定义双指针
//        left指针在前面遍历，right指针在右边遍历 ，如果遇到字母数字就停下来等待，两个都会数字字母时进行比较
        s = s.toLowerCase(Locale.ROOT);
        for (int left = 0, right = s.length() - 1; left < s.length() && left < right; ) {
            while (!Character.isLetterOrDigit(s.charAt(left)) && left < right) {
                left++;
            }
            while (!Character.isLetterOrDigit(s.charAt(right)) && left < right) {
                right--;
            }
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }


    public static int myAtoi(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (s.charAt(i) == ' ') {
            i++;
        }
        // 拼接除去空格的部分
        while (i < s.length()) {
            sb.append(s.charAt(i++));
        }
        String res = sb.toString();
        sb = new StringBuilder();
//        截取前面的所有数字部分 (不用采取拼接，拼接可能报bug)
        i = 0;
        while (i < res.length() - 1) {
            if (res.charAt(i) == '-' || res.charAt(i) == '+' || (res.charAt(i) > '0' && res.charAt(i) < '9')) {
                sb.append(res.charAt(i++));
            } else i++;
        }
        String toString = sb.toString();
        System.out.println(toString);
        return Integer.valueOf(toString);
//        遍历到非字符元素或末尾
    }


    public static int strStr(String haystack, String needle) {

        if (!haystack.contains(needle)) {
            return -1;
        }
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
//                从i位置开始遍历，知道扫描完needle的长度
                int index = i;  //用来记录可能的子字符串的第一个下标
                int z = 1;
                for (int j = index +1; j < haystack.length() && z < needle.length(); j++, z++) {
                    if(! (haystack.charAt(j) == needle.charAt(z))){
                        break;       //一旦中间字符不匹配则跳出
                    }
                }
//                判断是否读取到needle的最后一个字符
                if(z == needle.length()){
                    return index;
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        boolean palindrome = isPalindrome("race a car");
        System.out.println(palindrome);

        int i = myAtoi("   -42    ");
        System.out.println(i);

        String haystack = "leetcodeleeto";
        String needle = "leeto";
        int i1 = strStr(haystack, needle);
        System.out.println(i1);
    }
}
