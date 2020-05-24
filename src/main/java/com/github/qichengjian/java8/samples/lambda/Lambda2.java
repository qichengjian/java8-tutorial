package com.github.qichengjian.java8.samples.lambda;

/**
 * lambda表达式与函数式接口配合使用
 * 类与函数接口整合
 * 接口与函数接口整合
 */
public class Lambda2 {

    interface MySay {
        void sayMessage(String message);
    }
    public void say(String message) {
        MySay mySay = message1 -> System.out.println("hello " + message);
        mySay.sayMessage("MVP");
    }

    interface MyOperation {
        int operation(int a, int b);
    }
    private int operation(int a, int b, MyOperation myOperation) {
        int result =  myOperation.operation(a, b);
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        Lambda2 lambda2 = new Lambda2();
        lambda2.say("James");

        MyOperation myOperation = (a1, a2) -> a1 + a2;
        lambda2.operation(3, 4, myOperation);

    }
}
