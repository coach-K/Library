package com.andela.library.queue;


import com.andela.library.model.Book;
import com.andela.library.model.Member;

/**
 * BookQueue class extends ItemQueue class.
 * Holds queue of member for a particular book.
 */
public class BookQueue extends ItemQueue<Book, Member> {

    /**
     * Create new instance of BookQueue.
     */
    public BookQueue() {
        super();
    }

}
