package com.test.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * @RestController注解，相当于@Controller+@ResponseBody两个注解的结合，
 * 返回json数据不需要在方法前面加@ResponseBody注解了，
 * 但使用@RestController这个注解，就不能返回jsp,html页面，视图解析器无法解析jsp,html页面
 */
@Controller
@RequestMapping("/jsp")
public class JspPageController {
	
	@RequestMapping("/jspHome")
	public String home() {
		//跳转到index.jsp
		return "index";
	}
	
	@RequestMapping("/testThymeleaf")
    public String testThymeleaf(ModelMap map) {
        // 设置属性，可传入到页面
        map.addAttribute("name", "jyz jyz");
        
        // testThymeleaf：为模板文件的名称
        // 对应src/main/resources/templates/testThymeleaf.html
        return "testThymeleaf";
    }
}
