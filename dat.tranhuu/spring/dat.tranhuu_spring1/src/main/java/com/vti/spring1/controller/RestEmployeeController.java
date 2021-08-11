package com.vti.spring1.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.spring1.dto.EmployeeDto;
import com.vti.spring1.dto.ResponseDto;
import com.vti.spring1.service.EmployeeService;

@RestController
@RequestMapping(value = "/api/employee")
public class RestEmployeeController {

	@Autowired
	private EmployeeService service;

	@PostMapping
	public ResponseEntity<EmployeeDto> saveOrUpdate(@RequestBody @Valid EmployeeDto dto) {
		dto = service.saveOrUpdate(dto);
		return new ResponseEntity<EmployeeDto>(dto, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<EmployeeDto>> findAll() {
		List<EmployeeDto> ret = service.findAll();
		return new ResponseEntity<List<EmployeeDto>>(ret, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ResponseDto<EmployeeDto>> findById(@PathVariable("id") Long id) {
		ResponseDto<EmployeeDto> ret = service.findById(id);
		return new ResponseEntity<ResponseDto<EmployeeDto>>(ret, HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ResponseDto<EmployeeDto>> delete(@PathVariable("id") Long id) {
		ResponseDto<EmployeeDto> ret = service.delete(id);
		return new ResponseEntity<ResponseDto<EmployeeDto>>(ret, HttpStatus.OK);
	}
}
