package com.algorithm.stack;

import java.util.Objects;

public class BracketsMatchTest {

    public static void main(String[] args) {
        String str = "(上海()(长安))";
        boolean match = ismatch(str);
        System.out.println(match);
    }

    /**
     * 判断str中的括号是否正确
     * @param str
     * @return  如果匹配返回true，繁殖返回false
     */
    public static boolean ismatch(String str){
//        1.创建栈来存储左括号
        Stack<String> stack = new Stack<>();
//        2.从左至右遍历字符串
        String[] split = str.split("");
//        3.判断当前字符串是否是左括号，如果是，则把字符放入到栈中
        for (String s : split) {
            if("(".equals(s)){
                stack.push(s);
            }
//        4.判断当前字符是否右括号，如果是，则从栈中弹出一个左括号，并判断弹出结果是否为null（是null说明没有左括号）
            if(")".equals(s)){
                String pop = stack.pop();
                if(Objects.isNull(pop)){
                    return false;
                }
            }
        }
//        5.判断栈中还有没有剩余的左括号，如果右则不匹配
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }
}
