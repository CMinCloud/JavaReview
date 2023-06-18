package dataHandler;

import java.util.Date;

import static dataHandler.StringDataHandler.DATE_TIME_DEFAULT_PATTERN;

/**
 * @Author：CM
 * @Package：dataHandler
 * @Project：JavaReview
 * @name：client
 * @Date：2023/5/6 15:04
 * @Filename：client
 */
public class client {


    public static void main(String[] args) {

    }

    public void testParse(){
        Date res = StringDataHandler.parse("2022-12-01 17:47",DATE_TIME_DEFAULT_PATTERN);

    }
}
