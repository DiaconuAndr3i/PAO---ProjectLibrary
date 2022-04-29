package com.springboot.system.Library.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.springboot.system.Library.utilities.Book;
import com.springboot.system.Library.utilities.Person;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "author")
public class Author extends Person {

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="authors")
    @JsonIgnore
    private Set<BookCopy> bookCopies = new HashSet<>();

    public Author(String firstName, String lastName, Address address, String phoneNumber) {
        super(firstName, lastName, address, phoneNumber);
    }

    public Author() {
    }

    public Set<BookCopy> getBookCopies() {
        return bookCopies;
    }

    public void setBookCopies(Set<BookCopy> bookCopies) {
        this.bookCopies = bookCopies;
    }

    public void addBookCopy(BookCopy bookCopy){
        this.getBookCopies().add(bookCopy);
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "Type: " + "Author";
    }
}
