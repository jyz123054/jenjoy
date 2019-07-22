package com.test.springboot.services;

public interface UserServiceInter {
	boolean login(String username,String passwd);
    boolean register(String username,String passwd);
    void batchAdd(String username,String passwd);
}
