package com.templete.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.templete.dao.UserDao;
import com.templete.entity.security.User;
import com.templete.exception.SystemRunException;
import com.templete.service.AbstractService;
import com.templete.service.IUserService;

@Service("userService")
public class UserService extends AbstractService<User, String> implements IUserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	public void setUserDao(UserDao userDao) {
		setAbstractDao(userDao);
	}
	
	@Override
	public User loadUserByUsername(String username) throws SystemRunException {
		List<User> list = userDao.find("from User a where a.username=?", username);
		if (!CollectionUtils.isEmpty(list)) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public List<User> listUser(User user) throws SystemRunException {
		return null;
	}
	
}
