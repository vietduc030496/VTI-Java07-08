package com.vti.SpringJPA_VTI.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vti.SpringJPA_VTI.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer>{

}
