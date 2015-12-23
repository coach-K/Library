package com.andela.library.model;

/**
 * An abstract Item class
 */
public abstract class Item {

    private int id;
    private int totalItem;

    /**
     * Get the total number of items available.
     *
     * @param totalItem
     */
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
