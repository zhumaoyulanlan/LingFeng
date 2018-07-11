package com.lingfeng.model;

import com.lanlan.annotation.ID;
import com.lanlan.annotation.TableName;



@TableName("user")
public class User {

	@ID
	private Integer id;
	private String login_name;
	private String pwd;
	private Integer privilege;
	private Integer lister_id;



	public void setId(Integer id){
		this.id=id;
	}

	public Integer getId(){
		return id;
	}

	public void setLogin_name(String login_name){
		this.login_name=login_name;
	}

	public String getLogin_name(){
		return login_name;
	}

	public void setPwd(String pwd){
		this.pwd=pwd;
	}

	public String getPwd(){
		return pwd;
	}

	public void setPrivilege(Integer privilege){
		this.privilege=privilege;
	}

	public Integer getPrivilege(){
		return privilege;
	}

	public void setLister_id(Integer lister_id){
		this.lister_id=lister_id;
	}

	public Integer getLister_id(){
		return lister_id;
	}


}