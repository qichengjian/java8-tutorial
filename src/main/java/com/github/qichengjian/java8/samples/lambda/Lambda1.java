package com.github.qichengjian.java8.samples.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * lambda表达式可以代替匿名内部类写法,同时与新特性函数氏接口配合使用
 * 表达式特点
 *  * 可选类型声明：不需要声明参数类型
 *  * 可选的参数圆括号：一个参数无需圆括号，多个参数需要圆括号
 *  * 可选的大括号：如果主体只包含一个语句，就不需要使用大括号
 *  * 可选的返回关键字：如果主体只有一个语句，就不需要return关键字,大括号需要指定返回值
 */
public class Lambda1 {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Paul", "James");

        //未使用lambda
        Collections.sort(names, new Comparator<String>() {
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });

        //使用lambda

        //用法1
        Collections.sort(names, (String a, String b) -> {
            return b.compareTo(a);
        });

        //用法2 省略参数类型
        Collections.sort(names, (a,b) -> {
            return b.compareTo(a);
        });

        //用法3 省略返回return关键字
        Collections.sort(names, (String a, String b) ->
            b.compareTo(a)
        );

        //用法4 省略参数类型和return关键字 (最简化版)
        Collections.sort(names, (a,b) -> b.compareTo(a));

        System.out.println(names);

    }
}
