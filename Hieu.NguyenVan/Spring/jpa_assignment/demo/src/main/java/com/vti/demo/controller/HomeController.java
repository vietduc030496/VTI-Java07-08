/**
 * 
 */
package com.vti.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author van hieu
 *
 */
@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String home() {
		return "index";
		
	}
}
