package com.oop2.d7_polymorphic.demoProject;

public class test {

    public static void main(String[] args) {
        Computer computer = new Computer("联想小新");

        KeyBoard keyBoard = new KeyBoard("樱花键盘");
        Mouse mouse = new Mouse("雷蛇鼠标");
//        接入键盘
        computer.install(keyBoard);
//        接入鼠标
        computer.install(mouse);
    }
}
