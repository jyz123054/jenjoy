package com.test.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/temp")
public class TemplateController {
	
	@RequestMapping("/testThymeleaf")
    public String testThymeleaf(ModelMap map) {
        // 设置属性，可传入到页面
        map.addAttribute("name", "jyz jyz");
        
        // testThymeleaf：为模板文件的名称
        // 对应src/main/resources/templates/testThymeleaf.html
        return "testThymeleaf";
    }
}
