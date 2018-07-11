package com.lingfeng.service.impl;

import com.lanlan.base.BaseDao;
import com.lanlan.base.BaseServiceImpl;
import com.lingfeng.dao.SalaryPayDetailDao;
import com.lingfeng.model.SalaryPayDetail;
import com.lingfeng.service.SalaryPayDetailService;

public class SalaryPayDetailServiceImpl extends BaseServiceImpl<SalaryPayDetail> implements SalaryPayDetailService{

	private SalaryPayDetailDao salaryPayDetailDao;
	
	public SalaryPayDetailServiceImpl() {
		super();
	}
	
	public SalaryPayDetailServiceImpl(BaseDao<SalaryPayDetail> dao) {
		super(dao);
	}

	public SalaryPayDetailDao getSalaryPayDetailDao() {
		return salaryPayDetailDao;
	}

	public void setSalaryPayDetailService(SalaryPayDetailDao salaryPayDetailDao) {
		super.setDao(salaryPayDetailDao);
		this.salaryPayDetailDao = salaryPayDetailDao;
	}
	
	

}
