package com.springboot.system.Library.services;

import com.springboot.system.Library.entities.Author;
import com.springboot.system.Library.entities.BookCopy;
import com.springboot.system.Library.enums.BookFormat;
import com.springboot.system.Library.enums.BookStatus;
import com.springboot.system.Library.error.status.NotFound;
import com.springboot.system.Library.model.FirstNameLastName;
import com.springboot.system.Library.repository.BookCopyRepository;
import com.springboot.system.Library.services.interfaces.AuditInterfaceService;
import com.springboot.system.Library.services.interfaces.BookCopyInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class BookCopyService implements BookCopyInterfaceService {

    @Autowired
    private final BookCopyRepository bookCopyRepository;
    @Autowired
    private final AuditInterfaceService auditInterfaceService;

    public BookCopyService(BookCopyRepository bookCopyRepository, AuditInterfaceService auditInterfaceService){
        this.bookCopyRepository = bookCopyRepository;
        this.auditInterfaceService = auditInterfaceService;
    }

    @Override
    public List<BookCopy> getAllBookCopies() {
        try{
            return this.bookCopyRepository.findAll();
        }
        catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
        finally {
            this.auditInterfaceService.createAction("get all books");
        }
    }

    @Override
    public BookCopy createBookCopy(BookCopy bookCopy) {
        try{
            return this.bookCopyRepository.save(bookCopy);
        }
        catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
        finally {
            this.auditInterfaceService.createAction("create book");
        }
    }

    @Override
    public ResponseEntity<BookCopy> getBookById(Long Id) throws NotFound {
        BookCopy bookCopy = this.bookCopyRepository.findById(Id).orElseThrow(() -> new NotFound("Book with id " + Id + " doesn't exist"));
        this.auditInterfaceService.createAction("get book by id");
        return ResponseEntity.ok().body(bookCopy);
    }

    @Override
    public ResponseEntity<BookCopy> updateBook(Long id, BookCopy bookCopy) throws NotFound {
        BookCopy book = this.bookCopyRepository.findById(id).orElseThrow(() -> new NotFound("Book with id " + id + " doesn't exist"));

        book.setBookStatus(bookCopy.getBookStatus());
        book.setBookFormat(bookCopy.getBookFormat());
        book.setSubject(bookCopy.getSubject());
        book.setTitle(bookCopy.getTitle());

        this.auditInterfaceService.createAction("book updated");

        return ResponseEntity.ok(this.bookCopyRepository.save(book));
    }

    @Override
    public Map<String, Boolean> assignAuthorsToBook(Long id, Author author) throws NotFound{
        BookCopy book = this.bookCopyRepository.findById(id).orElseThrow(() -> new NotFound("Book with id " + id + " doesn't exist"));

        book.addAuthor(author);
        author.addBookCopy(book);

        this.bookCopyRepository.save(book);

        this.auditInterfaceService.createAction("assign author to book");
        Map<String, Boolean> res = new HashMap<>();
        res.put("Author added", Boolean.TRUE);

        return res;
    }

    @Override
    public List<BookCopy> getBooksByAuthor(FirstNameLastName firstNameLastName) throws NotFound {
        List<BookCopy> books = this.bookCopyRepository.findBooksByAuthor(firstNameLastName.getFirstName(), firstNameLastName.getLastName())
                .orElseThrow(() -> new NotFound("There is no book written by the author: " + firstNameLastName.getFirstName() + " " + firstNameLastName.getLastName()));

        this.auditInterfaceService.createAction("get books by author");

        return books;
    }

    @Override
    public Map<String, Boolean> deleteBook(Long id) throws NotFound {
        BookCopy bookCopy = this.bookCopyRepository.findById(id).orElseThrow(() -> new NotFound("Book with id " + id + " doesn't exist"));

        this.bookCopyRepository.deleteFromBooksAuthors(id);
        this.bookCopyRepository.delete(bookCopy);

        Map<String, Boolean> res = new HashMap<>();
        res.put("Book deleted", Boolean.TRUE);

        this.auditInterfaceService.createAction("book deleted");

        return res;
    }

    @Override
    public Optional<List<BookCopy>> getBooksByStatus(BookStatus bookStatus) {
        try{
            return this.bookCopyRepository.findByBookStatus(bookStatus);
        }
        catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
        finally {
            this.auditInterfaceService.createAction("get book by status");
        }
    }

    @Override
    public Optional<List<BookCopy>> getBooksByFormat(BookFormat bookFormat) {
        try{
            return this.bookCopyRepository.findByBookFormat(bookFormat);
        }
        catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
        finally {
            this.auditInterfaceService.createAction("get book by format");
        }
    }
}
