package com.test.springboot.controller;

import java.util.Enumeration;
import java.util.Random;
import java.util.ResourceBundle;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.springboot.services.UserServiceInter;

@RestController
public class UserController {
	
	/**
	 * 	springboot默认集成的logback，日志记录对象
	 * 	(优先级从高到低分别是 ERROR、WARN、INFO、DEBUG。
	 * 	日志记录的级别有继承性，子类会记录父类的所有的日志级别。)
	 */
	private Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Resource
	private UserServiceInter userServiceInter;
	
	@RequestMapping("/index")
    public String git() {
//    	log.error("Hello Jyz. error log.......");
//    	log.warn("Hello Jyz. warn log.......");
//    	log.info("Hello Jyz. info log.......");
//    	log.debug("Hello Jyz. debug log.......");
//    	log.trace("Hello Jyz. trace log.......");
//    	readProperties();
        return "Hello git. v1.0.1    J0201mod  merge github SSH GitHub modify0723-1404";
    }
	
    @RequestMapping("/index")
    public String home() {
//    	log.error("Hello Jyz. error log.......");
//    	log.warn("Hello Jyz. warn log.......");
//    	log.info("Hello Jyz. info log.......");
//    	log.debug("Hello Jyz. debug log.......");
//    	log.trace("Hello Jyz. trace log.......");
//    	readProperties();
        return "Hello Jyz.233";
    }
    
    @RequestMapping("/insert")
    public String insert() {
    	Random ram = new Random();
    	boolean flag = userServiceInter.register("JYZ"+ram.nextInt(1000), "123");
        return "insert ok."+flag;
    }
    
    @RequestMapping("/input")
    public String insertByInput(String userName, String password) {
    	boolean flag = userServiceInter.register(userName, password);
        return userName+" insertByInput ok."+flag;
    }
    
    @RequestMapping("/login")
    public String login() {
    	boolean flag = userServiceInter.login("JYZ204", "123");
        return "login ok."+flag;
    }
    
    @RequestMapping("/batchAdd")
    public String batchAdd(String userName,String password) {
    	userServiceInter.batchAdd(userName, password);
        return userName+" batchAdd成功.";
    }
    
    /**
     * 	读取com.test.springboot下的jyz.properties文件内容
     */
    public void readProperties() {
    	ResourceBundle resource = ResourceBundle.getBundle("com/test/springboot/jyz");
    	String key = resource.getString("jyz.name"); 
    	System.out.println(key);
    	Enumeration<String> arr = resource.getKeys();
    	for (;arr.hasMoreElements();) {
    		String keyName = arr.nextElement();
    		System.out.println(keyName);
    		System.out.println(resource.getString(keyName));
    	}
    }
    
}
