package com.lingfeng.model;

import com.lanlan.annotation.ID;
import com.lanlan.annotation.TableName;

import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Time;


@TableName("salary_pay_detail")
public class SalaryPayDetail {

	@ID
	private Integer salary_pay_detail_id;
	private Integer salary_pay_id;
	private BigDecimal base_salary;
	private BigDecimal attendance_bonus;
	private BigDecimal personal_award;
	private BigDecimal company_award;
	private BigDecimal charge;
	private BigDecimal fine;
	private String fine_text;
	private BigDecimal award;
	private String award_text;
	private BigDecimal subsidy;
	private String subsidy_text;
	private Integer lister_id;
	private Time add_time;
	private Time modefiy_time;
	private String remark;



	public void setSalary_pay_detail_id(Integer salary_pay_detail_id){
		this.salary_pay_detail_id=salary_pay_detail_id;
	}

	public Integer getSalary_pay_detail_id(){
		return salary_pay_detail_id;
	}

	public void setSalary_pay_id(Integer salary_pay_id){
		this.salary_pay_id=salary_pay_id;
	}

	public Integer getSalary_pay_id(){
		return salary_pay_id;
	}

	public void setBase_salary(BigDecimal base_salary){
		this.base_salary=base_salary;
	}

	public BigDecimal getBase_salary(){
		return base_salary;
	}

	public void setAttendance_bonus(BigDecimal attendance_bonus){
		this.attendance_bonus=attendance_bonus;
	}

	public BigDecimal getAttendance_bonus(){
		return attendance_bonus;
	}

	public void setPersonal_award(BigDecimal personal_award){
		this.personal_award=personal_award;
	}

	public BigDecimal getPersonal_award(){
		return personal_award;
	}

	public void setCompany_award(BigDecimal company_award){
		this.company_award=company_award;
	}

	public BigDecimal getCompany_award(){
		return company_award;
	}

	public void setCharge(BigDecimal charge){
		this.charge=charge;
	}

	public BigDecimal getCharge(){
		return charge;
	}

	public void setFine(BigDecimal fine){
		this.fine=fine;
	}

	public BigDecimal getFine(){
		return fine;
	}

	public void setFine_text(String fine_text){
		this.fine_text=fine_text;
	}

	public String getFine_text(){
		return fine_text;
	}

	public void setAward(BigDecimal award){
		this.award=award;
	}

	public BigDecimal getAward(){
		return award;
	}

	public void setAward_text(String award_text){
		this.award_text=award_text;
	}

	public String getAward_text(){
		return award_text;
	}

	public void setSubsidy(BigDecimal subsidy){
		this.subsidy=subsidy;
	}

	public BigDecimal getSubsidy(){
		return subsidy;
	}

	public void setSubsidy_text(String subsidy_text){
		this.subsidy_text=subsidy_text;
	}

	public String getSubsidy_text(){
		return subsidy_text;
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