package com.springboot.system.Library.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Loans {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Timestamp startDate;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Timestamp expectationDate;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Timestamp returnDate;

    public Loans( Timestamp startDate, Timestamp expectationDate, Timestamp returnDate) {
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

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Timestamp getExpectationDate() {
        return expectationDate;
    }

    public void setExpectationDate(Timestamp expectationDate) {
        this.expectationDate = expectationDate;
    }

    public Timestamp getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Timestamp returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "Loans{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", expectationDate=" + expectationDate +
                ", returnDate=" + returnDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Loans loans = (Loans) o;
        return id == loans.id && Objects.equals(startDate, loans.startDate) && Objects.equals(expectationDate, loans.expectationDate) && Objects.equals(returnDate, loans.returnDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startDate, expectationDate, returnDate);
    }
}
