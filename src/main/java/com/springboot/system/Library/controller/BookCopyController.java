package com.springboot.system.Library.controller;
import com.springboot.system.Library.entities.BookCopy;
import com.springboot.system.Library.services.interfaces.BookCopyInterfaceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/create")
    public BookCopy createBookCopy(@RequestBody BookCopy bookCopy){
        return this.bookCopyInterfaceService.createBookCopy(bookCopy);
    }

}
