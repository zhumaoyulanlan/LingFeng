package com.lingfeng.service.impl;

import com.lanlan.base.BaseDao;
import com.lanlan.base.BaseServiceImpl;
import com.lingfeng.dao.PayDetailRecordDao;
import com.lingfeng.model.PayDetailRecord;
import com.lingfeng.service.PayDetailRecordService;

public class PayDetailRecordServiceImpl extends BaseServiceImpl<PayDetailRecord> implements PayDetailRecordService{

	private PayDetailRecordDao payDetailRecordDao;
	
	public PayDetailRecordServiceImpl() {
		super();
	}
	
	public PayDetailRecordServiceImpl(BaseDao<PayDetailRecord> dao) {
		super(dao);
	}

	public PayDetailRecordDao getPayDetailRecordDao() {
		return payDetailRecordDao;
	}

	public void setPayDetailRecordService(PayDetailRecordDao payDetailRecordDao) {
		super.setDao(payDetailRecordDao);
		this.payDetailRecordDao = payDetailRecordDao;
	}
	
	

}
