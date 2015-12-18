package com.andela.library.model;


public class Book extends Item {

    private String title;
    private String isbnNumber;

    public Book(String title, String isbnNumber) {
        this.title = title;
        this.isbnNumber = isbnNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbnNumber() {
        return isbnNumber;
    }

    public void setIsbnNumber(String isbnNumber) {
        this.isbnNumber = isbnNumber;
    }
}
