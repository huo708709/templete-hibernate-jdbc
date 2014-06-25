package com.templete.entity.security;

import javax.persistence.Column;
import javax.persistence.Entity;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
