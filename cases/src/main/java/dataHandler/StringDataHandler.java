package dataHandler;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author：CM
 * @Package：dataHandler
 * @Project：JavaReview
 * @name：StringDataHandler
 * @Date：2023/5/6 15:00
 * @Filename：StringDataHandler
 */
public class StringDataHandler {

    public static final String DATE_TIME_DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static final String DATE_DEFUALT_PATTERN = "yyyy-MM-dd";


    private StringDataHandler() {
    }


    /**
     * 按照输入的格式讲字符串解析为date类型
     *
     * @param dateStr   需要格式化的日期字符串
     * @param formatStr 格式字符串 例如 “yyyy-MM-dd HH：mm：ss”
     * @return
     */
    public static Date parse(String dateStr, String formatStr) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatStr);
        try {
            return simpleDateFormat.parse(dateStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
