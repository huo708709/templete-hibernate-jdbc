package com.templete.entity.security;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.templete.entity.AbstractUUIDEntity;

@Entity
@Table(name = "t_role")
public class Role extends AbstractUUIDEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(length = 32, nullable = false)
	private String name;
	
	@OneToMany(mappedBy="role", cascade=CascadeType.ALL)
    private List<UserRole> userRoles;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}
	
}
