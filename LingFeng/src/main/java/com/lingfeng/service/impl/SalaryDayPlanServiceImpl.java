package com.lingfeng.service.impl;

import com.lanlan.base.BaseDao;
import com.lanlan.base.BaseServiceImpl;
import com.lingfeng.dao.SalaryDayPlanDao;
import com.lingfeng.model.SalaryDayPlan;
import com.lingfeng.service.SalaryDayPlanService;

public class SalaryDayPlanServiceImpl extends BaseServiceImpl<SalaryDayPlan> implements SalaryDayPlanService{

	private SalaryDayPlanDao salaryDayPlanDao;
	
	public SalaryDayPlanServiceImpl() {
		super();
	}
	
	public SalaryDayPlanServiceImpl(BaseDao<SalaryDayPlan> dao) {
		super(dao);
	}

	public SalaryDayPlanDao getSalaryDayPlanDao() {
		return salaryDayPlanDao;
	}

	public void setSalaryDayPlanService(SalaryDayPlanDao salaryDayPlanDao) {
		super.setDao(salaryDayPlanDao);
		this.salaryDayPlanDao = salaryDayPlanDao;
	}
	
	

}
