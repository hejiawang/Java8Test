package com.wang.java8.test.date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

/**
 * java 8 时间
 * @author wang
 *
 */
public class Test1 {

	public static void main(String[] args) {
		
		//LocalDate--------------------
		
		//获取当前时间 yyyy-mm-dd
		LocalDate localDate = LocalDate.now();
		System.out.println("localdate : " + localDate.toString());
		
		LocalDate localDate1 = LocalDate.of(2017, 8, 9);
		System.out.println("localDate1 : " + localDate1);
		
		LocalDate localDate2 = LocalDate.parse("2017-08-09");
		System.out.println("localDate2 : " + localDate2);
		
		//为今天添加一天，也就是获取明天
		LocalDate localDate3 = LocalDate.now().plusDays(1);
		System.out.println("localDate3 : " + localDate3);
		
		//从今天减去一个月
		LocalDate localDate4 = LocalDate.now().minus(1, ChronoUnit.MONTHS);
		System.out.println("localDate4 : " + localDate4);
		
		//解析日期 2017-07-20，获取每周中的星期和每月中的日
		DayOfWeek thursday = LocalDate.parse("2017-07-20").getDayOfWeek();
		System.out.println("周四: " + thursday);
		int twenty = LocalDate.parse("2017-07-20").getDayOfMonth();
		System.out.println("twenty: " + twenty);
		
		//今年是不是闰年
		boolean leapYear = LocalDate.now().isLeapYear();
		System.out.println("是否闰年: " + leapYear);
		
		//判断是否在日期之前或之后
		boolean notBefore = LocalDate.parse("2017-07-20")
                .isBefore(LocalDate.parse("2017-07-22"));
		System.out.println("notBefore: " + notBefore);
		boolean isAfter = LocalDate.parse("2017-07-20").isAfter(LocalDate.parse("2017-07-22"));
		System.out.println("isAfter: " + isAfter);
		
		//获取这个月的第一天
		LocalDate firstDayOfMonth = LocalDate.parse("2017-07-20")
                .with(TemporalAdjusters.firstDayOfMonth());
		System.out.println("这个月的第一天: " + firstDayOfMonth);
		firstDayOfMonth = firstDayOfMonth.withDayOfMonth(1);
		System.out.println("这个月的第一天: " + firstDayOfMonth);
		
		//判断今天是否是我的生日，例如我的生日是 2009-07-20
		LocalDate birthday = LocalDate.of(2009, 07, 20);
		MonthDay birthdayMd = MonthDay.of(birthday.getMonth(), birthday.getDayOfMonth());
		MonthDay today = MonthDay.from(LocalDate.now());
		System.out.println("今天是否是我的生日: " + today.equals(birthdayMd));

		//LocalTime--------------------
		
		//获取现在的时间
		LocalTime now = LocalTime.now();
		System.out.println("现在的时间: " + now);
		
		//将一个字符串时间解析为LocalTime，输出15:02
		LocalTime nowTime = LocalTime.parse("15:02");
		System.out.println("时间是: " + nowTime);
		
		//使用静态方法of创建一个时间
		LocalTime nowTime1 = LocalTime.of(15, 02);
		System.out.println("时间是: " + nowTime1);

		//使用解析字符串的方式并添加一小时，输出16:02
		LocalTime nextHour = LocalTime.parse("15:02").plus(1, ChronoUnit.HOURS);
		System.out.println("下一个小时: " + nextHour);
		
		//获取时间的小时、分钟
		int hour = LocalTime.parse("15:02").getHour();
		System.out.println("小时: " + hour);
		int minute = LocalTime.parse("15:02").getMinute();
		System.out.println("分钟: " + minute);
		
		//检查一个时间是否在另一个时间之前、之后
		boolean isBefore1 = LocalTime.parse("15:02").isBefore(LocalTime.parse("16:02"));
		boolean isAfter1 = LocalTime.parse("15:02").isAfter(LocalTime.parse("16:02"));
		System.out.println("isBefore1: " + isBefore1);
		System.out.println("isAfter1: " + isAfter1);
		
		//在LocalTime类中也将每天的开始和结束作为常量供我们使用
		System.out.println(LocalTime.MAX);
		System.out.println(LocalTime.MIN);

		//LocalDateTime----------------------------------------
		
		//获取当前的日期和时间
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println("现在: " + localDateTime);

		//静态方法和字符串的方式分别创建LocalDateTime对象
		LocalDateTime.of(2017, Month.JULY, 20, 15, 18);
		LocalDateTime localDateTime2 = LocalDateTime.parse("2017-07-20T15:18:00");
		System.out.println("localDateTime2: " + localDateTime2);
		
		//同时`LocalDateTime`也提供了相关API来对日期和时间进行增减操作
		LocalDateTime tomorrow = localDateTime.plusDays(1);
		System.out.println("明天的这个时间: " + tomorrow);
		LocalDateTime minusTowHour = localDateTime.minusHours(2);
		System.out.println("两小时前: " + minusTowHour);
		
		//这个类也提供一系列的get方法来获取特定单位
		Month month = localDateTime.getMonth();
		System.out.println("当前月份: " + month);

		//日期格式化
		LocalDateTime now2 = LocalDateTime.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		System.out.println("默认格式化: " + now2);
		System.out.println("自定义格式化: " + now2.format(dateTimeFormatter));
		LocalDateTime localDateTime3 = LocalDateTime.parse("2017-07-20 15:27:44", dateTimeFormatter);
		System.out.println("字符串转LocalDateTime: " + localDateTime3);
		
		DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String dateString = dateTimeFormatter2.format(LocalDate.now());
		System.out.println("日期转字符串: " + dateString);
		
		//日期周期
		LocalDate initialDate = LocalDate.parse("2017-07-20");
		LocalDate finalDate   = initialDate.plus(Period.ofDays(5));
		System.out.println("初始化日期: " + initialDate);
		System.out.println("加日期之后: " + finalDate);
		long between = ChronoUnit.DAYS.between(initialDate, finalDate);
		System.out.println("差距天数: " + between);
	}
}
