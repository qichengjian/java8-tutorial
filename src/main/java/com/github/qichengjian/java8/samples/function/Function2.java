package com.github.qichengjian.java8.samples.function;

import java.util.Comparator;
import java.util.UUID;
import java.util.concurrent.Callable;

/**
 * 1.8之前提供的函数接口
 */
public class Function2 {

    public static void main(String[] args) {
        // Comparator
        Comparator<String> comparator = (s1, s2) -> s2.compareTo(s1);
        comparator.compare("1", "2"); // >0
        comparator.reversed().compare("1", "2");// <0

        // Runnable
        Runnable runnable = () -> System.out.println(UUID.randomUUID());
        runnable.run();

        // Callable
        Callable<UUID> callable = UUID::randomUUID;
        try {
            System.out.println(callable.call());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
