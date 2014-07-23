package com.templete.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.templete.entity.security.Menu;
import com.templete.exception.SystemRunException;
import com.templete.service.IMenuService;

@Controller
@RequestMapping("/menu")
public class MenuController extends BasicController {

	@Autowired
	IMenuService menuService;
	
	@ResponseBody
	@RequestMapping("/listPermissionMenu")
	public List<Menu> listPermissionMenu(Menu menu) {
		List<Menu> list = null;
		try {
			list = menuService.listPermissionMenu(menu);
		} catch (SystemRunException e) {
			e.printStackTrace();
		}
		return list;
	}
}
