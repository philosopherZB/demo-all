package com.philosopherzb.secret.service.common.util;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * @author philosopherZB
 * @date 2021/4/21
 */
public class DateUtils {

    /**
     * 完整时间：yyyy-MM-dd HH:mm:ss
     */
    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    /**
     * 时间格式  hh:mm
     */
    public static final String DEFAULT_DATE_FORMAT_HH_SS = "HH:mm";
    /**
     * 时间格式：yyyy-MM-dd HH:mm
     */
    public static final String DEFAULT_DATE_NO_SECOND = "yyyy-MM-dd HH:mm";
    /**
     * 无时分秒：yyyy-MM-dd
     */
    public static final String DATE_FORMAT_NO_HOUR = "yyyy-MM-dd";

    /**
     * 年月日时分秒(无下划线)：yyyyMMddHHmmss
     */
    public static final String LONG_DATE_FORMAT = "yyyyMMddHHmmss";

    /**
     * 无日无时分秒：yyyyMM
     */
    public static final String DATE_FORMAT_NO_DAY = "yyyyMM";

    /**
     * 文件工厂日期
     */
    public static final String DATE_FORMAT_FOR_FILE = "yyyyMMdd";
    /**
     * 默认的的日志转换器
     */
    public static final DateTimeFormatter DEFAULT_DATETIME_FORMATTER = DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMAT);

    /**
     * <code>java.util.Date</code> covert to <code>java.time.LocalDateTime</code>
     * use default zone
     *
     * @param date java.util.Date
     * @return java.time.LocalDateTime
     */
    private static LocalDateTime date2LocalDateTime(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    /**
     * <code>java.time.LocalDateTime</code> covert to <code>java.util.Date</code>
     * use default zone
     *
     * @param localDateTime java.time.LocalDateTime
     * @return java.util.Date
     */
    private static Date localDateTime2Date(LocalDateTime localDateTime) {
        Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        return Date.from(instant);
    }

    /**
     * get the formatted date string for the current time
     *
     * @return string date, format: yyyy-MM-dd HH:mm:ss
     */
    public static String getCurrentTimeByDefaultDateFormat() {
        return getCurrentTimeByFormat(DEFAULT_DATE_FORMAT);
    }

    /**
     * get the date string in the specified format of the current time
     *
     * @param format 日期格式
     * @return string date
     */
    public static String getCurrentTimeByFormat(String format) {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(format));
    }

    /**
     * <code>java.util.Date</code> covert to <code>java.lang.String</code>
     *
     * @param date   java.util.Date
     * @param format 日期格式, e.g. yyyy-MM-dd HH:mm:ss
     * @return get the formatted date string
     */
    public static String dateToStringByFormat(Date date, String format) {
        return localDateTimeToStringByFormat(date2LocalDateTime(date), format);
    }

    /**
     * <code>java.time.LocalDateTime</code> covert to <code>java.lang.String</code>
     *
     * @param localDateTime java.time.LocalDateTime
     * @param format        e.g. yyyy-MM-dd HH:mm:ss
     * @return get the formatted date string
     */
    public static String localDateTimeToStringByFormat(LocalDateTime localDateTime, String format) {
        return localDateTime.format(DateTimeFormatter.ofPattern(format));
    }

    /**
     * <code>java.util.Date</code> covert to <code>java.lang.String</code>
     * user yyyy-MM-dd HH:mm:ss format
     *
     * @param date java.util.Date
     * @return convert time to yyyy-MM-dd HH:mm:ss format
     */
    public static String dateToStringByDefaultDateFormat(Date date) {
        return dateToStringByFormat(date, DEFAULT_DATE_FORMAT);
    }


    /**
     * <code>java.lang.String</code> covert to <code>java.util.Date</code>
     *
     * @param date   string date
     * @param format 日期格式
     * @return convert string to date and time
     */
    public static Date stringToDateByFormat(String date, String format) {
        LocalDateTime ldt = LocalDateTime.parse(date, DateTimeFormatter.ofPattern(format));
        return localDateTime2Date(ldt);
    }

    /**
     * <code>java.lang.String</code> covert to <code>java.util.Date</code>
     * user yyyy-MM-dd HH:mm:ss format
     *
     * @param date string date
     * @return convert string to date and time
     */
    public static Date stringToDateByDefaultDateFormat(String date) {
        return stringToDateByFormat(date, DEFAULT_DATE_FORMAT);
    }

    /**
     * get ms between two dates
     *
     * @param srcDate 源日期
     * @param decDate 目标日期
     * @return ms
     */
    public static long differMs(Date srcDate, Date decDate) {
        return Math.abs(srcDate.getTime() - decDate.getTime());
    }

    /**
     * get seconds between two dates
     *
     * @param srcDate 源日期
     * @param decDate 目标日期
     * @return seconds
     */
    public static long differSec(Date srcDate, Date decDate) {
        return (long) Math.ceil(differMs(srcDate, decDate) / 1000.0);
    }

    /**
     * get minutes between two dates
     *
     * @param srcDate 源日期
     * @param decDate 目标日期
     * @return minutes
     */
    public static double diffMin(Date srcDate, Date decDate) {
        return (new BigDecimal(Math.ceil(differSec(srcDate, decDate)))
                .divide(new BigDecimal("60"), 2, BigDecimal.ROUND_HALF_UP).doubleValue());
    }

    /**
     * get hours between two dates
     *
     * @param srcDate 源日期
     * @param decDate 目标日期
     * @return hours
     */
    public static double diffHours(Date srcDate, Date decDate) {
        return (new BigDecimal(Math.ceil(diffMin(srcDate, decDate)))
                .divide(new BigDecimal("60"), 2, BigDecimal.ROUND_HALF_UP).doubleValue());
    }

    /**
     * get days between two dates
     *
     * @param srcDate 源日期
     * @param decDate 目标日期
     * @return days
     */
    public static double diffDays(Date srcDate, Date decDate) {
        return (new BigDecimal(Math.ceil(diffHours(srcDate, decDate)))
                .divide(new BigDecimal("24"), 2, BigDecimal.ROUND_HALF_UP).doubleValue());
    }

    /**
     * get the date of the specified date in the days before and after
     * 加上指定天数后的日期
     *
     * @param date 日期
     * @param day  指定天数
     * @return date of add days
     */
    public static Date getSomeDay(Date date, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, day);
        return calendar.getTime();
    }

    /**
     * 减去指定小时数后的日期(分，秒为0)，eg: getSomeHourOfDay(new Date(), 1) => Apr 21 09:00:00 CST 2021
     *
     * @param date 日期
     * @return date of reduce hours
     */
    public static Date getSomeHourOfDay(Date date, int hours) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, cal.get(Calendar.HOUR_OF_DAY) - hours);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);

        return cal.getTime();
    }

    /**
     * compare two dates
     *
     * @param srcDate 源日期
     * @param decDate 目标日期
     * @return 比较结果（源日期是否大于目标日期）
     */
    public static boolean compare(Date srcDate, Date decDate) {
        return srcDate.getTime() > decDate.getTime();
    }

    /**
     * get specified date monday
     * note: Set the first day of the week to Monday, the default is Sunday
     *
     * @param date 日期
     * @return monday
     */
    public static Date getMonday(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);

        return cal.getTime();
    }

    /**
     * get specified date sunday
     * note: Set the first day of the week to Monday, the default is Sunday
     *
     * @param date 日期
     * @return sunday
     */
    public static Date getSunday(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);

        return cal.getTime();
    }

    /**
     * get first day of month
     *
     * @param date 包含月份的日期
     * @return first day of month
     */
    public static Date getFirstDayOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, 1);

        return cal.getTime();
    }

    /**
     * get last day of month
     *
     * @param date 包含月份的日期
     * @return last day of month
     */
    public static Date getLastDayOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, 1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.add(Calendar.DAY_OF_MONTH, -1);

        return cal.getTime();
    }

    /**
     * 获取日期的开始时刻， eg:  YYYY-MM-DD 00:00:00
     *
     * @param inputDay 日期
     * @return YYYY-MM-DD 00:00:00
     */
    public static Date getStartOfDay(Date inputDay) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(inputDay);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        return getStartOfHour(cal.getTime());
    }

    /**
     * 获取日期的最后时刻， eg: YYYY-MM-DD 23:59:59
     *
     * @param inputDay 日期
     * @return YYYY-MM-DD 23:59:59
     */
    public static Date getEndOfDay(Date inputDay) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(inputDay);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        return getEndOfHour(cal.getTime());
    }

    /**
     * 取包含有小时的日期的开始时刻， eg:  YYYY-MM-DD 05:00:00
     *
     * @param inputDay 包含小时的日期
     * @return YYYY-MM-DD 05:00:00
     */
    public static Date getStartOfHour(Date inputDay) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(inputDay);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        return cal.getTime();
    }

    /**
     * 获取包含有小时的日期的最后时刻， eg: YYYY-MM-DD 20:59:59
     *
     * @param inputDay 包含小时的日期
     * @return YYYY-MM-DD 20:59:59
     */
    public static Date getEndOfHour(Date inputDay) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(inputDay);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        return cal.getTime();
    }
}
