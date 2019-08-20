package com.internous.myecsite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.internous.myecsite.model.dao.GoodsRepository;
import com.internous.myecsite.model.dao.UserRepository;
import com.internous.myecsite.model.dto.LoginDto;
import com.internous.myecsite.model.entity.Goods;
import com.internous.myecsite.model.entity.User;
import com.internous.myecsite.model.form.GoodsForm;
import com.internous.myecsite.model.form.LoginForm;

@Controller
@RequestMapping("/myecsite/admin")
public class AdminController {
	
	@Autowired
	private GoodsRepository goodsRepos;
	
	@Autowired
	private UserRepository userRepos;
	
	private Gson gson = new Gson();
	
	@RequestMapping("/")
	public String index() {
		return "adminindex";
	}
	
	@PostMapping("/welcome")
	public String welcome(LoginForm form, Model m) {
		List<User> users = userRepos.findByUserNameAndPassword(form.getUserName(), form.getPassword());
		
		if (users != null && users.size() > 0) {
			boolean isAdmin = users.get(0).getIsAdmin() != 0;
			if (isAdmin) {
				List<Goods> goods = goodsRepos.findAll();
				m.addAttribute("userId", users.get(0).getId());
				m.addAttribute("goods", goods);
			}
		}
		
		return "welcome";
	}
	
	@RequestMapping("/goodsMst")
	public String goodsMst(Model m) {
		List<Goods> goods = goodsRepos.findAll();
		m.addAttribute("goods", goods);
		
		return "goodsmst";
	}
	
	@ResponseBody
	@PostMapping("/api/deleteGoods")
	public String loginApi(@RequestBody GoodsForm f, Model m) {
		try {
			goodsRepos.deleteById(f.getId());
		} catch (IllegalArgumentException e) {
			return "-1";
		}
		
		return "1";
	}
	
}
