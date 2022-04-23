package com.springboot.system.Library.repository;

import com.springboot.system.Library.entities.Loans;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoansRepository extends JpaRepository<Loans, Long> {
}
