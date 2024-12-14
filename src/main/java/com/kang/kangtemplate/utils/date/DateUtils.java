package com.kang.kangtemplate.utils.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description: 日期工具类
 * @author: liukang
 * @date: 2024/12/14 23:04:57
 */
public class DateUtils {

    /**
     * 将 Date 对象格式化为指定格式的字符串。
     *
     * @param date   要格式化的 Date 对象
     * @param format 目标格式（例如："yyyy-MM-dd HH:mm:ss"）
     * @return 格式化后的日期字符串
     */
    public static String formatDate(Date date, String format) {
        if (date == null || format == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /**
     * 将指定格式的字符串解析为 Date 对象。
     *
     * @param dateString 要解析的日期字符串
     * @param format     日期字符串的格式（例如："yyyy-MM-dd HH:mm:ss"）
     * @return 解析后的 Date 对象，解析失败返回 null
     */
    public static Date parseDate(String dateString, String format) {
        if (dateString == null || format == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            return sdf.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 将时间戳转换为指定格式的日期字符串。
     *
     * @param timestamp 时间戳（毫秒）
     * @param format    日期格式（例如："yyyy-MM-dd HH:mm:ss"）
     * @return 格式化后的日期字符串
     */
    public static String convertTimestampToDate(Object timestamp, String format) {
        Date date = new Date(Long.parseLong(timestamp.toString()));
        return formatDate(date, format);
    }

}
