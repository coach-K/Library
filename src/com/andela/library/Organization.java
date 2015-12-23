package com.andela.library;


import com.andela.library.model.Item;
import com.andela.library.model.Member;

import java.util.ArrayList;
import java.util.Collection;

/**
 * An abstract generic Organization class
 * Manages the B of Item class and M of Member class.
 * @param <B> B of Item class
 * @param <M> M of Member class
 */
public abstract class Organization<B extends Item, M extends Member> {

    ArrayList<M> memberList;
    ArrayList<B> itemList;

    int memberCounter;
    int itemCounter;

    /**
     * Create new instance of Organization class
     */
    public Organization() {
        memberList = new ArrayList<>();
        itemList = new ArrayList<>();
    }

    /**
     * Add an item to itemList.
     * @param item item to be added.
     */
    public void addItem(B item) {
        item.setId(itemCounter);
        itemList.add(item);
        itemCounter++;
    }

    /**
     * Add a collection of item to itemList.
     * @param items collections to be added
     */
    public void addAllItems(Collection<? extends B> items) {
        for (B item : items) {
            addItem(item);
        }
    }

    /**
     * Get item by index.
     * @param index index position of item
     * @return Item
     */
    public B getItem(int index) {
        return itemList.get(index);
    }

    /**
     * Get itemList.
     * @return ArrayList
     */
    public ArrayList<B> getAllItems() {
        return itemList;
    }

    /**
     * Remove item from itemList.
     * @param item item to be removed.
     */
    public void removeItem(B item) {
        itemList.remove(item);
    }

    /**
     * Remove item from itemList by index.
     * @param index index position of item.
     */
    public void removeItem(int index) {
        itemList.remove(index);
    }

    /**
     * Remove collection of items from itemList.
     * @param items collection to be removed.
     */
    public void removeAllItems(Collection<? extends B> items) {
        for (B item : items) {
            removeItem(item);
        }
    }

    /**
     * Get the size of itemList.
     * @return int
     */
    public int itemSize() {
        return itemList.size();
    }

    /**
     * Clear itemList.
     */
    public void clearItems() {
        itemList.clear();
    }

    /**
     * Add member to memberList.
     * @param member member to be added.
     */
    public void addMember(M member) {
        member.setId(memberCounter);
        memberList.add(member);
        memberCounter++;
    }

    /**
     * Add collection of member to memberList.
     * @param members collection to be added.
     */
    public void addAllMembers(Collection<? extends M> members) {
        for (M member : members) {
            addMember(member);
        }
    }

    /**
     * Get member in the corresponding index.
     * @param index index position of the member.
     * @return Member
     */
    public M getMember(int index) {
        return memberList.get(index);
    }

    /**
     * Get all member in memberList
     * @return ArrayList of Member
     */
    public ArrayList<M> getAllMembers() {
        return memberList;
    }

    /**
     * Remove member from memberList
     * @param member
     */
    public void removeMember(M member) {
        memberList.remove(member);
    }

    /**
     * Remove member from memberList by index.
     * @param index index position of member.
     */
    public void removeMember(int index) {
        memberList.remove(index);
    }

    /**
     * remove the specified collection of member from memberList.
     * @param members collection to be removed.
     */
    public void removeAllMembers(Collection<? extends M> members) {
        for (M member : members) {
            removeMember(member);
        }
    }

    /**
     * Gets the size of memberList.
     * @return int
     */
    public int memberSize() {
        return memberList.size();
    }

    /**
     * Clears memberList.
     */
    public void clearMembers() {
        memberList.clear();
    }

    /**
     * Checks if the specified member is registered.
     * @param member member to check.
     * @return boolean
     */
    public boolean isMemberRegistered(M member) {
        return memberList.indexOf(member) != -1;
    }

    /**
     * Checks if the specified item is registered.
     * @param item item to check
     * @return boolean
     */
    public boolean isItemRegistered(B item) {
        return itemList.indexOf(item) != -1;
    }

    /**
     * Checks if itemList is empty
     * @return boolean
     */
    public boolean isItemEmpty() {
        return itemList.size() == 0;
    }

    /**
     * Checks if memberList is empty
     * @return boolean
     */
    public boolean isMemberEmpty() {
        return memberList.size() == 0;
    }

    /**
     * Checks if itemList contains item.
     * @param item item to check.
     * @return boolean
     */
    public boolean itemContains(B item) {
        return itemList.contains(item);
    }

    /**
     * Checks if memberList contains members.
     * @param member member to check.
     * @return boolean
     */
    public boolean memberContains(M member) {
        return memberList.contains(member);
    }

}
