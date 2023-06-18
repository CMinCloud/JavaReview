package com.cm.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class test {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        test2();
    }


    //    单线程执行10亿次累加
    public static void test1() {
        Long sum = 0L;
        Long start = System.currentTimeMillis();
        for (Long i = 1L; i <= 10_0000_0000; i++) {
            sum += i;
        }
        long end = System.currentTimeMillis();
        System.out.println("sum=" + sum + "时间:" + (end - start));
    }


    //    使用forkjoin
    public static void test2() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinDemo(0L, 10_0000_0000L);
        ForkJoinTask<Long> submit = forkJoinPool.submit(task);
        Long res = submit.get();

        long end = System.currentTimeMillis();
        System.out.println("sum=" + submit + "时间:" + (end - start));
    }

    //    使用stream并行流
    public static void test3() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();

//        Stream并行流
        long res = LongStream.rangeClosed(0L, 10_0000_0000L).parallel().reduce(0, Long::sum);
        long end = System.currentTimeMillis();

        System.out.println("sum=" + end + "时间:" + (end - start));
    }


}
