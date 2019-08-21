package com.internous.myecsite.controller;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.internous.myecsite.model.dao.TestRepository;
import com.internous.myecsite.model.entity.Test;

@Controller
@RequestMapping("/myecsite")
public class TestController {
	
	@Autowired
	private TestRepository testRepos;
	
	@RequestMapping("/test")
	@ResponseBody
	public String testQuery() {
		Timestamp d1;
		java.sql.Date d2;
		
		java.util.Date d = new java.util.Date();		
		d2 = new java.sql.Date(d.getTime());
		d1 = new Timestamp(d2.getTime());
		
		Test t = new Test();
		//t.setD1(d1);
		t.setD2(d2);
		t.setD3(d);
		
		testRepos.saveAndFlush(t);
		
		return null;
	}

}
