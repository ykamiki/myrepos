package com.internous.myecsite.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.internous.myecsite.model.dao.ProductRepository;
import com.internous.myecsite.model.dao.PurchaseRepository;
import com.internous.myecsite.model.dao.UserRepository;
import com.internous.myecsite.model.dto.LoginDto;
import com.internous.myecsite.model.entity.Product;
import com.internous.myecsite.model.entity.Purchase;
import com.internous.myecsite.model.entity.User;
import com.internous.myecsite.model.form.CartForm;
import com.internous.myecsite.model.form.HistoryForm;
import com.internous.myecsite.model.form.LoginForm;

@Controller
@RequestMapping("/myecsite")
public class IndexController {
	
	@Autowired
	private ProductRepository productRepos;
	
	@Autowired
	private UserRepository userRepos;
	
	@Autowired
	private PurchaseRepository purchaseRepos;
	
	private Gson gson = new Gson();
	
	@RequestMapping("/")
	public String index(Model m) {
		
		User user = new User();
		user.setFullName("TestTaro");
		m.addAttribute("user", user);
		
		List<Product> products = productRepos.findAll();
		m.addAttribute("products", products);
		
		return "index";
	}
	
	@ResponseBody
	@PostMapping("/api/login")
	public String loginApi(@RequestBody LoginForm form) {
		List<User> users = userRepos.findByUserNameAndPassword(form.getUserName(), form.getPassword());
		
		LoginDto dto = new LoginDto(0, null, null, "ゲスト");
		if (users.size() > 0) {
			dto = new LoginDto(users.get(0));
		}
		return gson.toJson(dto);
	}
	
	@ResponseBody
	@PostMapping("/api/purchase")
	public String purchaseApi(@RequestBody CartForm form) {
		
		form.getCartList().forEach((cart) -> {
			Purchase p = new Purchase();
			p.setUserId(form.getUserId());
			p.setProductId(cart.getId());
			p.setProductName(cart.getProductName());
			p.setCount(cart.getCount());
			p.setTotal(cart.getPrice() * cart.getCount());
			
			String now = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
			p.setCreatedAt(now);
			
			purchaseRepos.saveAndFlush(p);
		});
		
		return String.valueOf(form.getCartList().size());
	}
	
	@ResponseBody
	@PostMapping("/api/history")
	public String historyApi(@RequestBody HistoryForm form) {
		String userId = form.getUserId();
		List<Purchase> history = purchaseRepos.findHistory(Long.parseLong(userId));

		return gson.toJson(history);
	}

}
