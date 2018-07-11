package com.lingfeng.dao;

import com.lanlan.base.BaseDao;
import com.lingfeng.model.User;

public interface UserDao extends BaseDao<User> {


	 public User login(User u);

	 public int changePassword(User u);

	 public boolean checkPassword(User u);
	

}
