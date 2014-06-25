package com.templete.entity.security;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.templete.entity.AbstractUUIDEntity;

@Entity
@Table(name = "t_organization")
public class Organization extends AbstractUUIDEntity {

	private static final long serialVersionUID = 1L;

	@Column(length = 50, nullable = false)
	private String name;
	
	@Column(nullable = false, columnDefinition = "int default 0")
	private Integer level;
	
	@Column(length = 32)
	private String parentId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	
}
