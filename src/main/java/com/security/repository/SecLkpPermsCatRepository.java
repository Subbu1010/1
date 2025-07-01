package com.security.repository;

import com.security.entity.SecLkpPermsCat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SecLkpPermsCatRepository extends JpaRepository<SecLkpPermsCat, Integer> {
    
    @Query("SELECT pc FROM SecLkpPermsCat pc WHERE pc.deprecatedDt IS NULL OR pc.deprecatedDt = ''")
    List<SecLkpPermsCat> findActivePermissionCategories();
    
    SecLkpPermsCat findByPermsCatNm(String permsCatNm);
} 