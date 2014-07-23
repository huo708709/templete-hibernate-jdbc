package com.templete.core.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.templete.entity.security.Role;
import com.templete.entity.security.User;
import com.templete.entity.security.UserRole;
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
		Collection<GrantedAuthority> grantedAuths = obtionGrantedAuthorities(user);
		org.springframework.security.core.userdetails.User userdetail =
			new org.springframework.security.core.userdetails.User(
				user.getUsername(),
				user.getPassword(),
				true,
				true,
				true,
				true,
				grantedAuths);
		return userdetail;
	}

	private Set<GrantedAuthority> obtionGrantedAuthorities(User user) {
		Set<GrantedAuthority> authSet = new HashSet<GrantedAuthority>();
		//获取用户所属组
		Set<UserRole> userRoles = new HashSet<UserRole>(user.getUserRoles());
		for (UserRole userRole : userRoles ) {
			Role role = userRole.getRole();
			//获取用户组对应角色集合
			authSet.add(new SimpleGrantedAuthority(role.getName()));
		}
		return authSet;
	}
}
