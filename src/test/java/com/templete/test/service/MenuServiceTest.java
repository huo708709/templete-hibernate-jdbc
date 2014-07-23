package com.templete.test.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.templete.entity.security.Menu;
import com.templete.service.IMenuService;
import com.templete.test.AbstractTest;

public class MenuServiceTest extends AbstractTest {
	
	@Autowired
	private IMenuService menuService;

	@Test
	public void addMenuTest() throws Exception {
		Menu menu = new Menu();
		menu.setText("系统管理");
		String id = (String) menuService.save(menu);
		
		Menu m1 = new Menu();
		m1.setText("用户管理");
		m1.setPid(id);
		menuService.save(m1);
		Menu m2 = new Menu();
		m2.setText("角色管理");
		m2.setPid(id);
		menuService.save(m2);
	}
}
