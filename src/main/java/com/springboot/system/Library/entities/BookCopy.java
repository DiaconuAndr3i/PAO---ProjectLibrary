package com.springboot.system.Library.entities;

import com.springboot.system.Library.enums.BookFormat;
import com.springboot.system.Library.enums.BookStatus;
import com.springboot.system.Library.utilities.Book;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "book")
public class BookCopy extends Book {

    @ManyToMany
    @JoinTable(name = "BooksAuthors",
            joinColumns = { @JoinColumn(name = "fk_book") },
            inverseJoinColumns = { @JoinColumn(name = "fk_author") })
    private Set<Author> authors;

    private BookStatus bookStatus;

    public BookCopy(long id, String title, String subject, BookFormat bookFormat, Set<Author> authors, BookStatus bookStatus) {
        super(id, title, subject, bookFormat);
        this.bookStatus = bookStatus;
        this.authors = authors;
    }

    public BookCopy() {
        this(0, null, null, BookFormat.UNKNOWN, null, BookStatus.UNKNOWN);
    }

    public BookStatus getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(BookStatus bookStatus) {
        this.bookStatus = bookStatus;
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
