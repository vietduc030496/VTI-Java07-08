package com.vti.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vti.springsecurity.entity.Department; 

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
