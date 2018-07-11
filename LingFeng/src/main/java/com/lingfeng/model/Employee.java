package com.lingfeng.model;

import com.lanlan.annotation.ID;
import com.lanlan.annotation.TableName;



@TableName("employee")
public class Employee {

	@ID
	private Integer employee_id;
	private Integer job_number;
	private String name;
	private Integer state;



	public void setEmployee_id(Integer employee_id){
		this.employee_id=employee_id;
	}

	public Integer getEmployee_id(){
		return employee_id;
	}

	public void setJob_number(Integer job_number){
		this.job_number=job_number;
	}

	public Integer getJob_number(){
		return job_number;
	}

	public void setName(String name){
		this.name=name;
	}

	public String getName(){
		return name;
	}

	public void setState(Integer state){
		this.state=state;
	}

	public Integer getState(){
		return state;
	}


}