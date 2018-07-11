package com.lingfeng.service.impl;

import com.lanlan.base.BaseDao;
import com.lanlan.base.BaseServiceImpl;
import com.lingfeng.dao.CompanyDao;
import com.lingfeng.model.Company;
import com.lingfeng.service.CompanyService;

public class CompanyServiceImpl extends BaseServiceImpl<Company> implements CompanyService{

	private CompanyDao companyDao;
	
	public CompanyServiceImpl() {
		super();
	}
	
	public CompanyServiceImpl(BaseDao<Company> dao) {
		super(dao);
	}

	public CompanyDao getCompanyDao() {
		return companyDao;
	}

	public void setCompanyService(CompanyDao companyDao) {
		super.setDao(companyDao);
		this.companyDao = companyDao;
	}
	
	

}
