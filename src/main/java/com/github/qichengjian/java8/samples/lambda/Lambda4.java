package com.github.qichengjian.java8.samples.lambda;

public class Lambda4 {

    static class Person {
        String name;
        int age;
        public Person() {
        }
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        String getPerson(String name) {
            return "hello " + name;
        }
    }

    interface PersonFactory<P extends Person> {
        P create(String name, int age);
    }

    interface Converter<F, P> {
        P convert(F from);
    }


    public static void main(String[] args) {
        Converter<String, Integer> converter = t -> Integer.valueOf(t);
        // 方法引用
        Converter<String, Integer> integerConverter = Integer::valueOf;
        Person person = new Person();
        Converter<String, String> personConverter = person::getPerson;
        // 构造器引用 (构造方法的参数签名必须和函数接口的方法的参数签名一致)
        PersonFactory factory = Person::new;

        Person p = factory.create("Jack", 88);
        System.out.println(p);
    }
}
