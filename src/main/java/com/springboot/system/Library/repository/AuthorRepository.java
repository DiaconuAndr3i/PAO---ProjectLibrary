package com.springboot.system.Library.repository;

import com.springboot.system.Library.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Modifying
    @Transactional
    @Query(value = "delete from books_authors where fk_author = :idAuthor", nativeQuery = true)
    void deleteFromBooksAuthors(Long idAuthor);
}
