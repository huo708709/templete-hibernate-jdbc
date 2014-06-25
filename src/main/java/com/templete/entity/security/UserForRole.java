package com.templete.entity.security;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.templete.entity.AbstractUUIDEntity;

@Entity
@Table(name = "t_user_role")
public class UserForRole extends AbstractUUIDEntity {

	private static final long serialVersionUID = 1L;

	@Column(length = 32, nullable = false)
	private String userid;
	
	@Column(length = 32, nullable = false)
	private String roleid;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getRoleid() {
		return roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}
	
}
