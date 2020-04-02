package com.example.demo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by wangrong 2020/4/2
 */
public class DateTimeUtils {

    private static final String TIME_STAMP_FORMAT = "yyyyMMddHHmmssSSS";
    private static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static String format(Date date) {
        return format(date, DATE_TIME_FORMAT);
    }

    public static Date parse(String date) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat(DATE_TIME_FORMAT);
        return format.parse(date);
    }

    public static String format(Date date, String pattern) {
        return new SimpleDateFormat(pattern).format(date);
    }

    public static String now() {
        return new SimpleDateFormat(TIME_STAMP_FORMAT).format(new Date());
    }

    public static Date addDay(Date date, int d) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE,d);
        return cal.getTime();
    }

    public static Date getDayStart(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        return cal.getTime();
    }

}
