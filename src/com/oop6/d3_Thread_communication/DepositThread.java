package com.oop6.d3_Thread_communication;

public class DepositThread extends Thread {
//    操作同一个账户
    private Account account;

    public DepositThread(Account account, String name) {
        super(name);  //调用父类构造器为线程命名
        this.account = account;
    }

    @Override
    public void run() {
        while (true) {
            try {
                account.depositMoney(5000);         //存钱
                Thread.sleep(1000);  //休眠一秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
