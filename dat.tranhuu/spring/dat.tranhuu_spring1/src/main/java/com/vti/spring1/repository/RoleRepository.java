package com.vti.spring1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vti.spring1.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
	
	@Query("select s from Role s where s.id = ?1")
	Role getById(Long id);
}
