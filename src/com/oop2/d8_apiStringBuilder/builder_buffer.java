package com.oop2.d8_apiStringBuilder;

public class builder_buffer {

    public static void main(String[] args) {


//        StringBuilder sb = new StringBuilder();
        StringBuffer sb = new StringBuffer();

        long l = System.currentTimeMillis();
        for(int i = 0;i<20000000; i++){
            sb.append(i);
        }

        System.out.println(System.currentTimeMillis() - l);
    }
}
