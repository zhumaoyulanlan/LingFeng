package com.lingfeng.model;

import com.lanlan.annotation.ID;
import com.lanlan.annotation.TableName;

import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;


@TableName("salary_night_plan")
public class SalaryNightPlan {

	@ID
	private Integer employee_id;
	private BigDecimal base_salary;
	private BigDecimal subsidies;
	private BigDecimal award;
	private BigDecimal award_each_day;



	public void setEmployee_id(Integer employee_id){
		this.employee_id=employee_id;
	}

	public Integer getEmployee_id(){
		return employee_id;
	}

	public void setBase_salary(BigDecimal base_salary){
		this.base_salary=base_salary;
	}

	public BigDecimal getBase_salary(){
		return base_salary;
	}

	public void setSubsidies(BigDecimal subsidies){
		this.subsidies=subsidies;
	}

	public BigDecimal getSubsidies(){
		return subsidies;
	}

	public void setAward(BigDecimal award){
		this.award=award;
	}

	public BigDecimal getAward(){
		return award;
	}

	public void setAward_each_day(BigDecimal award_each_day){
		this.award_each_day=award_each_day;
	}

	public BigDecimal getAward_each_day(){
		return award_each_day;
	}


}