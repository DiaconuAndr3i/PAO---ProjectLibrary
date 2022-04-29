package com.springboot.system.Library.entities;

import com.springboot.system.Library.utilities.Person;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "librarian")
public class Librarian extends Person {

    public Librarian(String firstName, String lastName, Address address, String phoneNumber) {
        super(firstName, lastName, address, phoneNumber);
    }

    public Librarian() {

    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "Type: " + "librarian";
    }
}
