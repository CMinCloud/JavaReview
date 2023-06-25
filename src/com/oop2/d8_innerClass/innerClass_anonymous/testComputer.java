package com.oop2.d8_innerClass.innerClass_anonymous;


/**
 * 结合匿名内部类的思想，实现电脑接口的操作
 * 匿名内部类的作用：减少了相似对象的构建
 */
public class testComputer {

    public static void main(String[] args) {
        Computer computer = new Computer("天选");


        /**
         * 创建匿名内部类KeyBoard
         */
        usb KeyBoard = new usb() {
            String name = "keyboard";

            @Override
            public void connect() {
                System.out.println(name + "已连接...");
                write();
            }

            @Override
            public void unconnect() {
            }

            public void write() {
                System.out.println("键盘输入...");
            }
        };
        computer.install(KeyBoard);

        /**
             * 创建匿名内部类Mouse
         */
        usb Mouse = new usb() {
            String name = "mouse";

            @Override
            public void connect() {
                System.out.println(name + "已连接...");
                click();
            }

            @Override
            public void unconnect() {
            }

            public void click() {
                System.out.println("鼠标打字...");
            }
        };
        computer.install(Mouse);
    }
}


class Computer {
    private String name;

    public Computer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 提供安装usb的接口（其中keyboard和mouse实现了usb）
     */
    public void install(usb usb) {
        usb.connect();
    }


    public usb createUsb(){
        usb usb = new usb() {
            @Override
            public void connect() {
                System.out.println("电脑连接usb");
            }

            @Override
            public void unconnect() {
                System.out.println("电脑释放usb连接");
            }
        };
        return usb;
    }

}


interface usb {
    void connect();
    void unconnect();
}
