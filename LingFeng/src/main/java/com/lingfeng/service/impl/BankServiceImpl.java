package com.lingfeng.service.impl;

import com.lanlan.base.BaseDao;
import com.lanlan.base.BaseServiceImpl;
import com.lingfeng.dao.BankDao;
import com.lingfeng.model.Bank;
import com.lingfeng.service.BankService;

public class BankServiceImpl extends BaseServiceImpl<Bank> implements BankService{

	private BankDao bankDao;
	
	public BankServiceImpl() {
		super();
	}
	
	public BankServiceImpl(BaseDao<Bank> dao) {
		super(dao);
	}

	public BankDao getBankDao() {
		return bankDao;
	}

	public void setBankService(BankDao bankDao) {
		super.setDao(bankDao);
		this.bankDao = bankDao;
	}
	
	

}
