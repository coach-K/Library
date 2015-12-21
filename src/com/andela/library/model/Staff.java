package com.andela.library.model;


public class Staff extends Member {

    public Staff(String fullName) {
        super(fullName);
    }

    @Override
    public int compareTo(Member o) {
        return (o instanceof Student || this.getId() < o.getId()) ? -1 : 1;
    }
}
