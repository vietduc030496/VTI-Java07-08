package com.vti.stringboottest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vti.stringboottest.dto.RoleDTO;
import com.vti.stringboottest.service.RoleService;

@Controller
@RequestMapping("/api/role")
public class RoleController {
	@Autowired
	RoleService roleService;
	
	@PostMapping("/add")
	public String createRole(RoleDTO roleDto) {
		roleService.save(roleDto);
		return "ok";
	};
}
