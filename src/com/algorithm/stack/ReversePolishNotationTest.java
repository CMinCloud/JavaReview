package com.algorithm.stack;


public class ReversePolishNotationTest {

    public static void main(String[] args) {
//        中缀表达式3*(17-15)+18/6 的逆波兰表达式如下
        String[] notation = {"3", "17", "15", "-", "*", "18", "6", "/", "+"};
        int result = calculate(notation);
        System.out.println(result);


    }

    /**
     * @param notation 你标蓝表达式的数组表示方式
     * @return
     */
    public static int calculate(String[] notation) {
        String regex = "^[\\+\\-\\*/]";   //设置正则表达式匹配符号
//        遍历数组，每读到一个符号就操作前面的两个结果

//        定义栈来存储数字，每读到一个符号就排出两个数，计算后将新数写入栈
        Stack<String> stack = new Stack<>();
        int num;
        for (String s : notation) {
            if (s.matches(regex)) {     //读取到符号，进行操作
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                if("+".equals(s)){
                    num = num2+num1;
                }else if("-".equals(s)){
                    num = num2-num1;
                }else if("*".equals(s)){
                    num = num2*num1;
                }else {
                    num = num2/num1;
                }
//                将结果再存入栈
                stack.push(String.valueOf(num));
            }else {
                //            将数字存入栈
                stack.push(s);
            }
        }
        int i = Integer.parseInt(stack.pop());
        return i;
    }
}
