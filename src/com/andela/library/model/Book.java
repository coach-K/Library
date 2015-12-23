package com.andela.library.model;

/**
 * Book class extends Item class.
 */
public class Book extends Item {

    private String title;
    private String isbnNumber;
    private String author;

    /**
     * Create a new instance of Book.
     * @param title title of the book.
     * @param author author of the book.
     * @param isbnNumber ISBN Number of the book.
     * @param totalCopies Total Copies available.
     */
    public Book(String title, String author, String isbnNumber, int totalCopies) {
        super(totalCopies);
        this.title = title;
        this.author = author;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
