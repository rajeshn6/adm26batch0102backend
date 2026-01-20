package com.cts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GreetController {
	
	@RequestMapping("/welcome")
	@ResponseBody
	public String greet() {
		return "welcome";
	}
	
}
