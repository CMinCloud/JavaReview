package tests;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @Author：CM
 * @Package：tests
 * @Project：JavaReview
 * @name：demo1
 * @Date：2023/5/20 19:26
 * @Filename：demo1
 */
public class demo1 {

    public static void main(String[] args) throws UnsupportedEncodingException {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        String s;
        demo2 demo2 = null;
        System.out.println("s="+demo2);

        HashMap map = new HashMap();
        map.put("k1",null);
        map.put("l2","aa");
        System.out.println(map.size());


        System.out.println("__________________________");
            int i = 0;
            for(foo('A'); foo('B') && (i<2); foo('C')){
                i++;
                foo('D');
            }

    }

    static boolean foo(char c){
        System.out.print(c);
        return true;
    }

    static{
        String i = "";
        integer = 54;
        System.out.println(165);
        System.out.println(i);
    }

    static String i="aa";
    static Integer integer;


}

