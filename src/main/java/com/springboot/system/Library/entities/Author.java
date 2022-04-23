package com.springboot.system.Library.entities;

import com.springboot.system.Library.utilities.Book;
import com.springboot.system.Library.utilities.Person;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "author")
public class Author extends Person {

    @ManyToMany(mappedBy="authors")
    private final Set<BookCopy> bookCopies = new HashSet<>();

    public Author(String firstName, String lastName, Address address, String phoneNumber, long id) {
        super(firstName, lastName, address, phoneNumber, id);
    }

    public Author() {
        this(null, null, null, null, 0);
    }

   public Set<BookCopy> getBookCopies() {
        return bookCopies;
    }

    public void addBookCopy(BookCopy bookCopy){
        this.bookCopies.add(bookCopy);
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "Type: " + "Author";
    }
}
