package com.example.assignmentthymcrud.controller;

import com.example.assignmentthymcrud.entity.Employee;
import com.example.assignmentthymcrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;
import java.util.Optional;


@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/")
    public String index(Model model) {
        List<Employee> employees = employeeService.getAllEmployee();

        model.addAttribute("employees", employees);

        return "index";
    }

    @RequestMapping(value = "add")
    public String addEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        return "addEmployee";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editEmployee(@RequestParam("id") Integer Id, Model model) {
        Optional<Employee> employeeOptional = employeeService.findEmployeeById(Id);
        employeeOptional.ifPresent(employee -> model.addAttribute("employee", employee));
        return "editEmployee";
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(Employee employee) {
        System.out.println(employee);
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteEmployee(@RequestParam("id") Integer Id, Model model) {
        employeeService.deleteEmployee(Id);
        return "redirect:/";
    }
}