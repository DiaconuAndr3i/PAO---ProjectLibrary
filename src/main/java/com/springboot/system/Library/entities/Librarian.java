package com.springboot.system.Library.entities;

import com.springboot.system.Library.utilities.Person;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "librarian")
public class Librarian extends Person {

    public Librarian(String firstName, String lastName, Address address, String phoneNumber, long id) {
        super(firstName, lastName, address, phoneNumber, id);
    }

    public Librarian() {
        this(null, null, null, null, 0);
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "Type: " + "librarian";
    }
}
