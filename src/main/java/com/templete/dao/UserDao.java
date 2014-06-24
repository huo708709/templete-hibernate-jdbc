package com.templete.dao;

import org.springframework.stereotype.Repository;

import com.templete.dao.AbstractDao;
import com.templete.entity.security.User;

@Repository("userDao")
public class UserDao extends AbstractDao<User, String> {

}
