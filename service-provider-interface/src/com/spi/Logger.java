package com.spi;


/**
 * 这个就是 SPI ， 服务提供者接口，后面的服务提供者就要针对这个接口进行实现
 */
public interface Logger {
    void info(String msg);
    void debug(String msg);
}
