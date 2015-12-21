package com.andela.library.queue;

import com.andela.library.model.Book;
import com.andela.library.model.Member;
import com.andela.library.model.Staff;
import com.andela.library.model.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;

import static org.junit.Assert.*;

public class BookQueueTest {

    Student student1 = new Student("DANIEL JAMES");
    Student student2 = new Student("GRACE OMOTOSO");
    Staff staff1 = new Staff("OLUWATOSIN ADESANYA");

    Book book1 = new Book("GIFTED HANDS", "BEN CARSON", "123-ANDELA", 4);
    Book book2 = new Book("GIFTED LEGS", "NEB SONCAR", "456-ANDELA", 5);

    ArrayList<Book> books;
    ArrayList<Member> members;

    BookQueue bookQueue;

    @Before
    public void setUp() throws Exception {

        members = new ArrayList<>();
        members.add(staff1);
        members.add(student1);
        members.add(student2);

        books = new ArrayList<>();
        books.add(book1);
        books.add(book2);

        bookQueue = new BookQueue();
    }

    @After
    public void tearDown() throws Exception {

    }


    @Test
    public void testAddItemQueue() throws Exception {
        bookQueue.addItemQueue(book1, student1);
        assertEquals(bookQueue.itemQueueSize(), 1);
    }

    @Test
    public void testGetItemQueue() throws Exception {
        bookQueue.addItemQueue(book1, student1);
        bookQueue.addItemQueue(book2, student2);
        bookQueue.addItemQueue(book2, student1);
        bookQueue.addItemQueue(book1, student2);
        assertEquals(bookQueue.itemQueueSize(), 2);
        PriorityQueue<Member> members1 = bookQueue.getItemQueue(book1);
        assertTrue(members1.size() == 2);
    }

    @Test
    public void testGetAllItemQueue() throws Exception {
        bookQueue.addItemQueue(book1, staff1);
        bookQueue.addItemQueue(book1, student1);
        bookQueue.addItemQueue(book2, student2);
        bookQueue.addItemQueue(book2, student1);
        bookQueue.addItemQueue(book1, student2);
        assertEquals(bookQueue.itemQueueSize(), 2);
        ArrayList<Book> books1 = new ArrayList<>();
        ArrayList<PriorityQueue<Member>> membersList = bookQueue.getAllItemQueue(books);
        assertTrue(membersList.size() == 2);
        PriorityQueue<Member> members1 = membersList.get(0);
        members1.addAll(membersList.get(1));
        assertEquals(members1.size(), 5);
        assertEquals(members1.peek().getFullName(), staff1.getFullName());
    }

    @Test
    public void testRemoveItemQueue() throws Exception {
        bookQueue.addItemQueue(book1, student1);
        bookQueue.addItemQueue(book2, student2);
        bookQueue.addItemQueue(book2, student1);
        bookQueue.addItemQueue(book1, student2);
        assertEquals(bookQueue.itemQueueSize(), 2);
        bookQueue.removeItemQueue(book1);
        assertEquals(bookQueue.itemQueueSize(), 1);
    }

    @Test
    public void testRemoveAllItemsQueue() throws Exception {
        bookQueue.addItemQueue(book1, student1);
        bookQueue.addItemQueue(book2, student2);
        bookQueue.addItemQueue(book2, student1);
        bookQueue.addItemQueue(book1, student2);
        assertEquals(bookQueue.itemQueueSize(), 2);
        bookQueue.removeAllItemsQueue(books);
        assertEquals(bookQueue.itemQueueSize(), 0);
    }

    @Test
    public void testIterator() throws Exception {
        bookQueue.addItemQueue(book1, student1);
        bookQueue.addItemQueue(book2, student2);
        bookQueue.addItemQueue(book2, student1);
        bookQueue.addItemQueue(book1, staff1);
        assertEquals(bookQueue.itemQueueSize(), 2);
        Iterator<Member> iterator = bookQueue.iterator(book1);
        int i=0;
        while (iterator.hasNext()){
            Member member = iterator.next();
            assertEquals(member.getFullName(), members.get(i++).getFullName()); //uses members object structure.
        }
    }

    @Test
    public void testItemQueueSize() throws Exception {
        bookQueue.addItemQueue(book1, staff1);
        bookQueue.addItemQueue(book1, student1);
        bookQueue.addItemQueue(book2, student2);
        bookQueue.addItemQueue(book2, student1);
        assertEquals(bookQueue.itemQueueSize(), 2);
    }

    @Test
    public void testItemQueueContains() throws Exception {
        bookQueue.addItemQueue(book1, staff1);
        bookQueue.addItemQueue(book1, student1);
        bookQueue.addItemQueue(book2, student2);
        bookQueue.addItemQueue(book2, student1);
        assertEquals(bookQueue.itemQueueSize(), 2);
        assertTrue(bookQueue.itemQueueContains(book1));
    }

    @Test
    public void testItemQueueToArray() throws Exception {
        bookQueue.addItemQueue(book1, student1);
        bookQueue.addItemQueue(book1, student2);
        bookQueue.addItemQueue(book1, staff1);
        bookQueue.addItemQueue(book2, student2);
        bookQueue.addItemQueue(book2, student1);
        assertEquals(bookQueue.itemQueueSize(), 2);
        assertArrayEquals(bookQueue.itemQueueToArray(book1), members.toArray());
    }

    @Test
    public void testClearItemQueue() throws Exception {
        bookQueue.addItemQueue(book1, student1);
        bookQueue.addItemQueue(book1, student2);
        bookQueue.addItemQueue(book1, staff1);
        bookQueue.addItemQueue(book2, student2);
        bookQueue.addItemQueue(book2, student1);
        assertEquals(bookQueue.itemQueueSize(), 2);
        bookQueue.clearItemQueue();
        assertEquals(bookQueue.itemQueueSize(), 0);
    }
}