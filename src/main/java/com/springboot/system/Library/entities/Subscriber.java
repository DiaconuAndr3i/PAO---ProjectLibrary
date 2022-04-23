package com.springboot.system.Library.entities;

import com.springboot.system.Library.utilities.Person;

import javax.persistence.*;

@Entity
@Table(name = "subscriber")
public class Subscriber extends Person {

    @Column(name = "status")
    private String status;

    @Column(name = "loans")
    private Integer booksBorrowed;

    public Subscriber(String firstName, String lastName, Address address, String phoneNumber, long id, String status, Integer booksBorrowed) {
        super(firstName, lastName, address, phoneNumber, id);
        this.status = status;
        this.booksBorrowed = booksBorrowed;
    }

    public Subscriber() {
        this(null, null, null, null, 0, "Unknown", 0);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getBooksBorrowed() {
        return booksBorrowed;
    }

    public void setBooksBorrowed(Integer booksBorrowed) {
        this.booksBorrowed = booksBorrowed;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "Type: " + "subscriber";
    }
}
