package com.lingfeng.service;

import com.lanlan.base.BaseService;
import com.lingfeng.model.User;

public interface UserService extends BaseService<User> {
		public User login(User u);
	
		public int changePassword(User u);
	
		public boolean checkPassword(User u);
}
