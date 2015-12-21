package com.andela.library.model;


public abstract class Item {

    private int id;
    private int totalItem;

    public Item(int totalItem) {
        this.totalItem = totalItem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(int totalItem) {
        this.totalItem = totalItem;
    }
}
