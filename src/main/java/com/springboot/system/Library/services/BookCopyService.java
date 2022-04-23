package com.springboot.system.Library.services;

import com.springboot.system.Library.entities.BookCopy;
import com.springboot.system.Library.repository.BookCopyRepository;
import com.springboot.system.Library.services.interfaces.BookCopyInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookCopyService implements BookCopyInterfaceService {

    @Autowired
    private final BookCopyRepository bookCopyRepository;

    public BookCopyService(BookCopyRepository bookCopyRepository){
        this.bookCopyRepository = bookCopyRepository;
    }

    @Override
    public List<BookCopy> getAllBookCopies() {
        return this.bookCopyRepository.findAll();
    }

    @Override
    public BookCopy createBookCopy(BookCopy bookCopy) {
        return this.bookCopyRepository.save(bookCopy);
    }
}
