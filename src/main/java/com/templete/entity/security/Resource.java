package com.templete.entity.security;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.templete.entity.AbstractUUIDEntity;

@Entity
@Table(name = "t_resource")
public class Resource extends AbstractUUIDEntity {

	private static final long serialVersionUID = 1L;
	
	@Column(length = 50, nullable = false)
	private String rolename;
	
	@Column(length = 50)
	private String intercepturl;

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getIntercepturl() {
		return intercepturl;
	}

	public void setIntercepturl(String intercepturl) {
		this.intercepturl = intercepturl;
	}
	
}
