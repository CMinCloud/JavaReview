package com.oop1.d4_genericity;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class GetGenericInfo {

//    用来获取该类型参数
    public void test01(Map<String,Integer> map, List<String> list,Integer i){
        System.out.println("test01");
    }

    public void test02(){
        System.out.println("test02");
    }

    public static void main(String[] args) throws NoSuchMethodException {
//        使用反射获取类中的方法
        Method method = GetGenericInfo.class.getMethod("test01", Map.class, List.class,Integer.class);

        Type[] genericParameterTypes = method.getGenericParameterTypes();
        for (Type genericParameterType : genericParameterTypes) {
            System.out.println("#"+genericParameterType);
//            对该方法判断是否是 类型参数(也就是泛型：比如Map<?>，List<?>)
            if(genericParameterType instanceof ParameterizedType){
//                返回真实类型
                Type[] actualTypeArguments = ((ParameterizedType) genericParameterType).getActualTypeArguments();
                for (Type actualTypeArgument : actualTypeArguments) {
//                    打印该泛型方法的参数
                    System.out.println("该泛型方法的参数有："+actualTypeArgument);
                }
            }
        }


    }

}
