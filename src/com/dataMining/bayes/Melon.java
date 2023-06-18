package com.dataMining.bayes;

public class Melon {
    private Integer id;         //编号
    private String color;       //色泽
    private String root;        //根蒂
    private String sound;       //敲声
    private String texture;     //纹理
    private String belly;       //脐部
    private String touch;       //触感
    private Boolean isGood;      //好瓜

    public Melon(Integer id, String color, String root, String sound, String texture, String belly, String touch, Boolean isGood) {
        this.id = id;
        this.color = color;
        this.root = root;
        this.sound = sound;
        this.texture = texture;
        this.belly = belly;
        this.touch = touch;
        this.isGood = isGood;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public String getTexture() {
        return texture;
    }

    public void setTexture(String texture) {
        this.texture = texture;
    }

    public String getBelly() {
        return belly;
    }

    public void setBelly(String belly) {
        this.belly = belly;
    }

    public String getTouch() {
        return touch;
    }

    public void setTouch(String touch) {
        this.touch = touch;
    }

    public Boolean getIsGood() {
        return isGood;
    }

    public void setIsGood(Boolean isGood) {
        this.isGood = isGood;
    }


    @Override
    public String toString() {
        return "Melon{" +
                "id=" + id +
                ", color='" + color + '\'' +
                ", root='" + root + '\'' +
                ", sound='" + sound + '\'' +
                ", texture='" + texture + '\'' +
                ", belly='" + belly + '\'' +
                ", touch='" + touch + '\'' +
                ", isGood='" + isGood + '\'' +
                '}';
    }
}


