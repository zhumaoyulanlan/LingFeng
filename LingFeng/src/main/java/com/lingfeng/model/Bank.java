package com.lingfeng.model;

import com.lanlan.annotation.ID;
import com.lanlan.annotation.TableName;



@TableName("bank")
public class Bank {

	@ID
	private Integer bank_id;
	private String bank_name;



	public void setBank_id(Integer bank_id){
		this.bank_id=bank_id;
	}

	public Integer getBank_id(){
		return bank_id;
	}

	public void setBank_name(String bank_name){
		this.bank_name=bank_name;
	}

	public String getBank_name(){
		return bank_name;
	}


}