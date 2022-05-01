package com.springboot.system.Library.repository;

import com.springboot.system.Library.entities.BookCopy;
import com.springboot.system.Library.enums.BookFormat;
import com.springboot.system.Library.enums.BookStatus;
import com.springboot.system.Library.utilities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface BookCopyRepository extends JpaRepository<BookCopy, Long> {
    Optional<List<BookCopy>> findByBookStatus(BookStatus bookStatus);
    Optional<List<BookCopy>> findByBookFormat(BookFormat bookFormat);
    @Query(value = "select * from book b join books_authors ba on b.id = ba.fk_book join " +
            "author a on ba.fk_author = a.id where a.first_name = :firstName and a.last_name = :lastName", nativeQuery = true)
    Optional<List<BookCopy>> findBooksByAuthor(String firstName, String lastName);

    @Modifying
    @Transactional
    @Query(value = "delete from books_authors where fk_book = :idBook", nativeQuery = true)
    void deleteFromBooksAuthors(Long idBook);

}
