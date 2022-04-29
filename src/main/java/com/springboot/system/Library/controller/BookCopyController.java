package com.springboot.system.Library.controller;
import com.springboot.system.Library.entities.Author;
import com.springboot.system.Library.entities.BookCopy;
import com.springboot.system.Library.enums.BookFormat;
import com.springboot.system.Library.enums.BookStatus;
import com.springboot.system.Library.error.status.NotFound;
import com.springboot.system.Library.model.FirstNameLastName;
import com.springboot.system.Library.services.interfaces.BookCopyInterfaceService;
import com.springboot.system.Library.utilities.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookCopyController {

    private final BookCopyInterfaceService bookCopyInterfaceService;

    public BookCopyController(BookCopyInterfaceService bookCopyInterfaceService){
        this.bookCopyInterfaceService = bookCopyInterfaceService;
    }

    @GetMapping("/get")
    public List<BookCopy> getAllBookCopies(){
        return this.bookCopyInterfaceService.getAllBookCopies();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<BookCopy> getBookById(@PathVariable(value = "id") Long id) throws NotFound {
        return this.bookCopyInterfaceService.getBookById(id);
    }

    @GetMapping("/getByStatus/{status}")
    public Optional<List<BookCopy>> getBookByStatus(@PathVariable(value = "status")BookStatus bookStatus){
        return this.bookCopyInterfaceService.getBooksByStatus(bookStatus);
    }

    @GetMapping("/getByFormat/{format}")
    public Optional<List<BookCopy>> getBookByFormat(@PathVariable(value = "format")BookFormat bookFormat){
        return this.bookCopyInterfaceService.getBooksByFormat(bookFormat);
    }

    @PostMapping("/create")
    public BookCopy createBookCopy(@RequestBody BookCopy bookCopy){
        return this.bookCopyInterfaceService.createBookCopy(bookCopy);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<BookCopy> updateBookCopy(@PathVariable(value = "id") Long id, @Valid @RequestBody BookCopy bookCopy) throws NotFound {
        return this.bookCopyInterfaceService.updateBook(id, bookCopy);
    }

    @DeleteMapping("/delete/{id}")
    public Map<String, Boolean> deleteBookCopy(@PathVariable(value = "id") Long id) throws NotFound {
        return this.bookCopyInterfaceService.deleteBook(id);
    }

    @PutMapping("/addAuthors/{id}")
    public Map<String, Boolean> addAuthors(@PathVariable(value = "id") Long id, @Valid @RequestBody Author authors) throws NotFound {
        return this.bookCopyInterfaceService.assignAuthorsToBook(id, authors);
    }

    @GetMapping("/getBooksByAuthor")
    public List<BookCopy> getBooksByAuthor(@RequestBody @Valid FirstNameLastName firstNameLastName) throws NotFound {
        return this.bookCopyInterfaceService.getBooksByAuthor(firstNameLastName);
    }

}
