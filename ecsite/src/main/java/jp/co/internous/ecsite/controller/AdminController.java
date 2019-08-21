package jp.co.internous.ecsite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ecsite/admin")
public class AdminController {
	
	@RequestMapping("/")
	public String index() {
		return "adminindex";
	}

}
