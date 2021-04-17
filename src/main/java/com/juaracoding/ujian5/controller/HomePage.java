package com.juaracoding.ujian5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePage {

	@GetMapping("/")
	public String viewHomePage(Model model) {
		

		return "view_laporan";
		
	}
	
	
	@GetMapping("/login")
	public String loginPage(Model model) {
		

		return "login";
		
	}
}
