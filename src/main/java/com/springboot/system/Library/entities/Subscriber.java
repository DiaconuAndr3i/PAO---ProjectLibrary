package com.springboot.system.Library.entities;

import com.springboot.system.Library.enums.SubscriberStatus;
import com.springboot.system.Library.utilities.Person;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "subscriber")
public class Subscriber extends Person {

    @Column(name = "status")
    private SubscriberStatus subscriberStatus;

    @Column(name = "loans")
    private Integer numberBooksBorrowed;

    public Subscriber(String firstName, String lastName, Address address, String phoneNumber, SubscriberStatus subscriberStatus, Integer numberBooksBorrowed) {
        super(firstName, lastName, address, phoneNumber);
        this.subscriberStatus = subscriberStatus;
        this.numberBooksBorrowed = numberBooksBorrowed;
    }

    public Subscriber() {
    }

    public SubscriberStatus getSubscriberStatus() {
        return subscriberStatus;
    }

    public void setSubscriberStatus(SubscriberStatus subscriberStatus) {
        this.subscriberStatus = subscriberStatus;
    }

    public Integer getNumberBooksBorrowed() {
        return numberBooksBorrowed;
    }

    public void setNumberBooksBorrowed(Integer numberBooksBorrowed) {
        this.numberBooksBorrowed = numberBooksBorrowed;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "Type: " + "subscriber";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Subscriber that = (Subscriber) o;
        return subscriberStatus == that.subscriberStatus && Objects.equals(numberBooksBorrowed, that.numberBooksBorrowed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), subscriberStatus, numberBooksBorrowed);
    }
}
