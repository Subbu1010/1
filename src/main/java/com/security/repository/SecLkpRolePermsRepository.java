package com.security.repository;

import com.security.entity.SecLkpRolePerms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SecLkpRolePermsRepository extends JpaRepository<SecLkpRolePerms, Integer> {
    
    List<SecLkpRolePerms> findByRoleId(String roleId);
} 