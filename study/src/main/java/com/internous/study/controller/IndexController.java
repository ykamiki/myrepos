package com.internous.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/study")
public class IndexController {
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/login")
	public String login(
			@RequestParam("userName") String userName,
			@RequestParam("password") String password,
			Model m) {
		
		String message = "Welcome! ";
		
		if (userName.equals("taro") && password.equals("123")) {
			message += "Taro";
		} else {
			message += "Guest";
		}
		
		m.addAttribute("message", message);
		return "welcome";
	}

}
