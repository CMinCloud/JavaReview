package com.spi;

public class Main {

    public static void main(String[] args) {

        LoggerService loggerService = LoggerService.getService();
        loggerService.info("Hello SPI");
        loggerService.debug("hello SPI");


    }
}
