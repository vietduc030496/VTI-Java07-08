package com.vti.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.jpa.entity.Employee;
import com.vti.jpa.service.EmployeeService;

@RestController
@RequestMapping(value= "/api/employee")
public class StudentController {
	
	
	@Autowired
	private EmployeeService employeeService;
	
	
	@PostMapping
	public String addEmployee(@RequestBody Employee employee) {
		employeeService.addEmp(employee);
		return "success";
	};
	
	
	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmp() {
		List<Employee> empList = employeeService.getEmployee();
		
		if (empList.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        
        return new ResponseEntity<>(empList, HttpStatus.OK);

	}
	
	
	@GetMapping("/{employeeID}")
	public ResponseEntity<Employee> getEmByID(@PathVariable("employeeID") Integer employeeID){
		Employee employee = employeeService.getEmployeeByID(employeeID);
		
		if (employee == null)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        
        return new ResponseEntity<>(employee, HttpStatus.OK);
	}
	
	
	@PutMapping("/{employeeID}")
	public String updateEmployee(@PathVariable("employeeID") Integer employeeID, @RequestBody Employee employee) {
		employeeService.updateEmp(employeeID, employee);
		return "update success";
	}
	
	
	@DeleteMapping
	public String deleteAllEmployee() {
		employeeService.deleteAllEmp();
		return "delete success";
	}
	
	
	@DeleteMapping("/{employeeID}")
	public String deleteEmployeeByID(@PathVariable("employeeID") Integer employeeID) {
		employeeService.deleteEmpByID(employeeID);
		return "delete success";
	}
}
