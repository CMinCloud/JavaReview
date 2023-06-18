package dataHandler;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import static dataHandler.StringDataHandler.DATE_DEFUALT_PATTERN;
import static dataHandler.StringDataHandler.DATE_TIME_DEFAULT_PATTERN;

/**
 * @Author：CM
 * @Package：dataHandler
 * @Project：JavaReview
 * @name：DateTimeHandler
 * @Date：2023/5/6 17:17
 * @Filename：DateTimeHandler
 */
public class DateTimeHandler {


    /**
     * 使用map来存储日期格式，减少重复new DateTimeFormatter实例
     */
    private static final Map<String, DateTimeFormatter> formatterMap = initFormatters();


    /**
     * 初始化formatterMap
     * @return
     */
    public static Map<String, DateTimeFormatter> initFormatters() {
        Map<String, DateTimeFormatter> formatterMap = new HashMap<>();
        formatterMap.put(DATE_TIME_DEFAULT_PATTERN,DateTimeFormatter.ofPattern(DATE_TIME_DEFAULT_PATTERN));
        formatterMap.put(DATE_DEFUALT_PATTERN,DateTimeFormatter.ofPattern(DATE_DEFUALT_PATTERN));
        return formatterMap;
    }

    /**
     * 按照输入的日期格式，讲对应日期解析为LocalDate类型
     * @param dateStr   需要解析的字符串
     * @param pattern   格式化标准
     * @return
     */
    public static LocalDate parseDate(String dateStr, String pattern){
        DateTimeFormatter formatter = formatterMap.get(pattern);
        return LocalDate.parse(dateStr,formatter);
    }



}
