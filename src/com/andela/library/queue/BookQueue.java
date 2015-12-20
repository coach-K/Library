package com.andela.library.queue;


import com.andela.library.model.Book;
import com.andela.library.model.Item;
import com.andela.library.model.Member;

import java.util.Collection;

public class BookQueue extends ItemQueue<Book, Member> {

    public BookQueue(){
        super();
    }

    public void singleBookSingleMemberRequest(Book book, Member member){
        addItem(book);
        addMember(member);
    }

    public void multipleBookSingleMemberRequest(Collection<Book> book, Member member){
        addAllItems(book);
        addMember(member);
    }

    public void multipleBookMultipleMemberRequest(Collection<Book> book, Collection<Member> member){
        addAllItems(book);
        addAllMembers(member);
    }

    public void singleBookMultipleMemberRequest(Book book, Collection<Member> member){
        addItem(book);
        addAllMembers(member);
    }

}
