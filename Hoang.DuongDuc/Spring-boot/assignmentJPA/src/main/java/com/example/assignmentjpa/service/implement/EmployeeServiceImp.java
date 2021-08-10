package com.example.assignmentjpa.service.implement;


import com.example.assignmentjpa.entity.Employee;
import com.example.assignmentjpa.repository.EmployeeRepository;
import com.example.assignmentjpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getListEmployee() {
        return (List<Employee>) employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    //    @Override hàm không tối ưu
//    public void update(int id, Employee employee) throws Exception {
//        Employee employee1 = employeeRepository.findById(id).orElse(null);
//        if(employee1 == null) throw new Exception("ID khong ton tai!");
//        employee.setId(id);
//        employeeRepository.save(employee);
//    }
    @Override
    public String update(int id, Employee employee) {
        Employee employee1 = employeeRepository.findById(id).orElse(null);
        if (employee1 == null) return "Khong ton tai ID";
        employee.setId(id);
        employeeRepository.save(employee);
        return "Update Success";
    }

    @Override
    public String delete(int id) {
        Employee employee1 = employeeRepository.findById(id).orElse(null);
        if (employee1 == null) return "Khong ton tai ID";
        employeeRepository.delete(employee1);
        return "Delete Success";
    }
}
