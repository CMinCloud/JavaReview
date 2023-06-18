package leetcode.string;

import java.util.Arrays;

/**
 * @Author：CM
 * @Package：leetcode.string
 * @Project：JavaReview
 * @name：longestCommonPrefix
 * @Date：2023/5/17 0:06
 * @Filename：longestCommonPrefix
 */
public class longestCommonPrefix {


    public static void main(String[] args) {
        String[] strs = new String[]{"flower","flow","flight"};
        String demo = demo(strs);
        System.out.println(demo);
    }


    public static String demo(String[] strs){

        // 检查每一个字符串是否合法:仅由小写英文字母组成

        // 先对数组进行排序，这样可以判断所需要比较字符串长度的最小值

        StringBuilder sb = new StringBuilder();
        int len = strs.length - 1;
        Arrays.sort(strs);
        int min = strs[0].length() <= strs[len].length()
                ?  strs[0].length() : strs[len].length();

        // 比较字符串
        for(int i = 0; i< min; i++){
            if(strs[0].charAt(i) == strs[len].charAt(i)){
                sb.append(strs[0].charAt(i));
            }else{
                return sb.length() > 0 ? sb.toString() : "";
            }
        }

        return sb.toString();
    }
}
