package com.templete.entity.security;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.templete.entity.AbstractUUIDEntity;

@Entity
@Table(name = "t_menu")
public class Menu extends AbstractUUIDEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(length = 50, nullable = false)
	private String name;
	
	@Column(length = 50)
	private String iconCls;
	
	@Column(length = 50)
	private String url;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
