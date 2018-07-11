package com.lingfeng.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanlan.base.BaseDao;
import com.lanlan.base.BaseServiceImpl;
import com.lingfeng.dao.EmployeeDao;
import com.lingfeng.model.Employee;
import com.lingfeng.service.EmployeeService;

@Service
public class EmployeeServiceImpl extends BaseServiceImpl<Employee> implements EmployeeService{

	private EmployeeDao employeeDao;
	
	public EmployeeServiceImpl() {
		super();
	}
	

	public EmployeeServiceImpl(BaseDao<Employee> dao) {
		super(dao);
	}

	public EmployeeDao getEmployeeDao() {
		return employeeDao;
	}

	@Autowired
	public void setEmployeeService(EmployeeDao employeeDao) {
		super.setDao(employeeDao);
		this.employeeDao = employeeDao;
	}

	@Override
	public Map<Integer, String> getDictionary() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		List<Employee> list =employeeDao.selectAll();
		for (Employee employee : list) {
			map.put(employee.getEmployee_id(),"["+employee.getJob_number()+"]"+employee.getName());
		}
		return map;
	}
	
	

}
