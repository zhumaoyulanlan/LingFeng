package com.lingfeng.service.impl;

import com.lanlan.base.BaseDao;
import com.lanlan.base.BaseServiceImpl;
import com.lingfeng.dao.SalaryNightPlanDao;
import com.lingfeng.model.SalaryNightPlan;
import com.lingfeng.service.SalaryNightPlanService;

public class SalaryNightPlanServiceImpl extends BaseServiceImpl<SalaryNightPlan> implements SalaryNightPlanService{

	private SalaryNightPlanDao salaryNightPlanDao;
	
	public SalaryNightPlanServiceImpl() {
		super();
	}
	
	public SalaryNightPlanServiceImpl(BaseDao<SalaryNightPlan> dao) {
		super(dao);
	}

	public SalaryNightPlanDao getSalaryNightPlanDao() {
		return salaryNightPlanDao;
	}

	public void setSalaryNightPlanService(SalaryNightPlanDao salaryNightPlanDao) {
		super.setDao(salaryNightPlanDao);
		this.salaryNightPlanDao = salaryNightPlanDao;
	}
	
	

}
