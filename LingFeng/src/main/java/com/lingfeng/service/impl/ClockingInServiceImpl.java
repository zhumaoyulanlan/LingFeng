package com.lingfeng.service.impl;

import com.lanlan.base.BaseDao;
import com.lanlan.base.BaseServiceImpl;
import com.lingfeng.dao.ClockingInDao;
import com.lingfeng.model.ClockingIn;
import com.lingfeng.service.ClockingInService;

public class ClockingInServiceImpl extends BaseServiceImpl<ClockingIn> implements ClockingInService{

	private ClockingInDao clockingInDao;
	
	public ClockingInServiceImpl() {
		super();
	}
	
	public ClockingInServiceImpl(BaseDao<ClockingIn> dao) {
		super(dao);
	}

	public ClockingInDao getClockingInDao() {
		return clockingInDao;
	}

	public void setClockingInService(ClockingInDao clockingInDao) {
		super.setDao(clockingInDao);
		this.clockingInDao = clockingInDao;
	}
	
	

}
