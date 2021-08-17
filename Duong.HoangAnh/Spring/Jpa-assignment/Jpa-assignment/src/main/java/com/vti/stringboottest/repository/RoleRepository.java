package com.vti.stringboottest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vti.stringboottest.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
