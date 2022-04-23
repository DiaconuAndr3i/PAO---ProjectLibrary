package com.springboot.system.Library.services.interfaces;

import com.springboot.system.Library.entities.BookCopy;

import java.util.List;

public interface BookCopyInterfaceService {
    List<BookCopy> getAllBookCopies();

    BookCopy createBookCopy(BookCopy bookCopy);
}
