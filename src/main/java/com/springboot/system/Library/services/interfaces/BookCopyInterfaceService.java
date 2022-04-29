package com.springboot.system.Library.services.interfaces;

import com.springboot.system.Library.entities.Author;
import com.springboot.system.Library.entities.BookCopy;
import com.springboot.system.Library.enums.BookFormat;
import com.springboot.system.Library.enums.BookStatus;
import com.springboot.system.Library.error.status.NotFound;
import com.springboot.system.Library.model.FirstNameLastName;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface BookCopyInterfaceService {
    List<BookCopy> getAllBookCopies();
    BookCopy createBookCopy(BookCopy bookCopy);
    ResponseEntity<BookCopy> getBookById(Long Id) throws NotFound;
    ResponseEntity<BookCopy> updateBook(Long id, BookCopy bookCopy) throws NotFound;
    Map<String, Boolean> deleteBook(Long id) throws NotFound;
    Optional<List<BookCopy>> getBooksByStatus(BookStatus bookStatus);
    Optional<List<BookCopy>> getBooksByFormat(BookFormat bookFormat);
    Map<String, Boolean> assignAuthorsToBook(Long id, Author author) throws NotFound;
    List<BookCopy> getBooksByAuthor(FirstNameLastName firstNameLastName) throws NotFound;
}
