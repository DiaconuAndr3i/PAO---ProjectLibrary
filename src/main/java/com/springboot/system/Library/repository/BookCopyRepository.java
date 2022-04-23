package com.springboot.system.Library.repository;

import com.springboot.system.Library.entities.BookCopy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookCopyRepository extends JpaRepository<BookCopy, Long> {
}
