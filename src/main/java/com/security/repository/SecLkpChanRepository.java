package com.security.repository;

import com.security.entity.SecLkpChan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SecLkpChanRepository extends JpaRepository<SecLkpChan, String> {
    
    @Query("SELECT c FROM SecLkpChan c WHERE c.deprecatedDt IS NULL OR c.deprecatedDt = ''")
    List<SecLkpChan> findActiveChannels();
} 