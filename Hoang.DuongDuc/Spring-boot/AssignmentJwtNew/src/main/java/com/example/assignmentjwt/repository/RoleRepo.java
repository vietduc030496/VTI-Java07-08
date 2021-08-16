package com.example.assignmentjwt.repository;

import com.example.assignmentjwt.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.management.relation.Role;

public interface RoleRepo extends JpaRepository<RoleEntity, Integer> {

        RoleEntity findByName(String name);
        }