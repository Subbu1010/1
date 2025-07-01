package com.security.repository;

import com.security.entity.SecLkpPerms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SecLkpPermsRepository extends JpaRepository<SecLkpPerms, Integer> {
    
    @Query("SELECT p FROM SecLkpPerms p WHERE p.deprecatedDt IS NULL OR p.deprecatedDt = ''")
    List<SecLkpPerms> findActivePermissions();
} 