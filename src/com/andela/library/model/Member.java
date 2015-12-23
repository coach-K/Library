package com.andela.library.model;

/**
 * An abstract Member class.
 */
public abstract class Member implements Comparable<Member> {

    private int id;
    private String fullName;

    /**
     * Gets the full name of a member.
     * @param fullName
     */
    public Member(String fullName) {
        this.fullName = fullName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
