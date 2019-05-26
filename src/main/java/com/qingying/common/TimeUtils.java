package com.qingying.common;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {

    public static final String yyyy_MM_dd_HH_mm_ss = "yyyy-MM-dd HH:mm:ss";
    public static final String yyyyMMdd2 = "yyyy/MM/dd";

    /**
     * @param date 时间对象
     * @return 格式化后的时间 (数字型)
     */
    public static int transDate2Int(Date date) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
            return Integer.parseInt(dateFormat.format(date));
        } catch (Exception ex) {
            return 0;
        }
    }

    /**
     * 判断两个日期是否相等
     *
     * @param date 时间对象
     * @return 格式化后的时间 (数字型)
     */
    public static boolean equalDate(Date date, Date date2) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
            return Integer.parseInt(dateFormat.format(date)) == Integer.parseInt(dateFormat.format(date2));
        } catch (Exception ex) {
            return false;
        }
    }


    public static String formatTimeToDate(String time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(new Date(Long.parseLong(time)));
    }

    /**
     * 时间戳转换成日期格式字符串 add by Elephant
     *
     * @param milliseconds 精确到毫秒的字符串 like 1480924076000
     * @return Date
     */
    public static Date timeStamp2Date(String milliseconds) {
        if (milliseconds == null || milliseconds.isEmpty() || milliseconds.equals("null")) {
            return null;
        }
        return new Date(Long.valueOf(milliseconds));
    }

    /**
     * 将字符串转换成Date类型
     *
     * @param dateStr 要转换的字符串
     * @param pattern 模式字符串，如果为空则默认为"yyyy-MM-dd HH:mm:ss"
     * @return Date实例
     */
    public static Date parseDate(String dateStr, String pattern) {
        if (pattern == null) pattern = yyyy_MM_dd_HH_mm_ss;
        DateFormat _df = new SimpleDateFormat(pattern.trim());
        try {
            return _df.parse(dateStr);
        } catch (ParseException pex) {
            pex.printStackTrace();
        }
        return null;
    }


}
