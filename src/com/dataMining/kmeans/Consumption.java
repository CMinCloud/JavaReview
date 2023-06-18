package com.dataMining.kmeans;

/**
 * 消费记录对象
 * 用来读取csv中的消费记录并封装
 */
public class Consumption {
    private int id;
    private int time;  //最近一次消费的时间间隔R
    private int frequent;  // 消费频率F
    private double total;   //消费总金额M

    public Consumption(){

    }

    public Consumption(int id, int time, int frequent, double total) {
        this.id = id;
        this.time = time;
        this.frequent = frequent;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public int getTime() {
        return time;
    }

    public int getFrequent() {
        return frequent;
    }

    public double getTotal() {
        return total;
    }
}
