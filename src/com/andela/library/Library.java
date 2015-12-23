package com.andela.library;

import com.andela.library.model.Book;
import com.andela.library.model.Member;
import com.andela.library.queue.BookQueue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * Library Class extends Organization class.
 */
public class Library extends Organization<Book, Member> {

    BookQueue bookQueue;

    /**
     * Create a new instance of Library class
     */
    public Library() {
        super();
        bookQueue = new BookQueue();
    }

    /**
     * Create a book request.
     * @param book the book requested.
     * @param member Member(s) who requested for book.
     */
    public void addBookRequest(Book book, Member member) {
        if (isItemRegistered(book) && isMemberRegistered(member))
            bookQueue.addItemQueue(book, member);
    }

    public void addBookRequest(Book book, Collection<? extends Member> members) {
        for (Member member : members) {
            addBookRequest(book, member);
        }
    }

    /**
     * Create multiple book request.
     * @param books the collection of book requested.
     * @param member Member who requested for book.
     */
    public void addAllBookRequests(Collection<? extends Book> books, Member member) {
        for (Book book : books) {
            addBookRequest(book, member);
        }
    }

    public void addAllBookRequests(Collection<? extends Book> books, Collection<? extends Member> members) {
        for (Book book : books) {
            addBookRequest(book, members);
        }
    }

    /**
     * Get PriorityQueue of members who requested for a book.
     * @param book the book to get its queue.
     * @return PriorityQueue of Member.
     */
    public PriorityQueue<Member> getBorrowedBook(Book book) {
        return bookQueue.getItemQueue(book);
    }

    /**
     * Get PriorityQueue of members corresponding to the specified collection of books.
     * @param books collection of books to get its corresponding Queue.
     * @return ArrayList of PriorityQueue of Member.
     */
    public ArrayList<PriorityQueue<Member>> getAllBorrowedBooks(Collection<Book> books) {
        return bookQueue.getAllItemQueue(books);
    }

    /**
     * Get size of books requested
     * @return int
     */
    public int sizeOfBorrowedBooks() {
        return bookQueue.itemQueueSize();
    }

    /**
     * Checks if book requested list is empty.
     * @return boolean
     */
    public boolean isBorrowedBookEmpty() {
        return bookQueue.itemQueueSize() == 0;
    }

    /**
     * Checks if requested book list contain the specified book.
     * @param book book to be checked.
     * @return
     */
    public boolean borrowedBookContains(Book book) {
        return this.bookQueue.itemQueueContains(book);
    }

    /**
     * Iterates over Queue of Member corresponding to the specified book.
     * @param book the book to corresponding to a member queue.
     * @return Iterator
     */
    public Iterator<Member> borrowedBookIterator(Book book) {
        return bookQueue.iterator(book);
    }

    /**
     * Converts the corresponding member queue to array.
     * @param book the book corresponding to a member queue.
     * @return Object[]
     */
    public Object[] borrowedBookToArray(Book book) {
        return bookQueue.itemQueueToArray(book);
    }

    /**
     * Remove a member queue corresponding to the specified book.
     * @param book the book corresponding to a member queue.
     */
    public void removeBorrowedBook(Book book) {
        bookQueue.removeItemQueue(book);
    }

    /**
     * Remove all member queue corresponding to the specified collection of books.
     * @param books the collection of books corresponding to a queue.
     */
    public void removeAllBorrowedBook(Collection<? extends Book> books) {
        for (Book book : books) {
            removeBorrowedBook(book);
        }
    }

    /**
     * Clears book request list.
     */
    public void clearBookRequest() {
        bookQueue.clearItemQueue();
    }
}
