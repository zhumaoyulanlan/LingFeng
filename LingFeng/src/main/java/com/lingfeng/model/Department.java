package com.lingfeng.model;

import com.lanlan.annotation.ID;
import com.lanlan.annotation.TableName;



@TableName("department")
public class Department {

	@ID
	private Integer department_id;
	private String department_name;



	public void setDepartment_id(Integer department_id){
		this.department_id=department_id;
	}

	public Integer getDepartment_id(){
		return department_id;
	}

	public void setDepartment_name(String department_name){
		this.department_name=department_name;
	}

	public String getDepartment_name(){
		return department_name;
	}


}