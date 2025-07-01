package com.security.repository;

import com.security.entity.SecLkpRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SecLkpRoleRepository extends JpaRepository<SecLkpRole, String> {
    
    @Query("SELECT r FROM SecLkpRole r WHERE r.deprecatedDt IS NULL OR r.deprecatedDt = ''")
    List<SecLkpRole> findActiveRoles();
} 