package com.oop2.d7_polymorphic.demoProject;

public class Computer {
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
    public void install(USB usb){
        //多态：   接入的可能是键盘也可能是鼠标
        usb.connect(this.name);     //共有功能，不用判断真实对象类型
        if(usb instanceof KeyBoard){
            KeyBoard keyBoard = (KeyBoard) usb;
            keyBoard.write();           //私有功能
        }
        if(usb instanceof Mouse){
            Mouse mouse = (Mouse) usb;
            mouse.click();              //私有功能
        }
        usb.connect(this.name);
    }

}
