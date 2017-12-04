package com.example.controller;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.pojo.User;

@Controller
public class MapController {
	@RequestMapping("/map")
	//使用map接受参数时,不可以省略@requestParam
	public String testMap(@RequestParam Map<String,String> param) {
		System.out.println(param);
		Iterator<Entry<String, String>> iterator = param.entrySet().iterator();
		while(iterator.hasNext()) {
			Entry<String, String> entity = iterator.next();
			System.out.println(entity.getKey());
			System.out.println(entity.getValue());
		}
		return "index";
	}
	
	@RequestMapping(value="user",method=RequestMethod.POST)
	public String testUsers(@ModelAttribute("user") User user) {
		System.out.println(user);
		return "index";
	}
	//使用requestHeader接收参数
	@RequestMapping(value="testHeader")
	public String testHeader(@RequestHeader("name") String name,@RequestHeader("age") int age) {
		System.out.println(name);
		System.out.println(age);
		return "index";
	}
	
	//restful方式接受参数
	@RequestMapping(value="{name}/{age}")
	public String testRestful(@PathVariable("name") String name,@PathVariable("age") int age) {
		System.out.println(name);
		System.out.println(age);
		return "index";
	}
	
	//后台传递对象到前台
	@RequestMapping(value="testModel")
	public String testModel(Model model) {
		User user = new User();
		user.setAge(25);
		user.setName("崔阳超");
		model.addAttribute("user", user);
		return "index";
	}
}
