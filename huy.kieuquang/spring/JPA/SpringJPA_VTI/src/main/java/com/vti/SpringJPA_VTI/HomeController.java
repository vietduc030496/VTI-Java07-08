package com.vti.SpringJPA_VTI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.vti.SpringJPA_VTI.entity.Employee;
import com.vti.SpringJPA_VTI.service.EmployeeService;



@Controller
public class HomeController {
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/")
	public String getAll(Model model) {
		List<Employee> listEm = employeeService.getAll();
		model.addAttribute("listEm", listEm);
		return "home2";
	}
	
	@GetMapping("/employee/{id}")
	public String edit(@PathVariable int id, Model model) {
		Employee employee = employeeService.getByID(id);
		model.addAttribute("employeeForm", employee);
		return "employeeForm";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(Model model, @PathVariable int id) {
		employeeService.delete(id);;
		return "redirect:/";
	}
	
	@GetMapping("/newEmployee")
	public String add(Model model) {
		model.addAttribute("employeeForm", new Employee());
		return "employeeForm";
	}
	
	@PostMapping("/save")
	public String addNVL(Employee employee) {
		employeeService.update(employee);
		return "redirect:/";
	}
}
