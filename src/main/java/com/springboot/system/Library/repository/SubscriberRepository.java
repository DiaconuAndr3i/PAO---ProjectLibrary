package com.springboot.system.Library.repository;

import com.springboot.system.Library.entities.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriberRepository extends JpaRepository<Subscriber, Long> {
}
