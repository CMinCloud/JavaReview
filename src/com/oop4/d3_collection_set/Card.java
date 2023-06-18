package com.oop4.d3_collection_set;

public class Card {
    private String size;
    private String color;
    private int top;

    public Card(String size, String color,int top) {
        this.size = size;
        this.color = color;
        this.top = top;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return color+size;
    }
}
