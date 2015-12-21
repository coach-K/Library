package com.andela.library;

import com.andela.library.model.Book;
import com.andela.library.model.Member;
import com.andela.library.queue.BookQueue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Library extends Organization<Book, Member> {

    BookQueue bookQueue;

    public Library(){
        super();
        bookQueue = new BookQueue();
    }

    public void addBookRequest(Book book, Member member){
        if (isItemRegistered(book) && isMemberRegistered(member))
            bookQueue.addItemQueue(book, member);
    }

    public void addBookRequest(Book book, Collection<? extends Member> members){
        for (Member member : members){
            addBookRequest(book, member);
        }
    }

    public void addAllBookRequests(Collection<? extends Book> books, Member member) {
        for (Book book : books){
            addBookRequest(book, member);
        }
    }

    public void addAllBookRequests(Collection<? extends Book> books, Collection<? extends Member> members) {
        for (Book book : books){
            addBookRequest(book, members);
        }
    }

    public PriorityQueue<Member> getBorrowedBook(Book book){
        return bookQueue.getItemQueue(book);
    }

    public ArrayList<PriorityQueue<Member>> getAllBorrowedBooks(Collection<Book> books){
        return bookQueue.getAllItemQueue(books);
    }

    public int sizeOfBorrowedBooks() {
        return bookQueue.itemQueueSize();
    }

    public boolean isBorrowedBookEmpty() {
        return bookQueue.itemQueueSize() == 0;
    }

    public boolean borrowedBookContains(Book book) {
        return this.bookQueue.itemQueueContains(book);
    }

    public Iterator<Member> borrowedBookIterator(Book book) {
        return bookQueue.iterator(book);
    }

    public Object[] borrowedBookToArray(Book book) {
        return bookQueue.itemQueueToArray(book);
    }

    public void removeBorrowedBook(Book book) {
        bookQueue.removeItemQueue(book);
    }

    public void removeAllBorrowedBook(Collection<? extends Book> books) {
        for (Book book : books){
            removeBorrowedBook(book);
        }
    }

    public void clearBookRequest() {
        bookQueue.clearItemQueue();
    }
}
