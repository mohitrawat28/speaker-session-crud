package com.bookedrepo.repodemo8.repositories;

import com.bookedrepo.repodemo8.models.Session;
import com.bookedrepo.repodemo8.models.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerRepository extends JpaRepository<Speaker, Long> {
}
