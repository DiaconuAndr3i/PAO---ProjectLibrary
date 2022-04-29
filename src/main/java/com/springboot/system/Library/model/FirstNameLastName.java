package com.springboot.system.Library.model;

public class FirstNameLastName {
    private String firstName;
    private String lastName;

    public FirstNameLastName() {
    }

    public FirstNameLastName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
