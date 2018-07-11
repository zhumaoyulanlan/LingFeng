package com.lingfeng.service.impl;

import com.lanlan.base.BaseDao;
import com.lanlan.base.BaseServiceImpl;
import com.lingfeng.dao.EmployeeInfoDao;
import com.lingfeng.model.EmployeeInfo;
import com.lingfeng.service.EmployeeInfoService;

public class EmployeeInfoServiceImpl extends BaseServiceImpl<EmployeeInfo> implements EmployeeInfoService{

	private EmployeeInfoDao employeeInfoDao;
	
	public EmployeeInfoServiceImpl() {
		super();
	}
	
	public EmployeeInfoServiceImpl(BaseDao<EmployeeInfo> dao) {
		super(dao);
	}

	public EmployeeInfoDao getEmployeeInfoDao() {
		return employeeInfoDao;
	}

	public void setEmployeeInfoService(EmployeeInfoDao employeeInfoDao) {
		super.setDao(employeeInfoDao);
		this.employeeInfoDao = employeeInfoDao;
	}
	
	

}
