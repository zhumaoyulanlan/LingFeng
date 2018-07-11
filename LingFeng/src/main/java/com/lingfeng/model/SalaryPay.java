package com.lingfeng.model;

import com.lanlan.annotation.ID;
import com.lanlan.annotation.TableName;

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Time;


@TableName("salary_pay")
public class SalaryPay {

	@ID
	private Integer salary_pay_id;
	private Integer year_index;
	private Integer month_index;
	private BigDecimal salary_total;
	private Integer lister_id;
	private Time add_time;
	private Time modefiy_time;
	private String remark;



	public void setSalary_pay_id(Integer salary_pay_id){
		this.salary_pay_id=salary_pay_id;
	}

	public Integer getSalary_pay_id(){
		return salary_pay_id;
	}

	public void setYear_index(Integer year_index){
		this.year_index=year_index;
	}

	public Integer getYear_index(){
		return year_index;
	}

	public void setMonth_index(Integer month_index){
		this.month_index=month_index;
	}

	public Integer getMonth_index(){
		return month_index;
	}

	public void setSalary_total(BigDecimal salary_total){
		this.salary_total=salary_total;
	}

	public BigDecimal getSalary_total(){
		return salary_total;
	}

	public void setLister_id(Integer lister_id){
		this.lister_id=lister_id;
	}

	public Integer getLister_id(){
		return lister_id;
	}

	public void setAdd_time(Time add_time){
		this.add_time=add_time;
	}

	public Time getAdd_time(){
		return add_time;
	}

	public void setModefiy_time(Time modefiy_time){
		this.modefiy_time=modefiy_time;
	}

	public Time getModefiy_time(){
		return modefiy_time;
	}

	public void setRemark(String remark){
		this.remark=remark;
	}

	public String getRemark(){
		return remark;
	}


}