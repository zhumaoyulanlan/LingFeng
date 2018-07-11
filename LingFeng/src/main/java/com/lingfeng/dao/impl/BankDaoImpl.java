package com.lingfeng.dao.impl;

import com.lanlan.base.BaseDaoImpl;
import com.lingfeng.dao.BankDao;
import com.lingfeng.model.Bank;

public class BankDaoImpl extends BaseDaoImpl<Bank> implements BankDao{

	public BankDaoImpl() {
		super(Bank.class);
	}

}
