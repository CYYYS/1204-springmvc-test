package com.example.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.pojo.Person;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class HomeworkJsonController {
	
	//注入ObjectMapper
	@Autowired
	public ObjectMapper om;
	
	//进入person.html
	@RequestMapping("person")
	public String person() {
		return "person";
	}
	
	//将接受的json字符串转化为对象类型
	@RequestMapping("Json2Entity")
	@ResponseBody
	public void Json2Entity(String json) throws JsonParseException, JsonMappingException, IOException {
		Person person = om.readValue(json, Person.class);
		System.out.println(person);
	}
	
	//将实体对象转化为json字符串返回到页面
	@RequestMapping("Entity2Json")
	@ResponseBody
	public Person Entity2Json() {
		Person p = new Person();
		p.setId(8);
		p.setAddress("山西");
		p.setDate("2017-01-01");
		p.setName("崔阳赛");
		return p;
	}
}
