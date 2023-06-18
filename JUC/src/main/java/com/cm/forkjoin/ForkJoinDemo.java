package com.cm.forkjoin;

import java.util.concurrent.RecursiveTask;

public class ForkJoinDemo extends RecursiveTask<Long> {

    private Long start;
    private Long end;

    //      临界值
    private Long edge = 10000L;


    public ForkJoinDemo(Long start, Long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
//        计算大数据量的和
        if ((end - start) < edge) {
            Long sum = 0L;
            for (Long i = start; i <= edge; i++) {
                sum += i;
            }
            return sum;
        } else {
//            数据量过大,使用forkJoin
            long middle = start - (start-end)/2;    // 减少中间步骤计算量
            ForkJoinDemo task1 = new ForkJoinDemo(start, middle);
            task1.fork();       // 拆分任务，将任务压入队列当中
            ForkJoinDemo task2 = new ForkJoinDemo(middle + 1, end);
            task2.fork();
            return task1.join() + task2.join();  // 返回任务的合并值
        }
    }
}
