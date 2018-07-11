package com.lingfeng.dao.impl;

import org.springframework.stereotype.Repository;

import com.lanlan.base.BaseDaoImpl;
import com.lingfeng.dao.EmployeeDao;
import com.lingfeng.model.Employee;

@Repository
public class EmployeeDaoImpl extends BaseDaoImpl<Employee> implements EmployeeDao{

	public EmployeeDaoImpl() {
		super(Employee.class);
	}

}
