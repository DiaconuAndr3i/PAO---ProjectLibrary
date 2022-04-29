package com.springboot.system.Library.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.springboot.system.Library.enums.BookFormat;
import com.springboot.system.Library.enums.BookStatus;
import com.springboot.system.Library.utilities.Book;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "book")
public class BookCopy extends Book {

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "BooksAuthors",
            joinColumns = { @JoinColumn(name = "fk_book") },
            inverseJoinColumns = { @JoinColumn(name = "fk_author") })
    @JsonIgnore
    private Set<Author> authors = new HashSet<>();

    private BookStatus bookStatus;

    public BookCopy(String title, String subject, BookFormat bookFormat, BookStatus bookStatus) {
        super(title, subject, bookFormat);
        this.bookStatus = bookStatus;
    }

    public BookCopy() {
    }

    public BookStatus getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(BookStatus bookStatus) {
        this.bookStatus = bookStatus;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public void addAuthor(Author author){
        this.getAuthors().add(author);
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "BookCopy{" +
                ", bookStatus=" + bookStatus +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BookCopy bookCopy = (BookCopy) o;
        return getBookStatus() == bookCopy.getBookStatus();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getBookStatus());
    }
}
