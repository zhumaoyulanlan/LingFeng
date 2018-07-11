package com.lingfeng.dao.impl;

import com.lanlan.base.BaseDaoImpl;
import com.lingfeng.dao.PayDao;
import com.lingfeng.model.Pay;

public class PayDaoImpl extends BaseDaoImpl<Pay> implements PayDao{

	public PayDaoImpl() {
		super(Pay.class);
	}

}
