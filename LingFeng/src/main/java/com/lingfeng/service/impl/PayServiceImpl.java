package com.lingfeng.service.impl;

import com.lanlan.base.BaseDao;
import com.lanlan.base.BaseServiceImpl;
import com.lingfeng.dao.PayDao;
import com.lingfeng.model.Pay;
import com.lingfeng.service.PayService;

public class PayServiceImpl extends BaseServiceImpl<Pay> implements PayService{

	private PayDao payDao;
	
	public PayServiceImpl() {
		super();
	}
	
	public PayServiceImpl(BaseDao<Pay> dao) {
		super(dao);
	}

	public PayDao getPayDao() {
		return payDao;
	}

	public void setPayService(PayDao payDao) {
		super.setDao(payDao);
		this.payDao = payDao;
	}
	
	

}
