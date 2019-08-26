package jp.co.internous.myshop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import jp.co.internous.myshop.model.domain.Goods;
import jp.co.internous.myshop.model.domain.Purchase;
import jp.co.internous.myshop.model.domain.User;
import jp.co.internous.myshop.model.domain.dto.HistoryDto;
import jp.co.internous.myshop.model.form.HistoryForm;
import jp.co.internous.myshop.model.form.PurchaseForm;
import jp.co.internous.myshop.model.mapper.GoodsMapper;
import jp.co.internous.myshop.model.mapper.PurchaseMapper;
import jp.co.internous.myshop.model.mapper.UserMapper;

@Controller
@RequestMapping("/myshop")
public class IndexController {
	
	@Autowired
	UserMapper userMapper;
	
	@Autowired
	GoodsMapper goodsMapper;
	
	@Autowired
	PurchaseMapper purchaseMapper;
	
	Gson gson = new Gson();
	
	@RequestMapping("/")
	public String index(Model m) {
		String userName = "taro";
		String password = "taropw";
		List<User> users = userMapper.findByUserNameAndPassword(userName, password);
		
		User user = new User();
		if (users != null && users.size() > 0) {
			user = users.get(0);
			System.out.println(user.getFullName());
		}
		m.addAttribute("user", user);
		
		List<Goods> goodsList = goodsMapper.findAll();
		if (goodsList != null && goodsList.size() > 0) {
			m.addAttribute("goodsList", goodsList);
		}
		
		return "index";
	}
	
	@ResponseBody
	@PostMapping("/api/purchase")
	public String purchaseApi(@RequestBody PurchaseForm f) {
		
		Purchase entity = new Purchase();
		entity.setUserId(f.getUserId());
		entity.setGoodsId(f.getGoodsId());
		entity.setItemCount(f.getItemCount());
		entity.setTotal(f.getTotal());
		purchaseMapper.insert(entity);
		
		return "1";
	}
	
	@ResponseBody
	@PostMapping("/api/history")
	public String historyApi(@RequestBody HistoryForm form) {
		String userId = form.getUserId();
		List<HistoryDto> history = purchaseMapper.findHistory(userId);
		
//		List<HistoryDto> history = new ArrayList<>();
//		List<Goods> goodsList = purchaseMapper.findHistory2(userId);
//		goodsList.forEach( goods -> {
//			HistoryDto dto = new HistoryDto(goods);
//			history.add(dto);
//		});

		return gson.toJson(history);
	}

}
