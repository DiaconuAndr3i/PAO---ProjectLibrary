package com.springboot.system.Library.repository;

import com.springboot.system.Library.entities.Audit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditRepository extends JpaRepository<Audit, Long> {
}
