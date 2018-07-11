package com.lingfeng.dao.impl;

import com.lanlan.base.BaseDaoImpl;
import com.lingfeng.dao.PayDetailDao;
import com.lingfeng.model.PayDetail;

public class PayDetailDaoImpl extends BaseDaoImpl<PayDetail> implements PayDetailDao{

	public PayDetailDaoImpl() {
		super(PayDetail.class);
	}

}
