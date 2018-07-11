package com.lingfeng.model;

import com.lanlan.annotation.ID;
import com.lanlan.annotation.TableName;



@TableName("company")
public class Company {

	@ID
	private Integer company_id;
	private String company_name;



	public void setCompany_id(Integer company_id){
		this.company_id=company_id;
	}

	public Integer getCompany_id(){
		return company_id;
	}

	public void setCompany_name(String company_name){
		this.company_name=company_name;
	}

	public String getCompany_name(){
		return company_name;
	}


}