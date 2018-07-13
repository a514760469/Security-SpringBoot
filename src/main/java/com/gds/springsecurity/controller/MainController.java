package com.gds.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	/**
	 * 访问根路径时重定向到index
	 */
	@GetMapping("/")
	public String root() {
		return "redirect:/index";
	}
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	@GetMapping("/login")
	public String login () {
		return "login";
	}
		
	
	@GetMapping("/login-error")
	public String loginError (Model model) {
		model.addAttribute("errorMsg", "登录失败, 用户名或密码错误");
		model.addAttribute("loginError", true);
		return "login";
	}
	
	@GetMapping("/header")
	public String header() {
		return "fragments/header";
	}
	
}






