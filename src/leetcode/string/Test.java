package leetcode.string;

public class Test {

    public static void main(String[] args) {


        /**
         * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果
         * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
         */
/*        int x = -123;
        int reverse = solution.reverse(x);
        System.out.println(reverse);*/


        /**
         * 给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
         */
        String str =  "aabb";
        int i = solution.firstUniqChar(str);
        System.out.println(i);
    }
}
