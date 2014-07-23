package com.templete.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.templete.entity.security.User;
import com.templete.exception.SystemRunException;

@Repository("userDao")
public class UserDao extends BasicDao<User, String> {

	public List<User> listUser() throws SystemRunException {
		return null;
	}
}
