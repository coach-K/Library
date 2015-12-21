package com.andela.library;


import com.andela.library.model.Item;
import com.andela.library.model.Member;

import java.util.ArrayList;
import java.util.Collection;

public abstract class Organization<B extends Item, M extends Member> {

    ArrayList<M> memberList;
    ArrayList<B> itemList;

    int memberCounter;
    int itemCounter;

    public Organization() {
        memberList = new ArrayList<>();
        itemList = new ArrayList<>();
    }

    public void addItem(B item) {
        item.setId(itemCounter);
        itemList.add(item);
        itemCounter++;
    }

    public void addAllItems(Collection<? extends B> items) {
        for (B item : items) {
            addItem(item);
        }
    }

    public B getItem(int index) {
        return itemList.get(index);
    }

    public ArrayList<B> getAllItems() {
        return itemList;
    }

    public void removeItem(B item) {
        itemList.remove(item);
    }

    public void removeItem(int index) {
        itemList.remove(index);
    }

    public void removeAllItems(Collection<? extends B> items) {
        for (B item : items) {
            removeItem(item);
        }
    }

    public int itemSize() {
        return itemList.size();
    }

    public void clearItems() {
        itemList.clear();
    }

    public void addMember(M member) {
        member.setId(memberCounter);
        memberList.add(member);
        memberCounter++;
    }

    public void addAllMembers(Collection<? extends M> members) {
        for (M member : members) {
            addMember(member);
        }
    }

    public M getMember(int index) {
        return memberList.get(index);
    }

    public ArrayList<M> getAllMembers() {
        return memberList;
    }

    public void removeMember(M member) {
        memberList.remove(member);
    }

    public void removeMember(int index) {
        memberList.remove(index);
    }

    public void removeAllMembers(Collection<? extends M> members) {
        for (M member : members) {
            removeMember(member);
        }
    }

    public int memberSize() {
        return memberList.size();
    }

    public void clearMembers() {
        memberList.clear();
    }

    public boolean isMemberRegistered(M member) {
        return memberList.indexOf(member) != -1;
    }

    public boolean isItemRegistered(B item) {
        return itemList.indexOf(item) != -1;
    }

    public boolean isItemEmpty() {
        return itemList.size() == 0;
    }

    public boolean isMemberEmpty() {
        return memberList.size() == 0;
    }

    public boolean itemContains(B item) {
        return itemList.contains(item);
    }

    public boolean memberContains(M member) {
        return memberList.contains(member);
    }

}
