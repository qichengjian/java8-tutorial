package com.github.qichengjian.java8.samples.future;

import java.time.LocalTime;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author qichengjian 异步工具 依赖forkjoinPool
 * @description CompleteFutureTest
 * @date 2020/6/2 下午6:10
 */
public class CompletableFutureTest {

    public static void main(String[] args) throws Exception{
        // 并行异步执行多个任务，任务耗时取决于耗时最长的任务
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("future1:" + LocalTime.now());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "1000";
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync( () -> {
            try {
                Thread.sleep(3000);
                System.out.println("future2 :" + LocalTime.now());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "3000";
        });
        // 单个执行
        future1.get();
        future2.get();

        // 合并执行，但是不会合并结果
        CompletableFuture<Void> combin = CompletableFuture.allOf(future1,future2);
        combin.get();
        //合并执行,并且合并结果
        String combined = Stream.of(future1, future2)
                .map(CompletableFuture::join)
                .collect(Collectors.joining("|"));
        System.out.println(combined);


    }
}














