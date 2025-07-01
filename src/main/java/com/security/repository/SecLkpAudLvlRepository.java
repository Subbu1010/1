package com.security.repository;

import com.security.entity.SecLkpAudLvl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SecLkpAudLvlRepository extends JpaRepository<SecLkpAudLvl, String> {
    
    @Query("SELECT a FROM SecLkpAudLvl a WHERE a.deprecatedDt IS NULL OR a.deprecatedDt = ''")
    List<SecLkpAudLvl> findActiveAuditLevels();
} 