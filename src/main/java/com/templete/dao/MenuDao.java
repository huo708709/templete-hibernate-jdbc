package com.templete.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.templete.entity.security.Menu;
import com.templete.exception.SystemRunException;

@Repository("menuDao")
public class MenuDao extends BasicDao<Menu, String> {

	public List<Menu> listPermissionMenu(Menu menu) throws SystemRunException {
		StringBuilder sql = new StringBuilder("from Menu m where 1=1");
		List<Object> params = new ArrayList<Object>();
		if (StringUtils.isNotEmpty(menu.getPid())) {
			sql.append(" and m.pid=?");
			params.add(menu.getPid());
		} else {
			sql.append(" and m.pid is null");
		}
		return this.find(sql.toString(), params.toArray());
	}
}
