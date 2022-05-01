package com.springboot.system.Library.repository;

import com.springboot.system.Library.entities.BookCopy;
import com.springboot.system.Library.entities.Loans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LoansRepository extends JpaRepository<Loans, Long> {
    @Query(value = "select * from loans where return_date > expectation_date", nativeQuery = true)
    List<Loans> findLoansWhereReturnDateGreaterThanExpectationDate();
}
