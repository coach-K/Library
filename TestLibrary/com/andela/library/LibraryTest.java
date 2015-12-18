package com.andela.library;

import com.andela.library.model.Book;
import com.andela.library.model.Staff;
import com.andela.library.model.Student;
import org.junit.Test;

import static org.junit.Assert.*;

public class LibraryTest {

    @org.junit.Before
    public void setUp() throws Exception {

    }

    @Test
    public void testBook(){

        Book book1 = new Book(1, "BECOME A BETTER YOU", "ISBN-23", 5);

    }

    @Test
    public void testStaff(){

        Staff staff1 = new Staff("Adesanya Tosin");

    }

    @Test
    public void testStudent(){

        Student student1 = new Student("Daniel James");

    }

}