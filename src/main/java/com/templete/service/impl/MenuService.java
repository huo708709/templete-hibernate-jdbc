package com.templete.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.templete.dao.MenuDao;
import com.templete.entity.security.Menu;
import com.templete.exception.SystemRunException;
import com.templete.service.AbstractService;
import com.templete.service.IMenuService;

@Service("menuService")
public class MenuService extends AbstractService<Menu, String> implements IMenuService {

	@Autowired
	private MenuDao menuDao;
	
	@Autowired
	public void setMenuDao(MenuDao menuDao) {
		setAbstractDao(menuDao);
	}
	
	@Override
	public List<Menu> listPermissionMenu(Menu menu) throws SystemRunException {
		return menuDao.listPermissionMenu(menu);
	}
}
