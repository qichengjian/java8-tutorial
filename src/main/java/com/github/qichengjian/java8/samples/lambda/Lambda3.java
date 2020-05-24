package com.github.qichengjian.java8.samples.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *  接口与函数接口整合
 */
public class Lambda3 implements ServiceA{
    @Override
    public void load(ServiceB serviceB) {
        List<String> names = Arrays.asList("James", "Paul", "Google");
        // 方法引用::
        names.forEach(serviceB::handler);
    }

    public static void main(String[] args) {
        ServiceA serviceA = new Lambda3();
        AtomicInteger count = new AtomicInteger();
        serviceA.load(t-> {
            System.out.println(t+ ": hello!");
            count.incrementAndGet();
            return t;
        });

        System.out.println("name的个数是：" + count.get());
    }
}
