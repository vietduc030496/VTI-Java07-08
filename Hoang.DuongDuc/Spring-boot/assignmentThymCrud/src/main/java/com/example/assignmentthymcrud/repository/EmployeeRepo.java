package com.example.assignmentthymcrud.repository;

import com.example.assignmentthymcrud.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepo extends CrudRepository<Employee, Integer> {

}