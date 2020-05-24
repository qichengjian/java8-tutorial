package com.github.qichengjian.java8.samples.lambda;

public interface ServiceA {

    void load(ServiceB serviceB);

     interface ServiceB {
        String handler(String name);
    }
}
