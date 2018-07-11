package com.lingfeng.model;

import com.lanlan.annotation.ID;
import com.lanlan.annotation.TableName;

import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Time;


@TableName("clocking_in_detail")
public class ClockingInDetail {

	@ID
	private Integer clocking_in_detail_id;
	private Integer employee_id;
	private BigDecimal clocking_plan;
	private BigDecimal clocking_day;
	private BigDecimal clocking_night;
	private BigDecimal clocking_total;
	private BigDecimal work_time;
	private BigDecimal overtime;
	private Integer lister_id;
	private Time add_time;
	private Time modefiy_time;
	private String remark;



	public void setClocking_in_detail_id(Integer clocking_in_detail_id){
		this.clocking_in_detail_id=clocking_in_detail_id;
	}

	public Integer getClocking_in_detail_id(){
		return clocking_in_detail_id;
	}

	public void setEmployee_id(Integer employee_id){
		this.employee_id=employee_id;
	}

	public Integer getEmployee_id(){
		return employee_id;
	}

	public void setClocking_plan(BigDecimal clocking_plan){
		this.clocking_plan=clocking_plan;
	}

	public BigDecimal getClocking_plan(){
		return clocking_plan;
	}

	public void setClocking_day(BigDecimal clocking_day){
		this.clocking_day=clocking_day;
	}

	public BigDecimal getClocking_day(){
		return clocking_day;
	}

	public void setClocking_night(BigDecimal clocking_night){
		this.clocking_night=clocking_night;
	}

	public BigDecimal getClocking_night(){
		return clocking_night;
	}

	public void setClocking_total(BigDecimal clocking_total){
		this.clocking_total=clocking_total;
	}

	public BigDecimal getClocking_total(){
		return clocking_total;
	}

	public void setWork_time(BigDecimal work_time){
		this.work_time=work_time;
	}

	public BigDecimal getWork_time(){
		return work_time;
	}

	public void setOvertime(BigDecimal overtime){
		this.overtime=overtime;
	}

	public BigDecimal getOvertime(){
		return overtime;
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