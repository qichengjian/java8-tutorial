package com.github.qichengjian.java8.samples.stream;

import java.util.Optional;

public class Optional1 {
    public static void main(String[] args) {
        Optional<String> optional = Optional.of("bam");

        optional.isPresent();//  true;
        optional.get();   //"bam"
        optional.orElse("fallback"); // "bam"

        optional.ifPresent(s -> System.out.println(s.charAt(0))); //"b"
        System.out.println(String.format("%s is a great coder", "Chason Qi"));
    }
}
