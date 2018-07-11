package com.lingfeng.service.impl;

import com.lanlan.base.BaseDao;
import com.lanlan.base.BaseServiceImpl;
import com.lingfeng.dao.DepartmentDao;
import com.lingfeng.model.Department;
import com.lingfeng.service.DepartmentService;

public class DepartmentServiceImpl extends BaseServiceImpl<Department> implements DepartmentService{

	private DepartmentDao departmentDao;
	
	public DepartmentServiceImpl() {
		super();
	}
	
	public DepartmentServiceImpl(BaseDao<Department> dao) {
		super(dao);
	}

	public DepartmentDao getDepartmentDao() {
		return departmentDao;
	}

	public void setDepartmentService(DepartmentDao departmentDao) {
		super.setDao(departmentDao);
		this.departmentDao = departmentDao;
	}
	
	

}
