package com.test.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {
	
	@RequestMapping("/404.do")
	public String base404() {
		return "404 页面无法找到。。。。。";
	}
}
