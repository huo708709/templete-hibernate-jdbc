package com.templete.service;

import com.templete.entity.security.User;
import com.templete.exception.SystemRunException;

public interface IUserService extends IBasicService {
	
	public User loadUserByUsername(String username) throws SystemRunException;

	public User save(User entity) throws SystemRunException;
}
