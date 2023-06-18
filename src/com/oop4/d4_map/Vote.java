package com.oop4.d4_map;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Vote {

    public static void main(String[] args) {
        //    1.将80个同学的投票结果进行一个统计
        String[] selects = {"A", "B", "C", "D"};
        StringBuilder sb = new StringBuilder();   //用来拼接字符串，统计学生投票结果

        Random random = new Random();   //随机值对象
        for (int i = 0; i < 80; i++) {
            sb.append(selects[random.nextInt(selects.length)]);  //生成随机投票结果并拼接
        }
        System.out.println(sb);

        Map<Character,Integer> infos = new HashMap<>();
        for (int i = 0; i < sb.length(); i++) {
            Character c = sb.charAt(i);
            if( !infos.containsKey(c)){
//                已存在该选项，则对存储值进行+1
                infos.put(c,1);
            }else{
                infos.put(c,infos.get(c) + 1);
            }
        }
        System.out.println(infos);

    }
}
