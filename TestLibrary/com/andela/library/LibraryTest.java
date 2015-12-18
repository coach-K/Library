package com.andela.library;

import com.andela.library.model.Book;
import com.andela.library.model.Member;
import com.andela.library.model.Staff;
import com.andela.library.model.Student;
import com.andela.library.queue.BookQueue;
import org.junit.Test;

import static org.junit.Assert.*;

public class LibraryTest {

    @org.junit.Before
    public void setUp() throws Exception {

    }

    @Test
    public void testBook(){

        Book book1 = new Book("BECOME A BETTER YOU", "ISBN-23");

    }

    @Test
    public void testStaff(){

        Staff staff1 = new Staff("Adesanya Tosin");

    }

    @Test
    public void testStudent(){

        Student student1 = new Student("Daniel James");

    }

    @Test
    public void testBookQueue(){

        BookQueue bookQueue = new BookQueue();

    }

}