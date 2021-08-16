package com.vti.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.vti.demo.entity.RoleEntity;

public interface RoleEntityRepository extends JpaRepository<RoleEntity, Integer> {

    RoleEntity findByName(String name);
}
