package com.github.qichengjian.java8.samples.stream;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream1 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        list.add("ac");

        //filter过滤
        list.stream()
                .filter(s -> s.startsWith("a"))
                .forEach(System.out::println);

        //sort排序-升序
        list.stream()
                .sorted()
                .forEach(System.out::println);

        //sort 降序
        list.stream()
                .sorted((a, b) -> b.compareTo(a))
                .forEach(System.out::println);

        //map 匹配
        System.out.println("mapping");
        list.stream()
                .map(String::toUpperCase)
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println); // "AC" "AA"
        // flatMap 将流中每一个元素映射为一个流，再把每一个流连接成为一个流
        System.out.println("flatMap");
        list.stream().map(s -> s.split("|")).flatMap(Arrays::stream).collect(Collectors.toList());
        // findFirst 找到第一个元素
        // findAny 找到其中一个元素


        //match
        System.out.println("matching");
        boolean anyStartsWithA = list.stream()
                .anyMatch(s -> s.startsWith("a")); //有一个匹配
        System.out.println(anyStartsWithA); //true

        boolean allStartsWithA = list.stream()
                .allMatch(s -> s.startsWith("a"));// 所有的都匹配
        System.out.println(allStartsWithA); //false

        boolean noneStartsWithA = list.stream()
                .noneMatch(s -> s.startsWith("a"));// 没有一个匹配
        System.out.println(noneStartsWithA); //false

        // count 获取结果个数
        System.out.println("count");
        long countStartsWithA = list.stream()
                .filter(s -> s.startsWith("a"))
                .count();               //结果的个数
        System.out.println(countStartsWithA); //2

        // limit 限制返回的结果个数
        System.out.println("limit");
        list.stream().limit(2).forEach(System.out::println);

        // distinct 去重
        System.out.println("distinct");
        String joinString = list.stream().distinct().collect(Collectors.joining("|"));
        System.out.println(joinString);
        // reduce 用于组合流中的元素，如求和，求积
        System.out.println("reduce");
        Optional<String> reduced = list.stream().reduce((s1, s2) -> s1 + "#" + s2);
        reduced.ifPresent(System.out::println); //aa#bb#cc#ac


        // 统计
        List<Integer> numbers = Arrays.asList(3,2,4,5);
        IntSummaryStatistics stat = numbers.stream().mapToInt(x -> x).summaryStatistics();
        System.out.println("最大的数:"+stat.getMax());
        System.out.println("所有数之和"+ stat.getSum());
        System.out.println("平均数："+stat.getAverage());
        //用reduce 求和
        Integer si = numbers.stream().reduce(0, Integer::sum);
        System.out.println("集合求和：" + si);
    }
}
