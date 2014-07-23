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
	private String text;
	
	@Column(length = 50)
	private String iconCls;
	
	@Column(length = 50)
	private String url;
	
	@Column(length = 32)
	private String pid;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
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

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

}
