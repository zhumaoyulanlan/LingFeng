package com.lingfeng.dao.impl;

import com.lanlan.base.BaseDaoImpl;
import com.lingfeng.dao.DepartmentDao;
import com.lingfeng.model.Department;

public class DepartmentDaoImpl extends BaseDaoImpl<Department> implements DepartmentDao{

	public DepartmentDaoImpl() {
		super(Department.class);
	}

}
