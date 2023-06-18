package com.cm.demo;

public class test {
    private static int count = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    //每个线程让count自增100次
                    for (int i = 0; i < 100; i++) {
                        count++;        // 实质上是  count = count + 1
                        /**
                         * 比如线程1 读取到count=0，此时线程2被调度也读取到count=0
                         * 之后线程1执行操作 count = 0+1 ，线程2执行操作 count = 0+1
                         * 表示线程1和线程2分别执行 自增操作 ，静态变量count的值却 = 1，实际上只增加了一次
                         */
                    }
                }
            }).start();
        }

        try{
            Thread.sleep(2000); //主线程休眠两秒
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(count);
    }
}
