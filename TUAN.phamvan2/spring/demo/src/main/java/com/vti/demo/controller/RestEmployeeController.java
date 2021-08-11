package com.vti.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vti.demo.dto.EmployeeDto;
import com.vti.demo.service.EmployeeService;

@RestController
@RequestMapping("api/employee")
public class RestEmployeeController {

	@Autowired
	private EmployeeService empService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<EmployeeDto> save(@RequestBody EmployeeDto dto) {
		EmployeeDto result = empService.saveOrUpdate(dto, null);
		return new ResponseEntity<EmployeeDto>(result, (result != null) ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<EmployeeDto> update(@RequestBody EmployeeDto dto, @PathVariable("id") Long id) {
		EmployeeDto result = empService.saveOrUpdate(dto, null);
		return new ResponseEntity<EmployeeDto>(result, (result != null) ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET) 
	public ResponseEntity<List<EmployeeDto>> getAll() {
		List<EmployeeDto> result = empService.getAll();
		return new ResponseEntity<List<EmployeeDto>>(result, (result != null) ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET) 
	public ResponseEntity<EmployeeDto> getById(@PathVariable Long id) {
		EmployeeDto result = empService.getById(id);
		return new ResponseEntity<EmployeeDto>(result, (result != null) ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE) 
	public ResponseEntity<Boolean> deleteById(@PathVariable Long id) {
		Boolean result = empService.deleteById(id);
		return new ResponseEntity<Boolean>(result, HttpStatus.OK);
	}
}
