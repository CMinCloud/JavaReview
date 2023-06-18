package com.oop1.d4_genericity;

//下面的例子演示了"extends"如何使用在一般意义上的意思"extends"（类）或者"implements"（接口）。
// 该例子中的泛型方法返回三个可比较对象的最大值。
public class MaximumTest {

    public static void main(String[] args) {
        MaximumTest.maximum(3,1,4);
    }

// 返回值为T，使用冒泡排序找出从小到大
    public static <T extends Comparable<?>> T array(T x, T y ,T z){
        if(x instanceof Integer){
            Integer[] a = {(Integer) x, (Integer) y, (Integer) z};
            Integer temp;
            for (int i = 1; i < a.length; i++) {
                for (int j = 0; j < a.length -1; j++) {
                    if(a[j].compareTo(a[i]) > 0){
                        temp = a[i];
                        a[i] = a[j];
                        a[j ] = temp;
                    }
                }
            }
            for (Integer integer : a) {
                System.out.println(integer);
            }
        }
        return  null;
    }


//        必须保证传入的三个参数是  三个课比较对象
    public static <T extends Comparable<T>> T maximum(T x, T y, T z) {

        if (x.compareTo(y) > 0) {        //        x>y
            if (y.compareTo(z) > 0)      //        x>y>z
            {
                System.out.println(x + "> " + y + "> " + z);
            } else if(x.compareTo(z)>0)                         //        x>z>y
            {
                System.out.println(x + "> " + z + "> " + y);
            }
            else
                System.out.println(z+ "> " + x + "> " + y);
        } else if (y.compareTo(z) > 0) {   //      y>x
            if (x.compareTo(z) >0) {      //     y>x>z
                System.out.println(y + "> " + x + "> " + z);
            } else                            // y>z>x
                System.out.println(y + "> " + z + "> " + x);
        } else {
//        x<y,y<z
            System.out.println(z + "> " + y + "> " + x);
        }
        return null;
    }
}
