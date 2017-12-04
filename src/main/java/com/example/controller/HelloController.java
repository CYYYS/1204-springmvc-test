package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	@RequestMapping("/index")
	@ResponseBody
	public String test() {
		return "controller接受参数";
	}
	@RequestMapping("/index2")
	public String test2(HttpServletRequest req ) {
		//mav.addObject("test", "controller接受参数");
		req.setAttribute("test", "controller接受参数");
		return "index";
	}
	
	@RequestMapping("/test")
	@ResponseBody
	public void test3(int age,String name){
		System.out.println(age);
		System.out.println(name);
	}
}
