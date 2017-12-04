package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RedirectController {
	/**
	 * 重定向参数在controller之间传递方法
	 * */
	@RequestMapping("redirectTest")
	//redirectAttributes中的addAttribute方法适用于controller之间传递值
	public String redirectTest(Model model,RedirectAttributes redirectAttrs) {
		//使用model是在下面获取不到
		model.addAttribute("msg1","Model使用model设置属性");
		//使用RedirectAttribute可以获取到
		redirectAttrs.addAttribute("msg", "RedirectAttributes使用重定向保存");
		//使用AddFlashAttribute方法
		redirectAttrs.addFlashAttribute("flash", "RedirectAttributes使用flash");
		return "redirect:testRedirect";
	}
	//第15行返回的redirect 对应下面的方法,重定向到这个方法时,可以取到对应的属性
	@RequestMapping("testRedirect")
	public String testRedirect(String msg,String msg1,String flash) {
		System.out.println(msg);//RedirectAttributes使用重定向保存
		System.out.println(msg1);//null
		System.out.println(flash);//null
		return "index";
	}
}
