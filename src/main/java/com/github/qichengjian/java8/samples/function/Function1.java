package com.github.qichengjian.java8.samples.function;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Comparator;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.function.*;

/**
 * 函数式接口，有且仅有一个抽象方法，可以有多个非抽象方法，
 * 可以用FunctionalInterface注解表示，也可以不加，
 * 添加后编译器会强制校验。
 * <p>
 * 1.8后增加的java.util.function包下的函数式接口
 * <p>
 * 1.8之前存在的函数式接口：Comparator，Runnable，Callable
 */
public class Function1 {

    @FunctionalInterface
    interface Fun {
        void foo();
    }

    public static void main(String[] args) {
        // Predicate
        Predicate<String> predicate = s -> s.length() > 0;

        predicate.test("foo");//true
        predicate.negate().test("foo");//false 相反判断

        Predicate<Boolean> nonnull = Objects::nonNull;
        Predicate<Boolean> isnull = Objects::isNull;

        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();

        // Function
        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);

        backToString.apply("123"); //"123"

        // Supplier
        Supplier<String> stringSupplier = String::new;
        stringSupplier.get();// new String

        // Consumer
        Consumer<String> stringConsumer = s -> System.out.println(s + ": hello");
        stringConsumer.accept("James"); // James: hello

        // BiConsumer
        BiConsumer<String, Integer> keyAndValue = (key, value) -> System.out.println(key + value);
        keyAndValue.accept("1",2);
        keyAndValue.accept("aa", 2);





    }

}
