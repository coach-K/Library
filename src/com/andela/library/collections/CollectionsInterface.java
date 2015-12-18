package com.andela.library.collections;


import com.andela.library.model.Item;
import com.andela.library.model.Member;

import java.util.Collection;

public interface CollectionsInterface<B extends Item, M extends Member> {

    public void addItem(B item);
    public void addAllItems(Collection<B> items);
    public B getItem(int index);
    public Collection<B> getAllItems();
    public void removeItem(B book);
    public void removeAllItems(Collection<B> books);
    public int itemSize();
    public void clearItems();

    public void addMember(M member);
    public void addAllMembers(Collection<M> members);
    public M getMember(int index);
    public Collection<M> getAllMembers();
    public void removeMember(M member);
    public void removeAllMembers(Collection<M> members);
    public int memberSize();
    public void clearMembers();

}
