package com.bookedrepo.repodemo8.repositories;

import com.bookedrepo.repodemo8.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {
}
