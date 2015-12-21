package com.andela.library.model;


public class Student extends Member {

    public Student(String fullName) {
        super(fullName);
    }

    @Override
    public int compareTo(Member o) {
        return (o instanceof Staff || o.getId() < this.getId()) ? 1 : -1;
    }
}
