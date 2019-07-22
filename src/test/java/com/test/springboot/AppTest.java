package com.test.springboot;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.test.springboot.dao.UserMapper;
import com.test.springboot.model.TestUser;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
@SpringBootTest(classes = App.class)
@RunWith(SpringRunner.class)
public class AppTest extends TestCase {
	
	@Resource
    private UserMapper userMapper;

    @Test
    public void testApp()
    {
    	TestUser u = userMapper.findByUsernameAndPasswd("JYZ919", "123531");
    	System.out.println("OK."+u.getId());
    }
}
