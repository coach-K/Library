package com.andela.library;

import com.andela.library.model.Book;
import com.andela.library.model.Member;
import com.andela.library.model.Staff;
import com.andela.library.model.Student;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;

import static org.junit.Assert.*;

public class LibraryTest {

    Library library;

    Student student1 = new Student("DANIEL JAMES");
    Student student2 = new Student("GRACE OMOTOSO");
    Student student3 = new Student("OBIOMA");
    Staff staff1 = new Staff("OLUWATOSIN ADESANYA");
    Staff staff2 = new Staff("BUKOLA MAKINWA");

    Book book1 = new Book("GIFTED HANDS", "BEN CARSON", "123-ANDELA", 4);
    Book book2 = new Book("GIFTED LEGS", "NEB SONCAR", "456-ANDELA", 5);
    Book book3 = new Book("GIFTED HEAD", "ENB NCARSO", "789-ANDELA", 6);

    ArrayList<Book> books;

    ArrayList<Member> members;

    @org.junit.Before
    public void setUp() throws Exception {
        library = new Library();

        members = new ArrayList<>();
        members.add(student1);
        members.add(student2);
        members.add(student3);
        members.add(staff1);
        members.add(staff2);

        books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);

    }


    @Test
    public void testAddBookRequest() throws Exception {
        library.addAllItems(books);
        library.addAllMembers(members);
        library.addBookRequest(book2, staff1);
        assertEquals(library.sizeOfBorrowedBooks(), 1);
    }

    @Test
    public void testAddBookRequest1() throws Exception {
        library.addAllItems(books);
        library.addAllMembers(members);
        library.addBookRequest(book2,members);
        assertEquals(library.sizeOfBorrowedBooks(), 1);
    }

    @Test
    public void testAddAllBookRequests() throws Exception {
        library.addAllItems(books);
        library.addAllMembers(members);
        library.addAllBookRequests(books, staff1);
        assertEquals(library.sizeOfBorrowedBooks(), 3);
    }

    @Test
    public void testAddAllBookRequests1() throws Exception {
        library.addAllItems(books);
        library.addAllMembers(members);
        library.addAllBookRequests(books,members);
        assertEquals(library.sizeOfBorrowedBooks(), 3);
    }

    @Test
    public void testGetBorrowedBook() throws Exception {
        library.addAllItems(books);
        library.addAllMembers(members);
        library.addAllBookRequests(books,staff1);
        assertEquals(library.sizeOfBorrowedBooks(), 3);
        PriorityQueue<Member> members1 = library.getBorrowedBook(book1);
        assertEquals(members1.peek().getFullName(), staff1.getFullName());
    }

    @Test
    public void testGetAllBorrowedBooks() throws Exception {
        library.addAllItems(books);
        library.addAllMembers(members);
        library.addAllBookRequests(books,staff1);
        assertEquals(library.sizeOfBorrowedBooks(), 3);
        ArrayList<PriorityQueue<Member>> members1 = library.getAllBorrowedBooks(books);
        assertEquals(members1.get(0).peek().getFullName(), staff1.getFullName());
    }

    @Test
    public void testSizeOfBorrowedBooks() throws Exception {
        library.addAllItems(books);
        library.addAllMembers(members);
        library.addAllBookRequests(books,staff1);
        assertEquals(library.sizeOfBorrowedBooks(), 3);
    }

    @Test
    public void testIsBorrowedBookEmpty() throws Exception {
        assertTrue(library.isBorrowedBookEmpty());
        library.addAllItems(books);
        library.addAllMembers(members);
        library.addAllBookRequests(books, staff1);
        assertEquals(library.sizeOfBorrowedBooks(), 3);
        assertFalse(library.isBorrowedBookEmpty());
    }

    @Test
    public void testBorrowedBookContains() throws Exception {
        assertTrue(library.isBorrowedBookEmpty());
        library.addAllItems(books);
        library.addAllMembers(members);
        library.addAllBookRequests(books, staff1);
        assertEquals(library.sizeOfBorrowedBooks(), 3);
        assertTrue(library.borrowedBookContains(book2));
        assertFalse(library.isBorrowedBookEmpty());
    }

    @Test
    public void testBorrowedBookIterator() throws Exception {
        assertTrue(library.isBorrowedBookEmpty());
        library.addAllItems(books);
        library.addAllMembers(members);
        library.addAllBookRequests(books, staff1);
        assertEquals(library.sizeOfBorrowedBooks(), 3);
        Iterator<Member> iterator = library.borrowedBookIterator(book2);
        while (iterator.hasNext()){
            Member member = iterator.next();
            assertEquals(member.getFullName(), staff1.getFullName());
        }
    }

    @Test
    public void testBorrowedBookToArray() throws Exception {
        assertTrue(library.isBorrowedBookEmpty());
        library.addAllItems(books);
        library.addAllMembers(members);
        library.addAllBookRequests(books, staff1);
        assertEquals(library.sizeOfBorrowedBooks(), 3);
        Member[] members1 = {staff1};
        assertArrayEquals(library.borrowedBookToArray(book2), members1);
    }

    @Test
    public void testRemoveBorrowedBook() throws Exception {
        assertTrue(library.isBorrowedBookEmpty());
        library.addAllItems(books);
        library.addAllMembers(members);
        library.addAllBookRequests(books, staff1);
        assertEquals(library.sizeOfBorrowedBooks(), 3);
        library.removeBorrowedBook(book2);
        assertEquals(library.sizeOfBorrowedBooks(), 2);
    }

    @Test
    public void testRemoveAllBorrowedBook() throws Exception {
        assertTrue(library.isBorrowedBookEmpty());
        library.addAllItems(books);
        library.addAllMembers(members);
        library.addAllBookRequests(books, staff1);
        assertEquals(library.sizeOfBorrowedBooks(), 3);
        library.removeAllBorrowedBook(books);
        assertTrue(library.isBorrowedBookEmpty());
    }

    @Test
    public void testClearBookRequest() throws Exception {
        assertTrue(library.isBorrowedBookEmpty());
        library.addAllItems(books);
        library.addAllMembers(members);
        library.addAllBookRequests(books, staff1);
        assertEquals(library.sizeOfBorrowedBooks(), 3);
        library.clearBookRequest();
        assertTrue(library.isBorrowedBookEmpty());
    }

    @Test
    public void testAddItem() throws Exception {
        assertTrue(library.isItemEmpty());
        library.addItem(book2);
        assertFalse(library.isItemEmpty());
    }

    @Test
    public void testAddAllItems() throws Exception {
        assertTrue(library.isItemEmpty());
        library.addAllItems(books);
        assertFalse(library.isItemEmpty());
    }

    @Test
    public void testGetItem() throws Exception {
        assertTrue(library.isItemEmpty());
        library.addAllItems(books);
        Book book = library.getItem(0);
        assertEquals(book.getTitle(), book1.getTitle());
        assertFalse(library.isItemEmpty());
    }

    @Test
    public void testGetAllItems() throws Exception {
        assertTrue(library.isItemEmpty());
        library.addAllItems(books);
        ArrayList<Book> book = library.getAllItems();
        assertEquals(book.get(1).getTitle(), book2.getTitle());
        assertFalse(library.isItemEmpty());
    }

    @Test
    public void testRemoveItem() throws Exception {
        assertTrue(library.isItemEmpty());
        library.addAllItems(books);
        library.removeItem(book1);
        assertFalse(library.itemContains(book1));
    }

    @Test
    public void testRemoveItem1() throws Exception {
        assertTrue(library.isItemEmpty());
        library.addAllItems(books);
        library.removeItem(0);
        assertFalse(library.itemContains(book1));
    }

    @Test
    public void testRemoveAllItems() throws Exception {
        assertTrue(library.isItemEmpty());
        library.addAllItems(books);
        library.removeAllItems(books);
        assertTrue(library.isItemEmpty());
    }

    @Test
    public void testItemSize() throws Exception {
        assertTrue(library.isItemEmpty());
        library.addAllItems(books);
        assertEquals(library.itemSize(), 3);
    }

    @Test
    public void testClearItems() throws Exception {
        assertTrue(library.isItemEmpty());
        library.addAllItems(books);
        assertEquals(library.itemSize(), 3);
        library.clearItems();
        assertEquals(library.itemSize(), 0);
    }

    @Test
    public void testAddMember() throws Exception {
        assertTrue(library.isMemberEmpty());
        library.addMember(student1);
        assertFalse(library.isMemberEmpty());
    }

    @Test
    public void testAddAllMembers() throws Exception {
        assertTrue(library.isMemberEmpty());
        library.addAllMembers(members);
        assertFalse(library.isMemberEmpty());
    }

    @Test
    public void testGetMember() throws Exception {
        assertTrue(library.isMemberEmpty());
        library.addAllMembers(members);
        assertFalse(library.isMemberEmpty());
        Member member = library.getMember(0);
        assertEquals(member.getFullName(), student1.getFullName());
    }

    @Test
    public void testGetAllMembers() throws Exception {
        assertTrue(library.isMemberEmpty());
        library.addAllMembers(members);
        assertFalse(library.isMemberEmpty());
        ArrayList <Member> members1 = library.getAllMembers();
        assertEquals(members1.get(0).getFullName(), student1.getFullName());
    }

    @Test
    public void testRemoveMember() throws Exception {
        assertTrue(library.isMemberEmpty());
        library.addAllMembers(members);
        assertFalse(library.isMemberEmpty());
        ArrayList <Member> members1 = library.getAllMembers();
        assertEquals(members1.get(0).getFullName(), student1.getFullName());
        assertEquals(library.memberSize(), 5);
        library.removeMember(0);
        library.removeMember(1);
        library.removeMember(2);
        assertEquals(library.memberSize(), 2);
    }

    @Test
    public void testRemoveMember1() throws Exception {
        assertTrue(library.isMemberEmpty());
        library.addAllMembers(members);
        assertFalse(library.isMemberEmpty());
        ArrayList <Member> members1 = library.getAllMembers();
        assertEquals(members1.get(0).getFullName(), student1.getFullName());
        assertEquals(library.memberSize(), 5);
        library.removeMember(staff1);
        library.removeMember(student1);
        library.removeMember(student2);
        assertEquals(library.memberSize(), 2);
    }

    @Test
    public void testRemoveAllMembers() throws Exception {
        assertTrue(library.isMemberEmpty());
        library.addAllMembers(members);
        assertFalse(library.isMemberEmpty());
        ArrayList <Member> members1 = library.getAllMembers();
        assertEquals(members1.get(0).getFullName(), student1.getFullName());
        assertEquals(library.memberSize(), 5);
        library.removeAllMembers(members);
        assertEquals(library.memberSize(), 0);
    }

    @Test
    public void testMemberSize() throws Exception {
        assertTrue(library.isMemberEmpty());
        library.addAllMembers(members);
        assertFalse(library.isMemberEmpty());
        ArrayList <Member> members1 = library.getAllMembers();
        assertEquals(members1.get(0).getFullName(), student1.getFullName());
        assertEquals(library.memberSize(), 5);
        library.removeAllMembers(members);
        assertEquals(library.memberSize(), 0);
    }

    @Test
    public void testClearMembers() throws Exception {
        assertTrue(library.isMemberEmpty());
        library.addAllMembers(members);
        assertFalse(library.isMemberEmpty());
        ArrayList <Member> members1 = library.getAllMembers();
        assertEquals(members1.get(0).getFullName(), student1.getFullName());
        assertEquals(library.memberSize(), 5);
        library.clearMembers();
        assertEquals(library.memberSize(), 0);
    }

    @Test
    public void testIsMemberRegistered() throws Exception {
        assertTrue(library.isMemberEmpty());
        library.addAllMembers(members);
        assertFalse(library.isMemberEmpty());
        ArrayList <Member> members1 = library.getAllMembers();
        assertEquals(members1.get(0).getFullName(), student1.getFullName());
        assertEquals(library.memberSize(), 5);
        assertTrue(library.isMemberRegistered(student2));
        library.removeMember(student2);
        assertFalse(library.isMemberRegistered(student2));
    }

    @Test
    public void testIsItemRegistered() throws Exception {
        assertTrue(library.isItemEmpty());
        library.addAllItems(books);
        assertFalse(library.isItemEmpty());
        assertTrue(library.isItemRegistered(book1));
        library.removeItem(book1);
        assertFalse(library.isItemRegistered(book1));
    }

    @Test
    public void testIsItemEmpty() throws Exception {
        assertTrue(library.isItemEmpty());
        library.addAllItems(books);
        assertFalse(library.isItemEmpty());
    }

    @Test
    public void testIsMemberEmpty() throws Exception {
        assertTrue(library.isMemberEmpty());
        library.addAllMembers(members);
        assertFalse(library.isMemberEmpty());
    }

    @Test
    public void testItemContains() throws Exception {
        assertTrue(library.isItemEmpty());
        library.addAllItems(books);
        assertFalse(library.isItemEmpty());
        assertTrue(library.itemContains(book1));
        library.removeItem(book1);
        assertFalse(library.itemContains(book1));
    }

    @Test
    public void testMemberContains() throws Exception {
        assertTrue(library.isMemberEmpty());
        library.addAllMembers(members);
        assertFalse(library.isMemberEmpty());
        assertTrue(library.memberContains(staff1));
        library.removeMember(staff1);
        assertFalse(library.memberContains(staff1));
    }
}