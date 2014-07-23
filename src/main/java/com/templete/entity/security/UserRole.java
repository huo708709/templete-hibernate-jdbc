package com.templete.entity.security;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.templete.entity.AbstractUUIDEntity;

@Entity
@Table(name = "t_user_role")
public class UserRole extends AbstractUUIDEntity {

	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="userid")
	private User user;
	
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="roleid")
	private Role role;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
