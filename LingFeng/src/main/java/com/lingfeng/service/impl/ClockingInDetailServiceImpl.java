package com.lingfeng.service.impl;

import com.lanlan.base.BaseDao;
import com.lanlan.base.BaseServiceImpl;
import com.lingfeng.dao.ClockingInDetailDao;
import com.lingfeng.model.ClockingInDetail;
import com.lingfeng.service.ClockingInDetailService;

public class ClockingInDetailServiceImpl extends BaseServiceImpl<ClockingInDetail> implements ClockingInDetailService{

	private ClockingInDetailDao clockingInDetailDao;
	
	public ClockingInDetailServiceImpl() {
		super();
	}
	
	public ClockingInDetailServiceImpl(BaseDao<ClockingInDetail> dao) {
		super(dao);
	}

	public ClockingInDetailDao getClockingInDetailDao() {
		return clockingInDetailDao;
	}

	public void setClockingInDetailService(ClockingInDetailDao clockingInDetailDao) {
		super.setDao(clockingInDetailDao);
		this.clockingInDetailDao = clockingInDetailDao;
	}
	
	

}
