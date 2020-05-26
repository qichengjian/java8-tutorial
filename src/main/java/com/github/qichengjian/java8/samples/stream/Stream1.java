package com.github.qichengjian.java8.samples.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

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

        // count
        System.out.println("counting");
        long countStartsWithA = list.stream()
                .filter(s -> s.startsWith("a"))
                .count();               //结果的个数
        System.out.println(countStartsWithA); //2

        // reducing
        System.out.println("reducing");
        Optional<String> reduced = list.stream().reduce((s1, s2) -> s1 + "#" + s2);
        reduced.ifPresent(System.out::println); //aa#bb#cc#ac
    }
}
