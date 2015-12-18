package com.andela.library.model;


public class Staff extends Member {

    public Staff(String fullName) {
        super(fullName);
    }

    @Override
    public int compareTo(Member o) {
        return 0;
    }
}
