package com.springboot.system.Library.utilities;

import com.springboot.system.Library.enums.BookFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@MappedSuperclass
public abstract class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "subject")
    private String subject;

    @Column(name = "book_format")
    private BookFormat bookFormat;

    public Book(long id, String title, String subject, BookFormat bookFormat) {
        this.id = id;
        this.title = title;
        this.subject = subject;
        this.bookFormat = bookFormat;
    }

    public Book() {
    }

    public long getid() {
        return id;
    }

    public void setid(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public BookFormat getBookFormat() {
        return bookFormat;
    }

    public void setBookFormat(BookFormat bookFormat) {
        this.bookFormat = bookFormat;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", subject='" + subject + '\'' +
                ", bookFormat=" + bookFormat +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id && Objects.equals(getTitle(), book.getTitle()) && Objects.equals(getSubject(), book.getSubject()) && getBookFormat() == book.getBookFormat();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, subject, bookFormat);
    }
}
