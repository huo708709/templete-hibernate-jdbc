package com.templete.test.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.templete.entity.security.User;
import com.templete.service.IUserService;
import com.templete.test.AbstractTest;

public class UserServiceTest extends AbstractTest {
	
	@Autowired
	private IUserService userService;

	@Test
	public void addUserTest() throws Exception {
		User user = new User();
		user.setUsername("admin");
		user.setPassword("1");
		userService.save(user);
	}
}
