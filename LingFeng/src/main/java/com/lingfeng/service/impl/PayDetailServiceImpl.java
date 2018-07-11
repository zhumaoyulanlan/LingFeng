package com.lingfeng.service.impl;

import com.lanlan.base.BaseDao;
import com.lanlan.base.BaseServiceImpl;
import com.lingfeng.dao.PayDetailDao;
import com.lingfeng.model.PayDetail;
import com.lingfeng.service.PayDetailService;

public class PayDetailServiceImpl extends BaseServiceImpl<PayDetail> implements PayDetailService{

	private PayDetailDao payDetailDao;
	
	public PayDetailServiceImpl() {
		super();
	}
	
	public PayDetailServiceImpl(BaseDao<PayDetail> dao) {
		super(dao);
	}

	public PayDetailDao getPayDetailDao() {
		return payDetailDao;
	}

	public void setPayDetailService(PayDetailDao payDetailDao) {
		super.setDao(payDetailDao);
		this.payDetailDao = payDetailDao;
	}
	
	

}
