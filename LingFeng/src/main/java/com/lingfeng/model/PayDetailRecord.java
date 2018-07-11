package com.lingfeng.model;

import com.lanlan.annotation.ID;
import com.lanlan.annotation.TableName;

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Time;


@TableName("pay_detail_record")
public class PayDetailRecord {

	@ID
	private Integer pay_detail_record_id;
	private Integer pay_detail_id;
	private Integer employee_id;
	private Integer pay_type;
	private Integer card_id;
	private BigDecimal money;
	private Integer company_id;
	private Integer lister_id;
	private Time add_time;
	private Time modefiy_time;
	private String remark;



	public void setPay_detail_record_id(Integer pay_detail_record_id){
		this.pay_detail_record_id=pay_detail_record_id;
	}

	public Integer getPay_detail_record_id(){
		return pay_detail_record_id;
	}

	public void setPay_detail_id(Integer pay_detail_id){
		this.pay_detail_id=pay_detail_id;
	}

	public Integer getPay_detail_id(){
		return pay_detail_id;
	}

	public void setEmployee_id(Integer employee_id){
		this.employee_id=employee_id;
	}

	public Integer getEmployee_id(){
		return employee_id;
	}

	public void setPay_type(Integer pay_type){
		this.pay_type=pay_type;
	}

	public Integer getPay_type(){
		return pay_type;
	}

	public void setCard_id(Integer card_id){
		this.card_id=card_id;
	}

	public Integer getCard_id(){
		return card_id;
	}

	public void setMoney(BigDecimal money){
		this.money=money;
	}

	public BigDecimal getMoney(){
		return money;
	}

	public void setCompany_id(Integer company_id){
		this.company_id=company_id;
	}

	public Integer getCompany_id(){
		return company_id;
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