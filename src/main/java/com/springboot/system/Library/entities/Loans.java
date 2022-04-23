package com.springboot.system.Library.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class Loans {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Date startDate;
    private Date expectationDate;
    private Date returnDate;

    @OneToOne
    @JoinColumn(name = "subscriber_id")
    private Subscriber subscriber;

    @OneToOne
    @JoinColumn(name = "book_copy_id")
    private BookCopy bookCopy;

    public Loans(long id, Date startDate, Date expectationDate, Date returnDate, Subscriber subscriber, BookCopy bookCopy) {
        super();
        this.id = id;
        this.startDate = startDate;
        this.expectationDate = expectationDate;
        this.returnDate = returnDate;
        this.subscriber = subscriber;
        this.bookCopy = bookCopy;
    }

    public Loans() {
        this(0, null, null, null, null, null);
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

    public void setSubscriber(Subscriber subscriber) {
        this.subscriber = subscriber;
    }

    public void setBookCopy(BookCopy bookCopy) {
        this.bookCopy = bookCopy;
    }

    public BookCopy getBookCopy() {
        return bookCopy;
    }

    public Subscriber getSubscriber() {
        return subscriber;
    }

    @Override
    public String toString() {
        return "Loans{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", expectationDate=" + expectationDate +
                ", returnDate=" + returnDate +
                ", subscriber=" + subscriber +
                ", bookCopy=" + bookCopy +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Loans loans = (Loans) o;
        return getId() == loans.getId() && Objects.equals(getStartDate(), loans.getStartDate()) && Objects.equals(getExpectationDate(), loans.getExpectationDate()) && Objects.equals(getReturnDate(), loans.getReturnDate()) && Objects.equals(getSubscriber(), loans.getSubscriber()) && Objects.equals(getBookCopy(), loans.getBookCopy());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getStartDate(), getExpectationDate(), getReturnDate(), getSubscriber(), getBookCopy());
    }
}
