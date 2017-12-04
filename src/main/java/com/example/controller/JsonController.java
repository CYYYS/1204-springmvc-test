package com.example.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.pojo.User;

@Controller
public class JsonController {
	@ResponseBody
	@RequestMapping("toJson1")
	public User toJson1(User user) {
		return user;
	}
	
	@ResponseBody
	@RequestMapping("toJson2")
	public Map toJson2(@RequestParam Map<String,String> map) {
		return map;
	}
}
