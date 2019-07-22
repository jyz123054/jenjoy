package com.test.springboot.rs;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/*
 * 	这里不使用@Controller 因为这是要带返回值的，所以使用@RestController
 *	而@RestController 相当于@Controller + @ResponseBody
 *	或者使用@Controller 然后，对应需要返回json等数据的方法上增加@ResponseBody
 */
//@RestController	
@Controller
//@ResponseBody
@RequestMapping(value="/swagger")
public class SwaggerController {

    @ApiOperation(value="获取用户信息", notes="根据ID来获取用户详细信息")
    @ApiImplicitParam(name="id", value="用户ID", required=true, dataType="String")
    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    @ResponseBody
    public Map<String,String> getInfo(@PathVariable String id) {
        Map<String ,String> map = new HashMap<String, String>();
        map.put("name", "lison");
        map.put("age", "38");
        return map;
    }
}
