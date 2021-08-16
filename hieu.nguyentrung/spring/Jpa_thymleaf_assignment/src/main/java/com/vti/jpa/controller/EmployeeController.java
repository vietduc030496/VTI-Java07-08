package com.vti.jpa.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vti.jpa.dto.EmployeeDTO;
import com.vti.jpa.service.EmployeeService;
import org.springframework.ui.ModelMap;
@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/new")
	public String addEmployee(ModelMap model) {
		model.addAttribute("employee", new EmployeeDTO());
		return "employee/addEmployee";
	}
	@PostMapping()
	public String saveEmployee(ModelMap model,EmployeeDTO employeeDTO) {
		employeeService.addEmp(employeeDTO);
		List<EmployeeDTO> listEmployeeDTO = employeeService.getEmployee();
		model.addAttribute("listemployee", listEmployeeDTO);
		return "employee/listEmployee";
	}
	@GetMapping()
	public String getAll(ModelMap model) {
		List<EmployeeDTO> listEmployeeDTO = employeeService.getEmployee();
		model.addAttribute("listemployee", listEmployeeDTO);
		return "employee/listEmployee";
	}
	
	@GetMapping("/{employeeID}")
	public String getById(ModelMap model, @PathVariable("employeeID") Long employeeID) {
		EmployeeDTO employeeDTO =  employeeService.getEmployeeByID(employeeID);
		model.addAttribute("employee", employeeDTO);
		return "employee/getEmployee";
	}
	
	@PostMapping("/update/{employeeID}")
	public String updateEmployee(ModelMap model,EmployeeDTO employeeDTO,@PathVariable("employeeID") Long employeeID ) {
		employeeDTO.setEmployeeID(employeeID);
		employeeService.addEmp(employeeDTO);
		
		List<EmployeeDTO> listEmployeeDTO = employeeService.getEmployee();
		model.addAttribute("listemployee", listEmployeeDTO);
		return "employee/listEmployee";
	}
	@GetMapping("/delete/{employeeID}")
	public String deleteById(ModelMap model,@PathVariable("employeeID") Long employeeID ) {
		employeeService.deleteEmpByID(employeeID);
		List<EmployeeDTO> listEmployeeDTO = employeeService.getEmployee();
		model.addAttribute("listemployee", listEmployeeDTO);
		return "employee/listEmployee";
	}
}