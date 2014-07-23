package com.templete.entity.security;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.templete.entity.AbstractUUIDEntity;

@Entity
@Table(name = "t_user")
public class User extends AbstractUUIDEntity {

	private static final long serialVersionUID = 1L;

	@Column(unique = true, length = 32, nullable = false)
	private String username;
	
	@Column(length = 32, nullable = false)
	private String password;

	@OneToMany(mappedBy="user", cascade=CascadeType.ALL)
	private List<UserRole> userRoles;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}
	
}
