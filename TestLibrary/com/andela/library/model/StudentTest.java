package com.andela.library.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class StudentTest {

    Staff staff1;
    Student student1;

    @Before
    public void setUp() throws Exception {

        staff1 = new Staff("OLUWATOSIN ADESANYA");
        staff1.setId(1);
        student1 = new Student("DANIEL JAMES");
        student1.setId(2);

    }

    @Test
    public void testCompareTo() throws Exception {

        assertTrue(student1.compareTo(staff1) == 1);

    }
}