package com.oop3.d1_data;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class dataTest {

    public static void main(String[] args) throws ParseException {
//        1.创建一个Date类的对象，代表系统此刻时间的对象
        Date date = new Date();
        System.out.println(date);

        System.out.println("------------------------");
//        2.通过date对象获取时间毫秒值
/*        long time = date.getTime();
        System.out.println(time);

//        得到当前的时间毫秒值：
        System.out.println("------------------------");
//        将时间毫秒值转换为时间：
        Date data2 = new Date();
        long l = System.currentTimeMillis();
//        获取1小时2分1秒后的时间
        long time2 = (24*60*60+2*60+1)*1000;
        System.out.println(new Date(l+time2));
        System.out.println("------------------------");*/

//        3.SimpleDateFormat格式化时间对象和时间毫秒值
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss EEE a");
//        SimpleDateFormat format = new SimpleDateFormat("y年M月d日 H:m:s E a");
//        格式化时间
        String format1 = format.format(new Date());
        System.out.println(format1);
        String format2 = format.format(System.currentTimeMillis());
//        格式化时间毫秒值
        System.out.println(format2);
        System.out.println("------------------------");

//        4、解析格式化时间为事件对象或者时间毫秒值(解析格式必须与格式化日期一样)
/*        String dateStr = "2022年9月17日 23:56:41 星期六 下午";

        SimpleDateFormat format3 = new SimpleDateFormat("y年M月d日 HH:mm:ss EEE a");
//        已经获取到了时间对象
        Date parseDate = format3.parse(dateStr);
//        获取时间毫秒值并进行计算 2天4小时49分06秒后的时间：
        long l1 = parseDate.getTime()+(2*60*60*(24+2)+49*60+6)*1000;
//        重新格式化
        String formatDate = format3.format(l1);
        System.out.println(formatDate);*/
        System.out.println("------------------------");

//5、Calendar类的使用:
//        5.1.获取系统 此刻 的日历对象：
/*        Calendar calendar = Calendar.getInstance();   //直接获取类内部构造的对象
        System.out.println(calendar);    //打印此对象可以查看到日历所包含的所有字段

//        5.2.获取日历的信息: public int get(int field) ：获取日历中某个字段的信息
        int i = calendar.get(Calendar.WEEK_OF_YEAR);
        System.out.println("本周是一年中的第"+i+"周");
//        5.3.修改日历中某个字段信息：public void set(int field,int value)
//        calendar.set(Calendar.HOUR,11);  //一般不会用
        System.out.println(calendar);
//        5.4.public void add(int field,int amount)  为某个字段增加、减少指定的值
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));
        calendar.add(Calendar.DAY_OF_YEAR,2); //计算64天后的时间,此后该日历对象的时间都为被修改的时间
//        5.5.拿到此刻 的日期对象：public final Date getTime()：
        Date time = calendar.getTime();
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));
        System.out.println(time);
//        5.6.获取此刻的时间毫秒值:public long getTimeMillis()  //一般不会这样调用
        long timeInMillis = calendar.getTimeInMillis();*/

//        计算两个日期间间隔的天数
        System.out.println("------------------------");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        获取当前时间的时间毫秒值
        long time = date.getTime();
        System.out.println("今天的日期："+dateFormat.format(time));
//        String birthdayStr = "2003-04-03";
        String birthdayStr = "2003-04-03";
        System.out.println("出生日期："+birthdayStr);
        Date birthday = dateFormat.parse(birthdayStr);
//        获取出生日期的时间毫秒值：
        long birthdayTime = birthday.getTime();
//        获取时间毫秒值的差值
        int period = (int)(Math.abs(birthdayTime - time)/(1000*60*60*24)) + 1;
        System.out.println("存活时间："+period);
        System.out.println("------------------------");
    }
}
