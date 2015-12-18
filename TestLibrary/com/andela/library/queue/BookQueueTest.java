package com.andela.library.queue;

import com.andela.library.model.Book;
import com.andela.library.model.Member;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BookQueueTest {

    Book book1 = new Book("GIFTED HANDS", "123-ANDELA");
    Book book2 = new Book("GIFTED LEGS", "456-ANDELA");

    ArrayList<Book> books;
    BookQueue<Book, Member> bookQueue;

    @Before
    public void setUp() throws Exception {

        books = new ArrayList<>();
        books.add(book1);
        books.add(book2);

        bookQueue = new BookQueue<>();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testAddItem() throws Exception {
        bookQueue.addItem(book1);
        assertTrue("bookQueue.itemSize() is greater than 0", bookQueue.itemSize()>0);
    }

    @Test
    public void testAddAllItems() throws Exception {

    }

    @Test
    public void testGetNextItem() throws Exception {

    }

    @Test
    public void testGetAllItems() throws Exception {

    }

    @Test
    public void testRemoveItem() throws Exception {

    }

    @Test
    public void testRemoveAllItems() throws Exception {

    }

    @Test
    public void testItemSize() throws Exception {

    }

    @Test
    public void testClearItems() throws Exception {

    }

    @Test
    public void testAddMember() throws Exception {

    }

    @Test
    public void testAddAllMembers() throws Exception {

    }

    @Test
    public void testGetNextMember() throws Exception {

    }

    @Test
    public void testGetAllMembers() throws Exception {

    }

    @Test
    public void testRemoveMember() throws Exception {

    }

    @Test
    public void testRemoveAllMembers() throws Exception {

    }

    @Test
    public void testMemberSize() throws Exception {

    }

    @Test
    public void testClearMembers() throws Exception {

    }
}