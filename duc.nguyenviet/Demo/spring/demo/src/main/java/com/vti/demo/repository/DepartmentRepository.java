package com.vti.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vti.demo.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
