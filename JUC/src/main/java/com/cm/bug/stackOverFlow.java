package com.cm.bug;

public class stackOverFlow {

    private static int count;

    public static void main(String[] args) {
        try {
            A();
        }catch (Throwable e){
            e.printStackTrace();
            System.out.println(count);
        }


    }

    private static void A(){
        count++;
        A();
    }

    private static void B(){
        count++;
        A();
    }
}
