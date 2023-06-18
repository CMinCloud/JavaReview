package com.oop2.d9_commonAPI;

import javafx.scene.input.DataFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtils {


    public static String getSimpleDate(){
        /**
         SimpleDateFormat函数语法：
         G 年代标志符
         y 年
         M 月
         d 日
         h 时 在上午或下午 (1~12)
         H 时 在一天中 (0~23)
         m 分
         s 秒
         S 毫秒
         E 星期
         D 一年中的第几天
         F 一月中第几个星期几
         w 一年中第几个星期
         W 一月中第几个星期
         a 上午 / 下午 标记符
         k 时 在一天中 (1~24)
         K 时 在上午或下午 (0~11)
         z 时区
         */
        //第一步：创建simpleDateFormat对象，并指定格式
        SimpleDateFormat myFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //第二步：使用创建好的myFormat对象的format方法
        //注意：返回的是String类型的
        String myDate = myFormat.format(new Date());

        return myDate;
    }
}
