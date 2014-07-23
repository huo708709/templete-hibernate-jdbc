package com.templete.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.templete.entity.security.User;
import com.templete.exception.SystemRunException;
import com.templete.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController extends BasicController {

	@Autowired
	IUserService userService;
	
	@ResponseBody
	@RequestMapping("/listUser")
	public List<User> listUser(User user) {
		List<User> list = null;
		try {
			list = userService.listUser(user);
		} catch (SystemRunException e) {
			e.printStackTrace();
		}
		return list;
	}
}
