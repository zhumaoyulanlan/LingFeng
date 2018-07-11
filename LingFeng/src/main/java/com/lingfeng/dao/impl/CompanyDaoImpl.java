package com.lingfeng.dao.impl;

import com.lanlan.base.BaseDaoImpl;
import com.lingfeng.dao.CompanyDao;
import com.lingfeng.model.Company;

public class CompanyDaoImpl extends BaseDaoImpl<Company> implements CompanyDao{

	public CompanyDaoImpl() {
		super(Company.class);
	}

}
