package com.lingfeng.model;

import com.lanlan.annotation.ID;
import com.lanlan.annotation.TableName;



@TableName("employee_info")
public class EmployeeInfo {

	@ID
	private Integer employee_id;
	private Integer gender;
	private Integer age;
	private String id_card_no;
	private Integer department_id;
	private String post;
	private String phone;
	private String phone_other;
	private String native_place;
	private String address;
	private String politics_status;
	private String remark;



	public void setEmployee_id(Integer employee_id){
		this.employee_id=employee_id;
	}

	public Integer getEmployee_id(){
		return employee_id;
	}

	public void setGender(Integer gender){
		this.gender=gender;
	}

	public Integer getGender(){
		return gender;
	}

	public void setAge(Integer age){
		this.age=age;
	}

	public Integer getAge(){
		return age;
	}

	public void setId_card_no(String id_card_no){
		this.id_card_no=id_card_no;
	}

	public String getId_card_no(){
		return id_card_no;
	}

	public void setDepartment_id(Integer department_id){
		this.department_id=department_id;
	}

	public Integer getDepartment_id(){
		return department_id;
	}

	public void setPost(String post){
		this.post=post;
	}

	public String getPost(){
		return post;
	}

	public void setPhone(String phone){
		this.phone=phone;
	}

	public String getPhone(){
		return phone;
	}

	public void setPhone_other(String phone_other){
		this.phone_other=phone_other;
	}

	public String getPhone_other(){
		return phone_other;
	}

	public void setNative_place(String native_place){
		this.native_place=native_place;
	}

	public String getNative_place(){
		return native_place;
	}

	public void setAddress(String address){
		this.address=address;
	}

	public String getAddress(){
		return address;
	}

	public void setPolitics_status(String politics_status){
		this.politics_status=politics_status;
	}

	public String getPolitics_status(){
		return politics_status;
	}

	public void setRemark(String remark){
		this.remark=remark;
	}

	public String getRemark(){
		return remark;
	}


}