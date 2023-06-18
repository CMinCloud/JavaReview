package com.oop2.d8_apiStringBuilder;

public class StringBuilderTest {

    public static void main(String[] args) {
        Integer[] arr = {2,3,5,1};
        System.out.println(toString(arr));
        System.out.println(toString(new Integer[]{2,3,6,34,3,2,784,3}));
        System.out.println(toString(null));


            String a = "alll";
            String b = new StringBuffer(a).append(123).reverse().toString();

            System.out.println(b);
            String format = String.format("%s+%s",a, b);
            System.out.println(format);

            String t = "aaa";

        System.out.println(t.hashCode());
        t ="bbb";
        System.out.println(t.hashCode());

    }

    /**
     * 接受任意整型数组类型，返回数组内容格式(这里用泛型方法来测试)
     */
    public static <T> String toString(T[] arr){
        if(arr != null){
            StringBuilder builder = new StringBuilder("[");

            for (int i = 0; i < arr.length; i++) {
                builder.append(i != arr.length-1 ? arr[i]+"," : arr[i]+"]");
            }
            return builder.toString();
        }
        return null;
    }

}
