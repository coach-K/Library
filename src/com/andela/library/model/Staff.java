package com.andela.library.model;

/**
 * Staff class extends Member class.
 */
public class Staff extends Member {

    /**
     * Create new instance of Staff.
     * Get the full name of a staff.
     * @param fullName the fullname of a staff
     */
    public Staff(String fullName) {
        super(fullName);
    }

    /**
     * Compares with an object of Member class.
     * @param member the member of be compared.
     * @return 1 or -1
     */
    @Override
    public int compareTo(Member member) {
        return (member instanceof Student || this.getId() < member.getId()) ? -1 : 1;
    }
}
