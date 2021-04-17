package com.juaracoding.ujian5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.juaracoding.ujian5.entity.User;
import com.juaracoding.ujian5.service.ModelUser;

@Controller
public class UserPage {

	@Autowired
	ModelUser modelUser;
	
	@GetMapping("/user/view")
	public String viewUserPage(Model model) {
		model.addAttribute("listuser",modelUser.getAllUser());
		return "view_user";
	}
	@GetMapping("/user/add")
	public String viewaddUserPage(Model model) { 
		model.addAttribute("user",new User());
		return "add_user";
	}
	@PostMapping("/user/view")
	public String addUserPage(@ModelAttribute User user, Model model) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String plainPassword = user.getPassword();
		String encodedPassword = passwordEncoder.encode(plainPassword);
        user.setPassword(encodedPassword);	
		this.modelUser.addUser(user);
		model.addAttribute("listuser",modelUser.getAllUser());
		return "redirect:/user/view";
	}
	@GetMapping("/user/update/{id}")
	public String updateUser(@PathVariable String id, Model model) {
		
		User user = modelUser.getUserByIdUser(id);
		model.addAttribute("user",user);
		return "add_user";
	}
	@GetMapping("/user/delete/{id}")
	public String deleteUser(@PathVariable String id, Model model) {
		this.modelUser.deleteUserById(id);
		model.addAttribute("listuser",modelUser.getAllUser());
		return "redirect:/user/view";
	}
}
