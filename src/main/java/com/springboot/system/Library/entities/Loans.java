package com.springboot.system.Library.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Loans {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Date startDate;
    private Date expectationDate;
    private Date returnDate;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "library_id", referencedColumnName = "id")
    private List<Library> library = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "subscriber_id", referencedColumnName = "id")
    private List<Subscriber> subscriber = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_copy_id", referencedColumnName = "id")
    private List<BookCopy> bookCopy = new ArrayList<>();

    public Loans( Date startDate, Date expectationDate, Date returnDate) {
        super();
        this.startDate = startDate;
        this.expectationDate = expectationDate;
        this.returnDate = returnDate;
    }

    public Loans() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getExpectationDate() {
        return expectationDate;
    }

    public void setExpectationDate(Date expectationDate) {
        this.expectationDate = expectationDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public List<Library> getLibrary() {
        return library;
    }

    public void setLibrary(List<Library> library) {
        this.library = library;
    }

    public void addLibrary(Library library){
        this.getLibrary().add(library);
    }

    public List<Subscriber> getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(List<Subscriber> subscriber) {
        this.subscriber = subscriber;
    }

    public void addSubscriber(Subscriber subscriber){
        this.getSubscriber().add(subscriber);
    }

    public List<BookCopy> getBookCopy() {
        return bookCopy;
    }

    public void setBookCopy(List<BookCopy> bookCopy) {
        this.bookCopy = bookCopy;
    }

    public void addBookCopy(BookCopy bookCopy){
        this.getBookCopy().add(bookCopy);
    }

    @Override
    public String toString() {
        return "Loans{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", expectationDate=" + expectationDate +
                ", returnDate=" + returnDate +
                ", library=" + library +
                ", subscriber=" + subscriber +
                ", bookCopy=" + bookCopy +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Loans loans = (Loans) o;
        return id == loans.id && Objects.equals(startDate, loans.startDate) && Objects.equals(expectationDate, loans.expectationDate) &&
                Objects.equals(returnDate, loans.returnDate) && Objects.equals(library, loans.library) && Objects.equals(subscriber, loans.subscriber)
                && Objects.equals(bookCopy, loans.bookCopy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startDate, expectationDate, returnDate, library, subscriber, bookCopy);
    }
}
