package com.lingfeng.model;

import com.lanlan.annotation.ID;
import com.lanlan.annotation.TableName;



@TableName("card")
public class Card {

	@ID
	private Integer card_id;
	private Integer employee_id;
	private String card_name;
	private String card_number;
	private Integer bank_id;
	private String bank_detail_name;



	public void setCard_id(Integer card_id){
		this.card_id=card_id;
	}

	public Integer getCard_id(){
		return card_id;
	}

	public void setEmployee_id(Integer employee_id){
		this.employee_id=employee_id;
	}

	public Integer getEmployee_id(){
		return employee_id;
	}

	public void setCard_name(String card_name){
		this.card_name=card_name;
	}

	public String getCard_name(){
		return card_name;
	}

	public void setCard_number(String card_number){
		this.card_number=card_number;
	}

	public String getCard_number(){
		return card_number;
	}

	public void setBank_id(Integer bank_id){
		this.bank_id=bank_id;
	}

	public Integer getBank_id(){
		return bank_id;
	}

	public void setBank_detail_name(String bank_detail_name){
		this.bank_detail_name=bank_detail_name;
	}

	public String getBank_detail_name(){
		return bank_detail_name;
	}


}