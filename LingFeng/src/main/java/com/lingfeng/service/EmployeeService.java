package com.lingfeng.service;

import java.util.Map;

import com.lanlan.base.BaseService;
import com.lingfeng.model.Employee;

public interface EmployeeService extends BaseService<Employee>{

	public Map<Integer,String> getDictionary();
}
