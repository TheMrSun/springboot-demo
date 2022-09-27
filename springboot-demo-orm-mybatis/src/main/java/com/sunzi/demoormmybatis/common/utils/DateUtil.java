package com.sunzi.demoormmybatis.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

/**
 * 时间工具类
 *
 * @author Coder
 */
public class DateUtil {
	public static final String FULL_TIME_PATTERN = "yyyyMMddHHmmss";
	public static final String FULL_TIME_SPLIT_PATTERN = "yyyy-MM-dd HH:mm:ss";
	public static final String TIME_SPLIT_PATTERN = "yyyy-MM-dd";
	public static final String TIME_NO_SPLIT_PATTERN = "yyyyMMdd";
	public static final String CST_TIME_PATTERN = "EEE MMM dd HH:mm:ss zzz yyyy";

	private DateUtil() {}

	public static String formatFullTime(LocalDateTime localDateTime) {
		return formatFullTime(localDateTime, FULL_TIME_PATTERN);
	}

	public static String formatFullTime(LocalDateTime localDateTime, String pattern) {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
		return localDateTime.format(dateTimeFormatter);
	}

	public static String getDateFormat(Date date, String dateFormatType) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormatType, Locale.CHINA);
		return simpleDateFormat.format(date);
	}

	public static String formatCSTTime(String date, String format) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(CST_TIME_PATTERN, Locale.US);
		Date usDate = simpleDateFormat.parse(date);
		return DateUtil.getDateFormat(usDate, format);
	}

	public static String formatInstant(Instant instant, String format) {
		LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
		return localDateTime.format(DateTimeFormatter.ofPattern(format));
	}

	/**
	 * 返回当前的LocalDateTime
	 * 
	 * @author zifangsky
	 * @date 2018/7/30 13:23
	 * @since 1.0.0
	 * @return java.time.LocalDateTime
	 */
	public static LocalDateTime now() {
		return LocalDateTime.now();
	}

	/**
	 * 返回当前时间字符串（格式化表达式：yyyy-MM-dd HH:mm:ss）
	 * 
	 * @author zifangsky
	 * @date 2018/7/30 13:23
	 * @since 1.0.0
	 * @return java.lang.String
	 */
	public static String nowStr() {
		return toDateTimeStr(now(), FULL_TIME_SPLIT_PATTERN);
	}

	/**
	 * 返回当前时间字符串
	 * 
	 * @author zifangsky
	 * @date 2018/7/30 13:23
	 * @since 1.0.0
	 * @param pattern 指定时间格式化表达式
	 * @return java.lang.String
	 */
	public static String nowStr(String pattern) {
		return toDateTimeStr(now(), pattern);
	}

	/**
	 * 返回当前精确到秒的时间戳
	 * 
	 * @author zifangsky
	 * @date 2018/7/30 13:23
	 * @since 1.0.0
	 * @param zoneOffset 时区，不填默认为+8
	 * @return java.lang.Long
	 */
	public static Long nowLong(ZoneOffset zoneOffset) {
		LocalDateTime dateTime = now();

		if (zoneOffset == null) {
			return dateTime.toEpochSecond(ZoneOffset.ofHours(8));
		} else {
			return dateTime.toEpochSecond(zoneOffset);
		}
	}

	/**
	 * 返回当前精确到毫秒的时间戳
	 * 
	 * @author zifangsky
	 * @date 2018/7/30 13:23
	 * @since 1.0.0
	 * @return java.lang.Long
	 */
	public static Long currentTimeMillis() {
		return System.currentTimeMillis();
	}

	/**
	 * 将时间戳转换为LocalDateTime
	 * 
	 * @author zifangsky
	 * @date 2018/7/30 13:23
	 * @since 1.0.0
	 * @param second     Long类型的时间戳
	 * @param zoneOffset 时区，不填默认为+8
	 * @return java.time.LocalDateTime
	 */
	public static LocalDateTime ofEpochSecond(Long second, ZoneOffset zoneOffset) {
		if (zoneOffset == null) {
			return LocalDateTime.ofEpochSecond(second, 0, ZoneOffset.ofHours(8));
		} else {
			return LocalDateTime.ofEpochSecond(second, 0, zoneOffset);
		}
	}

	/**
	 * 格式化LocalDateTime（格式化表达式：yyyy-MM-dd HH:mm:ss）
	 * 
	 * @author zifangsky
	 * @date 2018/7/30 13:23
	 * @since 1.0.0
	 * @return java.lang.String
	 */
	public static String toDateTimeStr(LocalDateTime dateTime) {
		return toDateTimeStr(dateTime, FULL_TIME_SPLIT_PATTERN);
	}

	/**
	 * 格式化LocalDateTime
	 * 
	 * @author zifangsky
	 * @date 2018/7/30 13:23
	 * @since 1.0.0
	 * @param pattern 指定时间格式化表达式
	 * @return java.lang.String
	 */
	public static String toDateTimeStr(LocalDateTime dateTime, String pattern) {
		return dateTime.format(DateTimeFormatter.ofPattern(pattern, Locale.SIMPLIFIED_CHINESE));
	}

	/**
	 * 将时间字符串转化为LocalDateTime
	 * 
	 * @author zifangsky
	 * @date 2018/7/30 13:48
	 * @since 1.0.0
	 * @param dateTimeStr 时间字符串
	 * @return java.time.LocalDateTime
	 */
	public static LocalDateTime toDateTime(String dateTimeStr) {
		return toDateTime(dateTimeStr, FULL_TIME_SPLIT_PATTERN);
	}

	/**
	 * 将时间字符串转化为LocalDateTime
	 * 
	 * @author zifangsky
	 * @date 2018/7/30 13:48
	 * @since 1.0.0
	 * @param dateTimeStr 时间字符串
	 * @param pattern     指定时间格式化表达式
	 * @return java.time.LocalDateTime
	 */
	public static LocalDateTime toDateTime(String dateTimeStr, String pattern) {
		return LocalDateTime.parse(dateTimeStr, DateTimeFormatter.ofPattern(pattern, Locale.SIMPLIFIED_CHINESE));
	}

	/**
	 * 返回当前日期的LocalDate
	 * 
	 * @author zifangsky
	 * @date 2018/7/30 13:37
	 * @since 1.0.0
	 * @return java.time.LocalDate
	 */
	public static LocalDate currentDate() {
		return LocalDate.now();
	}

	/**
	 * 返回当前日期字符串（格式化表达式：yyyy-MM-dd）
	 * 
	 * @author zifangsky
	 * @date 2018/7/30 13:42
	 * @since 1.0.0
	 * @return java.lang.String
	 */
	public static String currentDateStr() {
		return toDateStr(currentDate());
	}

	/**
	 * 格式化LocalDate
	 * 
	 * @author zifangsky
	 * @date 2018/7/30 13:42
	 * @since 1.0.0
	 * @param date LocalDate
	 * @return java.lang.String
	 */
	public static String toDateStr(LocalDate date) {
		return toDateStr(date, TIME_SPLIT_PATTERN);
	}

	/**
	 * 格式化LocalDate
	 * 
	 * @author zifangsky
	 * @date 2018/7/30 13:42
	 * @since 1.0.0
	 * @param date    LocalDate
	 * @param pattern 指定日期格式化表达式
	 * @return java.lang.String
	 */
	public static String toDateStr(LocalDate date, String pattern) {
		return date.format(DateTimeFormatter.ofPattern(pattern, Locale.SIMPLIFIED_CHINESE));
	}

	/**
	 * 将日期字符串转化为LocalDate
	 * 
	 * @author zifangsky
	 * @date 2018/7/30 13:48
	 * @since 1.0.0
	 * @param dateStr 日期字符串
	 * @return java.time.LocalDate
	 */
	public static LocalDate toDate(String dateStr) {
		return toDate(dateStr, TIME_SPLIT_PATTERN);
	}

	/**
	 * 将日期字符串转化为LocalDate
	 * 
	 * @author zifangsky
	 * @date 2018/7/30 13:48
	 * @since 1.0.0
	 * @param dateStr 日期字符串
	 * @param pattern 指定日期格式化表达式
	 * @return java.time.LocalDate
	 */
	public static LocalDate toDate(String dateStr, String pattern) {
		return LocalDate.parse(dateStr, DateTimeFormatter.ofPattern(pattern, Locale.SIMPLIFIED_CHINESE));
	}

	/**
	 * 返回几天之后的时间
	 * 
	 * @author zifangsky
	 * @date 2018/8/18 17:36
	 * @since 1.0.0
	 * @param days 天数
	 * @return java.time.LocalDateTime
	 */
	public static LocalDateTime nextDays(Long days) {
		return now().plusDays(days);
	}

	/**
	 * 返回几天之后的时间（精确到秒的时间戳）
	 * 
	 * @author zifangsky
	 * @date 2018/8/18 17:36
	 * @since 1.0.0
	 * @param days       天数
	 * @param zoneOffset 时区，不填默认为+8
	 * @return java.lang.Long
	 */
	public static Long nextDaysSecond(Long days, ZoneOffset zoneOffset) {
		LocalDateTime dateTime = nextDays(days);

		if (zoneOffset == null) {
			return dateTime.toEpochSecond(ZoneOffset.ofHours(8));
		} else {
			return dateTime.toEpochSecond(zoneOffset);
		}
	}

	/**
	 * 将天数转化为秒数
	 * 
	 * @author zifangsky
	 * @date 2018/8/18 17:45
	 * @since 1.0.0
	 * @param days 天数
	 * @return java.lang.Integer
	 */
	public static Long dayToSecond(Long days) {
		return days * 86400;
	}



	/**
	 * 字符串按照指定格式解析为Date对象
	 * @param source
	 * @param pattern
	 * @return  解析失败返回null
	 */
	public static Date parseDate(String source, String pattern){
		Date date=null;
		try{
			SimpleDateFormat dateFormat=new SimpleDateFormat(pattern);
			date=dateFormat.parse(source);
		}catch (Exception e){
			date=null;
		}
		return date;
	}

	/**
	 * Date对象按照指定格式解析成字符串
	 * @param date
	 * @param pattern
	 * @return  解析失败返回null
	 */
	public static String formatDate(Date date,String pattern){
		String dateStr=null;
		try{
			SimpleDateFormat dateFormat=new SimpleDateFormat(pattern);
			dateStr=dateFormat.format(date);
		}catch (Exception e){
			dateStr=null;
		}
		return dateStr;
	}

}
