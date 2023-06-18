package com.oop2.d7_polymorphic.demoProject;

public  class Mouse implements USB{
    private String name;

    public Mouse(String name) {
        this.name = name;
    }

    @Override
    public void connect(String cname) {
        System.out.println(name+"成功连接了电脑"+cname);
    }

    @Override
    public void unconnect(String cname) {
        System.out.println(name+"登出了电脑"+cname);
    }

    /**
     * 独有功能
     */

    public void click(){
        System.out.println("鼠标点击...");
    }
}
