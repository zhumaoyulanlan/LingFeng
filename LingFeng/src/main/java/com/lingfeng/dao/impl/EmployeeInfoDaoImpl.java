package com.lingfeng.dao.impl;

import com.lanlan.base.BaseDaoImpl;
import com.lingfeng.dao.EmployeeInfoDao;
import com.lingfeng.model.EmployeeInfo;

public class EmployeeInfoDaoImpl extends BaseDaoImpl<EmployeeInfo> implements EmployeeInfoDao{

	public EmployeeInfoDaoImpl() {
		super(EmployeeInfo.class);
	}

}
