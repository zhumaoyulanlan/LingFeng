package com.lingfeng.model;

import com.lanlan.annotation.ID;
import com.lanlan.annotation.TableName;

import java.sql.Time;
import java.sql.Time;


@TableName("clocking_in")
public class ClockingIn {

	@ID
	private Integer clocking_in_id;
	private Integer year_index;
	private Integer month_index;
	private Integer lister_id;
	private Time add_time;
	private Time modefiy_time;
	private String remark;



	public void setClocking_in_id(Integer clocking_in_id){
		this.clocking_in_id=clocking_in_id;
	}

	public Integer getClocking_in_id(){
		return clocking_in_id;
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