package com.vti.jpa.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vti.jpa.dto.EmployeeDTO;
import com.vti.jpa.entity.Employee;
import com.vti.jpa.service.EmployeeService;
import org.springframework.ui.ModelMap;
@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	
	@RequestMapping("/employee-save")
	public String insertEmployee(Model model) {
		model.addAttribute("employee", new Employee());
		return "employee-save";
	}
	
	
	@RequestMapping(value = {"/","/employee-list"})
	public String listEmployee(Model model) {
		model.addAttribute("listEmployee", employeeService.getEmployee());
		return "employee-list";
	}
	
	
	@RequestMapping(value = {"/employee-view/{employeeID}"})
	public String viewEmployee(@PathVariable Long employeeID, Model model) {
		model.addAttribute("employee", employeeService.getEmployeeByID(employeeID));
		return "employee-view";
	}
	
	
	
	 @RequestMapping("/employee-update/{id}")
	  public String updateEmployee(@PathVariable Long employeeID,@PathVariable EmployeeDTO employeeDTO, Model model) {
	      model.addAttribute("employee", employeeService.updateEmp(employeeID, employeeDTO));
	    return "employee-update";
	  }
	 
	 @RequestMapping("/employeeDelete/{employeeID}")
	 public String doDeleteEmployee(@PathVariable Long employeeID, Model model) {
		 model.addAttribute("listEmployee", employeeService.deleteEmpByID(employeeID));
		 return "employee-list";
	 }
	 
	 
	 @RequestMapping("/saveEmployee")
	  public String doSaveEmployee(ModelMap model,EmployeeDTO employeeDTO) {
		employeeService.addEmp(employeeDTO);
		List<EmployeeDTO> listEmployeeDto = employeeService.getEmployee();
		model.addAttribute("listemployee", listEmployeeDto);
	    return "employee-list";
	  }
	 
	 
	 @RequestMapping("/updateEmployee")
	  public String doUpdateEmployee(ModelMap model,EmployeeDTO employeeDTO) {
		 employeeService.addEmp(employeeDTO);
		 List<EmployeeDTO> listEmployeeDto = employeeService.getEmployee();
		 model.addAttribute("listemployee", listEmployeeDto);
	    return "employee-list";
	  }
	 
	 
}
