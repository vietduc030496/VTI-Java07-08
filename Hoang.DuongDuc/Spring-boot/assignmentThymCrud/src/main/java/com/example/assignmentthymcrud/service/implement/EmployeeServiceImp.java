package com.example.assignmentthymcrud.service.implement;

import com.example.assignmentthymcrud.entity.Employee;
import com.example.assignmentthymcrud.repository.EmployeeRepo;
import com.example.assignmentthymcrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EmployeeServiceImp implements EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepository;


    @Override
    public List<Employee> getAllEmployee() {
        return (List<Employee>) employeeRepository.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Optional<Employee> findEmployeeById(Integer id) {
        return employeeRepository.findById(id);
    }
}
