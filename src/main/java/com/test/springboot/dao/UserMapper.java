package com.test.springboot.dao;

import org.apache.ibatis.annotations.Param;

import com.test.springboot.model.TestUser;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TestUser record);

    int insertSelective(TestUser record);

    TestUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TestUser record);

    int updateByPrimaryKey(TestUser record);

    TestUser findByUsernameAndPasswd(@Param("userName") String userName, @Param("password") String password);
}
