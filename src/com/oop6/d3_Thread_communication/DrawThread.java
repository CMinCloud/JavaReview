package com.oop6.d3_Thread_communication;

public class DrawThread extends Thread {
    private Account account;

    public DrawThread(Account account, String name) {
        super(name);  //调用父类构造器为线程命名
        this.account = account;
    }

    @Override
    public void run() {
        while (true) {
            try {
                account.drawMoney(5000);
                Thread.sleep(1000);  //休眠一秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
