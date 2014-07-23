package com.templete.core.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.templete.entity.security.User;
import com.templete.service.IUserService;

public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private IUserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		User user = null;
		try {
			user = this.userService.loadUserByUsername(username);
		} catch (Exception e) {
			throw new UsernameNotFoundException(username);
		}
		if (null == user) {
			throw new UsernameNotFoundException(username);
		}
		return null;
	}

}
