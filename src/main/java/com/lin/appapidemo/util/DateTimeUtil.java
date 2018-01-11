package com.lin.appapidemo.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtil {
    public static String getDate(){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }
    public static String getDateNumber(){
        return String.valueOf(new Date().getTime());
    }
}
