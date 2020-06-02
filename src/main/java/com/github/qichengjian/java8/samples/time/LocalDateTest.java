package com.github.qichengjian.java8.samples.time;

import java.time.LocalDate;

/**
 * @author qichengjian
 * @description LocalDateTest
 * @date 2020/6/2 下午4:31
 */
public class LocalDateTest {

    public static void main(String[] args) {
        //获取当前日期
        LocalDate localdate = LocalDate.now();
        System.out.println(localdate); //2020-06-02

        // 设置年，月，日的日期
        LocalDate localDate2 = LocalDate.of(2020, 6, 2);
        System.out.println(localDate2); // 2020-06-02

        LocalDate localDate3 = LocalDate.of(2020, 6, 2);
        System.out.println(localDate3.getMonth()); // JUNE
        System.out.println(localDate3.getMonthValue()); // 6
        System.out.println(localDate3.getDayOfMonth()); // 2

        LocalDate minusDayLocalDate = localdate.minusDays(1);//将当前日期减一天
        System.out.println(minusDayLocalDate); //2020-06-01
        LocalDate plusDayLocalDate = localdate.plusDays(1); // 将当前日期加一天
        System.out.println(plusDayLocalDate); //2020-06-03



    }
}
