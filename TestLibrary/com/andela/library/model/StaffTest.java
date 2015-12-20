package com.andela.library.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StaffTest {

    Staff staff1;
    Student student1;

    @Before
    public void setUp() throws Exception {

        staff1 = new Staff("OLUWATOSIN ADESANYA");
        staff1.setId(2);
        student1 = new Student("DANIEL JAMES");
        student1.setId(1);

    }

    @Test
    public void testCompareTo() throws Exception {

        assertTrue(staff1.compareTo(student1) == -1);

    }
}