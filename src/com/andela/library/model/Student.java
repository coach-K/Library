package com.andela.library.model;

/**
 * Student class extends Member class.
 */
public class Student extends Member {

    /**
     * Create a new instance of Student.
     * Get the full name of a student
     * @param fullName The fullname of a student.
     */
    public Student(String fullName) {
        super(fullName);
    }

    /**
     * Compares with an object of Member class
     * @param member the member to be compared.
     * @return 1 or -1
     */
    @Override
    public int compareTo(Member member) {
        return (member instanceof Staff || member.getId() < this.getId()) ? 1 : -1;
    }
}
