package org.yejh.shop.util;

import org.springframework.format.Formatter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Ye Jiahao on 2017/06/18.
 */
public class DateFormatter implements Formatter<Date> {
    private static ThreadLocal<SimpleDateFormat> SDF;

    public DateFormatter(String datePattern) {
        SDF = ThreadLocal.withInitial(() -> new SimpleDateFormat(datePattern));
    }

    @Override
    public Date parse(String s, Locale locale) throws ParseException {
        DateFormat dateFormat = SDF.get();
        dateFormat.setLenient(false);
        return dateFormat.parse(s);
    }

    @Override
    public String print(Date date, Locale locale) {
        DateFormat dateFormat = SDF.get();
        dateFormat.setLenient(false);
        return dateFormat.format(date);
    }
}
