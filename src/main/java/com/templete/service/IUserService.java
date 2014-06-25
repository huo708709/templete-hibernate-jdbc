package com.templete.service;

import com.templete.entity.security.User;
import com.templete.exception.SystemRunException;

public interface IUserService extends IBasicService<User, String> {
	
	public User loadUserByUsername(String username) throws SystemRunException;

}
