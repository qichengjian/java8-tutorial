package com.github.qichengjian.java8.samples.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author qichengjian
 * @description DateTest
 * @date 2020/6/2 下午4:56
 */
public class LocalDateTimeTest {

    public static void main(String[] args) {
        // 日期 + 时间
        LocalDate localDate = LocalDate.of(2020,1,1);
        LocalDateTime localDateTime = localDate.atTime(LocalTime.now());
        System.out.println(localDateTime); //2020-01-01T17:00:33.837

        // 时间 + 日期
        LocalTime localTime = LocalTime.of(12, 59,59);
        LocalDateTime localDateTime1 = localTime.atDate(LocalDate.now());
        System.out.println(localDateTime1); // 2020-06-02T12:59:59

        // 日期时间格式转换
        // LocalDate 转 string
        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM");
        String localDateString = localDateTime.format(f);
        System.out.println(localDateString); // 2020-01

        DateTimeFormatter f2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String localDatef2String = localDateTime.format(f2);
        System.out.println(localDatef2String); // 2020-01-01 17:08:42

        // string 转 LocalDate
        LocalDate stringLocalDate = LocalDate.parse("2020-06-02");
        System.out.println(stringLocalDate); // 2020-06-02

        LocalTime stringLocalTime = LocalTime.parse("22:11:22");
        System.out.println(stringLocalTime);
    }
}
