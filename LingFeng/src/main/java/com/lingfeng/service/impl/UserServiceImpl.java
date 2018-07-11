package com.lingfeng.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.lang.UsesSunHttpServer;
import org.springframework.stereotype.Service;

import com.lanlan.base.BaseDao;
import com.lanlan.base.BaseServiceImpl;
import com.lingfeng.dao.UserDao;
import com.lingfeng.model.User;
import com.lingfeng.service.UserService;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService{


	private UserDao userDao;
	
	public UserServiceImpl() {
		super();
	}
	

	public UserDao getUserDao() {
		return userDao;
	}

	@Autowired
	public void setUserService(UserDao userDao) {
		super.setDao(userDao);
		this.userDao = userDao;
	}

	@Override
	public User login(User u) {
		return userDao.login(u);
	}


	@Override
	public int changePassword(User u) {
		return userDao.changePassword(u);
	}


	@Override
	public boolean checkPassword(User u) {
		return userDao.checkPassword(u);
	}

}
