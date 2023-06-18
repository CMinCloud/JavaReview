package com.oop2.d8_innerClass.innnerClass_static;

public class People {
    private int heartbeat = 150;

    /**
     * 成员内部类
     */
    public class Heart{
        private int heartbeats = 110;

        public void show(){
            int heart = 33;
            System.out.println(heart+","+this.heartbeats+","+People.this.heartbeat);//依次输出33，110，150
        }
    }
}
