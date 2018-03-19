package org.yejh.demo.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Ye Jiahao on 2018/03/04.
 */
public class OldDate {
    protected static final ThreadLocal<SimpleDateFormat> local = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    private static DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static DateFormat getDf() {
        return df;
    }

    protected static String date2String(Date date) {
        return df.format(date);
    }

    protected static Date string2Date(String str) throws ParseException {
        return df.parse(str);
    }

    public static void main(String[] args) throws ParseException {
        System.out.println(date2String(new Date()));
        System.out.println("--------------------------------");
        System.out.println(string2Date("2017-12-30 10:23:45"));
        System.out.println("--------------------------------");

        Date d1 = string2Date("2015-06-29 10:23:45");
        System.out.println(d1);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d1);
        calendar.add(Calendar.MONDAY, 7);
        System.out.println(calendar.getTime());
    }
}
