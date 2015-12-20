package com.andela.library.queue;

import com.andela.library.model.Book;
import com.andela.library.model.Member;
import com.andela.library.model.Staff;
import com.andela.library.model.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BookQueueTest {

    Student student1 = new Student("DANIEL JAMES");
    Student student2 = new Student("GRACE OMOTOSO");
    Staff staff1 = new Staff("OLUWATOSIN ADESANYA");

    Book book1 = new Book("GIFTED HANDS", "123-ANDELA", 4);
    Book book2 = new Book("GIFTED LEGS", "456-ANDELA", 5);

    ArrayList<Book> books;
    BookQueue bookQueue;

    ArrayList<Member> members;

    @Before
    public void setUp() throws Exception {

        members = new ArrayList<>();
        members.add(student1);
        members.add(student2);
        members.add(staff1);

        books = new ArrayList<>();
        books.add(book1);
        books.add(book2);

        bookQueue = new BookQueue();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testAddItem() throws Exception {
        bookQueue.addItem(book1);
        assertTrue("bookQueue.itemSize() is greater than 0", bookQueue.itemSize() > 0);
    }

    @Test
    public void testAddAllItems() throws Exception {
        bookQueue.addAllItems(books);
        assertTrue("bookQueue.itemSize() is greater than 0", bookQueue.itemSize() > 1);
    }

    @Test
    public void testGetItem() throws Exception {
        bookQueue.addAllItems(books);
        Book book = bookQueue.getItem(0);
        assertTrue(book.getTitle().equals(book1.getTitle()));
    }

    @Test
    public void testGetAllItems() throws Exception {
        bookQueue.addAllItems(books);
        assertArrayEquals(books.toArray(), bookQueue.getAllItems().toArray());
    }

    @Test
    public void testRemoveItem() throws Exception {
        bookQueue.addAllItems(books);
        assertEquals(bookQueue.itemSize(), 2);
        bookQueue.removeItem(book1);
        assertEquals(bookQueue.itemSize(), 1);
    }

    @Test
    public void testRemoveAllItems() throws Exception {
        bookQueue.addAllItems(books);
        assertEquals(bookQueue.itemSize(), 2);

        ArrayList<Integer> indexes = new ArrayList<>();
        indexes.add(0);
        indexes.add(0);
        bookQueue.removeAllItems(indexes);
        assertEquals(bookQueue.itemSize(), 0);
    }

    @Test
    public void testItemSize() throws Exception {
        bookQueue.addAllItems(books);
        assertEquals(bookQueue.itemSize(), 2);
    }

    @Test
    public void testClearItems() throws Exception {
        bookQueue.addAllItems(books);
        assertEquals(bookQueue.itemSize(), 2);
        bookQueue.clearItems();
        assertEquals(bookQueue.itemSize(), 0);
    }

    @Test
    public void testAddMember() throws Exception {
        bookQueue.addMember(student1);
        assertTrue("bookQueue.memberSize() is greater than 0", bookQueue.memberSize() > 0);
    }

    @Test
    public void testAddAllMembers() throws Exception {
        bookQueue.addAllMembers(members);
        assertTrue("bookQueue.memberSize() is greater than 0", bookQueue.memberSize() > 2);
    }

    @Test
    public void testGetNextMember() throws Exception {
        bookQueue.addAllMembers(members);
        Member member = bookQueue.getNextMember();
        assertTrue(member.getFullName().equals(student1.getFullName()));
    }

    @Test
    public void testGetAllMembers() throws Exception {
        bookQueue.addAllMembers(members);
        assertArrayEquals(members.toArray(),bookQueue.getAllMembers().toArray());
    }

    @Test
    public void testRemoveMember() throws Exception {
        bookQueue.addAllMembers(members);
        assertEquals(bookQueue.memberSize(), 3);
        bookQueue.removeMember(student1);
        assertEquals(bookQueue.memberSize(), 2);
    }

    @Test
    public void testRemoveAllMembers() throws Exception {
        bookQueue.addAllMembers(members);
        assertEquals(bookQueue.memberSize(), 3);

        ArrayList<Member> indexes = new ArrayList<>();
        indexes.add(members.get(0));
        indexes.add(members.get(1));
        bookQueue.removeAllMembers(indexes);
        assertEquals(bookQueue.memberSize(), 1);
    }

    @Test
    public void testMemberSize() throws Exception {
        bookQueue.addAllMembers(members);
        assertEquals(bookQueue.memberSize(), 3);
    }

    @Test
    public void testClearMembers() throws Exception {
        bookQueue.addAllMembers(members);
        assertEquals(bookQueue.memberSize(), 3);
        bookQueue.clearMembers();
        assertEquals(bookQueue.memberSize(), 0);
    }

    @Test
    public void testSingleBookSingleMemberQueue() throws Exception {
        bookQueue.singleBookSingleMemberQueue(book1, student1);
        assertTrue(bookQueue.itemSize() > 0 && bookQueue.memberSize() > 0);
    }

    @Test
    public void testSingleBookMultipleMemberQueue() throws Exception {
        bookQueue.singleBookMultipleMemberQueue(book1, members);
        assertTrue(bookQueue.itemSize() < 2 && bookQueue.memberSize() > 2);
    }

    @Test
    public void testMultipleBookMultipleMemberQueue() throws Exception {
        bookQueue.multipleBookMultipleMemberQueue(books, members);
        assertTrue(bookQueue.itemSize() > 1 && bookQueue.memberSize() > 2);
    }

    @Test
    public void testMultipleBookSingleMemberQueue() throws Exception {
        bookQueue.multipleBookSingleMemberQueue(books, student1);
        assertTrue(bookQueue.itemSize() > 1 && bookQueue.memberSize() == 1);
    }

}