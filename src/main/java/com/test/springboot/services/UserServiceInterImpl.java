package com.test.springboot.services;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.springboot.dao.UserMapper;
import com.test.springboot.model.TestUser;

@Service
public class UserServiceInterImpl implements UserServiceInter{
	
	@Resource
	private UserMapper userMapper;
	
	@Override
	public boolean login(String username, String passwd) {
		TestUser user = userMapper.findByUsernameAndPasswd(username, passwd);
		return user != null;
	}

	@Override
	public boolean register(String username, String passwd) {
		TestUser users = new TestUser();
        users.setUserName(username);
        users.setPassword(passwd);
        int cnt = userMapper.insertSelective(users);
        return cnt > 0;
	}

	@Override
	@Transactional
	public void batchAdd(String username, String passwd) {
		TestUser users = new TestUser();
        users.setUserName(username);
        users.setPassword(passwd);
        userMapper.insertSelective(users);
        int i = 10 /0;
        users = new TestUser();
        users.setUserName(username+"2");
        users.setPassword(passwd);
        userMapper.insertSelective(users);
	}

}
