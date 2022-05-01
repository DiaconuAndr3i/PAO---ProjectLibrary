package com.springboot.system.Library.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.springboot.system.Library.enums.BookFormat;
import com.springboot.system.Library.enums.BookStatus;
import com.springboot.system.Library.utilities.Book;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "book")
public class BookCopy extends Book {

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "BooksAuthors",
            joinColumns = { @JoinColumn(name = "fk_book") },
            inverseJoinColumns = { @JoinColumn(name = "fk_author") })
    @JsonIgnore
    private Set<Author> authors = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private List<Loans> loans = new ArrayList<>();

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

    public List<Loans> getLoan() {
        return loans;
    }

    public void setLoan(List<Loans> loans) {
        this.loans = loans;
    }

    public void addLoan(Loans loan){
        this.getLoan().add(loan);
    }

    @Override
    public String toString() {
        return "BookCopy{" +
                "authors=" + authors +
                ", loan=" + loans +
                ", bookStatus=" + bookStatus +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BookCopy bookCopy = (BookCopy) o;
        return Objects.equals(authors, bookCopy.authors) && Objects.equals(loans, bookCopy.loans) && bookStatus == bookCopy.bookStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), authors, loans, bookStatus);
    }
}
