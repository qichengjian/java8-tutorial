package com.github.qichengjian.java8.samples.stream;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * 使用Optional避免null校验
 */
public class Optional2 {

    static class Outer {
        Nested nested = new Nested();

        public Nested getNested() {
            return nested;
        }
    }
    static class Nested {
        Inner inner = new Inner();
        public Inner getInner() {
            return inner;
        }
    }
    static class Inner {
        String foo = "foo";
        public String getFoo() {
            return foo;
        }
    }

    private static void test1() {
        Optional.of(new Outer())
                .flatMap(o -> Optional.ofNullable(o.nested))
                .flatMap(n -> Optional.ofNullable(n.inner))
                .flatMap(i -> Optional.ofNullable(i.getFoo()))
                .ifPresent(System.out::println);
    }

    private static void test2() {
        Optional.of(new Outer())
                .map(Outer::getNested)
                .map(Nested::getInner)
                .map(Inner::getFoo)
                .ifPresent(System.out::println);
    }

    public static <T> Optional<T> resolve(Supplier<T> supplier) {
        T result = supplier.get();
        return Optional.ofNullable(result);
    }
    private static void test3() {
        Outer outer = new Outer();
        resolve(() -> outer.getNested().getInner().getFoo())
                .ifPresent(System.out::println);
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }
}
