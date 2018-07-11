package com.lingfeng.service.impl;

import com.lanlan.base.BaseDao;
import com.lanlan.base.BaseServiceImpl;
import com.lingfeng.dao.SalaryPayDao;
import com.lingfeng.model.SalaryPay;
import com.lingfeng.service.SalaryPayService;

public class SalaryPayServiceImpl extends BaseServiceImpl<SalaryPay> implements SalaryPayService{

	private SalaryPayDao salaryPayDao;
	
	public SalaryPayServiceImpl() {
		super();
	}
	
	public SalaryPayServiceImpl(BaseDao<SalaryPay> dao) {
		super(dao);
	}

	public SalaryPayDao getSalaryPayDao() {
		return salaryPayDao;
	}

	public void setSalaryPayService(SalaryPayDao salaryPayDao) {
		super.setDao(salaryPayDao);
		this.salaryPayDao = salaryPayDao;
	}
	
	

}
