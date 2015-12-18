package com.andela.library.model;


public class Book {

    private int id;
    private String title;
    private String isbnNumber;
    private int availableCopies;

    public Book(int id, String title, String isbnNumber, int availableCopies) {
        this.id = id;
        this.title = title;
        this.isbnNumber = isbnNumber;
        this.availableCopies = availableCopies;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }

    public String getIsbnNumber() {
        return isbnNumber;
    }

    public void setIsbnNumber(String isbnNumber) {
        this.isbnNumber = isbnNumber;
    }
}
