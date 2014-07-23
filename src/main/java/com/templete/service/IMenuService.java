package com.templete.service;

import java.util.List;

import com.templete.entity.security.Menu;
import com.templete.exception.SystemRunException;

public interface IMenuService extends IBasicService<Menu, String> {
	
	public List<Menu> listPermissionMenu(Menu menu) throws SystemRunException;
}
