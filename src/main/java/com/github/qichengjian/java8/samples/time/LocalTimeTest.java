package com.github.qichengjian.java8.samples.time;

import java.time.LocalTime;

/**
 * @author qichengjian
 * @description LocalTimeTest
 * @date 2020/6/2 下午4:44
 */
public class LocalTimeTest {
    public static void main(String[] args) {
        //处理时间

        // 获取当前时间
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime); // 16:45:14.299

        // 获取指定时间
        LocalTime localTime1 = LocalTime.of(12, 23, 44);
        System.out.println(localTime1);

        int hour = localTime.getHour();
        int minute = localTime.getMinute();
        System.out.println("hour :" + hour);
        System.out.println("minute :" + minute);

        //替换小时 ,不会修改原来的时间，返回新的LocalTime
        LocalTime withLocalTime = localTime.withHour(18);
        System.out.println(withLocalTime);

        // 加减时间
        LocalTime minusHoursLocalTime = localTime.minusHours(1);//减去1小时
        System.out.println(minusHoursLocalTime);
        LocalTime plusHoursLocalTime = localTime.plusHours(1); // 加上1小时
        System.out.println(plusHoursLocalTime);
    }
}
