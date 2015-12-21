# Checkpoint One

>Research reveals that most people visit fun environments such as cinemas, churches, libraries, amusement pack e.t.c because of its organized fun activities. Organized places, events or organization attracts people. 

>Imagine how muddled a church or a Software development process or a football team would be if it's not organized. 
#####
For instance, let's take a real life Book Library process where Staff has priority over Students.

1.  Before a book is lend out.
2.  Library Manager verifies that requester (Staff or Student) is a member of its Book Library, else no book is lend out.
3.  If requester is a member then Library Manager checks if the requested book is available.
4.  If true then the book is lend out based on set priority.

>This process can be hectic with large number of requesters'.

# Library
UML Class Diagram

![Alt text](https://github.com/andela-kogunde/Library/blob/ft-test-to-fail-and-pass-application-logic-110294434/diagram.png?raw=true "Optional Title")

  __Library__  is a java package that aims at simplifying a tedious organized process. It is packaged with an ItemQueue class to handle prioritization.
It also has the capacity and efficiency to manage and organize large number of requesters'. 

  __Library__   Package is easy to setup and requires no extra plug-in.

#

# Features
### Manage member of an organization. 

* Abstract Member (class) : Has a particular ability to manage member information e.g. (id, name);

### Manage items (Books, Pen etc) of an organization. 

* Abstract Item (Class): Has the ability to manages items own by the organization e.g. (Book for Library, Jersey for Football club).

### Prioritize members.

* ItemQueue (Class) : Has the ability to prioritize member e.g. (Staff over Student of a Library, Coach over players of a Football team).

#
### Examples and Usage (Creating a simple Book Library)

>Extend a Member Class
#

```Java
public class Student extends Member {
	
	public Student(String fullName) {
        super(fullName);
    }

    @Override
    public int compareTo(Member o) {
        return 0;
    }
}

public class Staff extends Member {
	
	public Staff(String fullName) {
        super(fullName);
    }

    @Override
    public int compareTo(Member o) {
        return 0;
    }
}

Student student = new Student("John Doe");
Staff staff = new Staff("Jane Doe");
```

#
#
>Extend Item Class
#

```Java
public class Book extends Item {

    private String title;

    public Book(String title, int totalCopies) {
        super(totalCopies);
        this.title = title;
    }

}

Book book = new Book("JAVA PROGRAMMING", 4);
```

#
#

>Extends ItemQueue class
#

```Java
public class BookQueue extends ItemQueue<Book, Member> {

    public BookQueue() {
        super();
    }

}
```

#
#

>Extends Organization class
#

```Java
public class Library extends Organization<Book, Member> {

    BookQueue bookQueue;
    
    public Library() {
        super();
        bookQueue = new BookQueue();
    }

}

Library library = new Library();
```

#
#
### Checkpoint one (Library) has a Book Library packaged with it.
#

```Java
Library library = new Library();
```
#

>ADD MEMBERS TO LIBRARY
#

```Java
library.addMember(staff);
library.addMember(student);
```
#

>ADD BOOKS TO LIBRARY
#

```Java
library.addItem(book);
```
#

>REQUESTER TO MAKE A BOOK REQUEST
#

```Java
library.addBookRequest(book, student);
```
#

>GET NUMBER OF BOOKS BORROWED
#
```Java
library.sizeOfBorrowedBooks()
```
#
>GET BORROWED BOOK MEMBERS
#
```Java
PriorityQueue<Member> members = library.getBorrowedBook(book);
```
#
>USING BORROWED BOOKS AND MEMBERS
#
```Java
while (book.getTotalItem() > 0 && members.poll() != null) {
    book.setTotalItem(book.getTotalItem() - 1);
}
```
#
>MORE HELPFUL METHODS.
#
```Java
library.isBorrowedBookEmpty();
library.borrowedBookContains(book); 
library.borrowedBookIterator(book);
library.removeBorrowedBook(book); 
library.clearBookRequest();
```
#
### Get Checkpoint One (Library)
#
```
Local Checkout 
git clone https://github.com/andela-kogunde/Library.git
```
#
### Projects using Checkpoint One (Library)
There are few numbers of apps that uses __"Checkpoint One (Library)"__. Feel free to contact me or submit a pull request to add yours to this list.

* Book Library


### Development

Want to contribute? Great!

1.  Fork [__Library__](https://github.com/andela-kogunde/Library.git) repository.
2.  Make the fix.
3.  Submit a pull request.

### Todos

 - Add more organizations such as (Football Club, Golf Club)
 - Add more Item such as (Jerseys, Golf Carts)

License
----

MIT


**Free Software!**
#
#
