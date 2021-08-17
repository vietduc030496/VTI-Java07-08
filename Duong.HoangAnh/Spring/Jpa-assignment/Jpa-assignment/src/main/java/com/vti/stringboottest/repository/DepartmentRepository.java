package com.vti.stringboottest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vti.stringboottest.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
