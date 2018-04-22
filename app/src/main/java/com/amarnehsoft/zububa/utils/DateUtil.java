package com.amarnehsoft.zububa.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtil {
    public static String getMonthName(Date date){
        Calendar cal= Calendar.getInstance();
        cal.setTime(date);
        SimpleDateFormat month_date = new SimpleDateFormat("MMM", Locale.getDefault());
        String month_name = month_date.format(cal.getTime());
        return month_name;
    }
    public static String getDayOfMonth(Date date){
        Calendar cal= Calendar.getInstance();
        cal.setTime(date);
        SimpleDateFormat month_date = new SimpleDateFormat("dd",Locale.getDefault());
        String month_name = month_date.format(cal.getTime());
        return month_name;
    }
    public static String formatDate(Date date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        return dateFormat.format(date);
    }
}
