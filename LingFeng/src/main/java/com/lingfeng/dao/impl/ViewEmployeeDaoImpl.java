package com.lingfeng.dao.impl;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.mapper.Mapper;

import com.lanlan.base.BaseDaoImpl;
import com.lanlan.model.SqlParameter;
import com.lanlan.util.DBUtil;
import com.lanlan.util.ModelUtil;
import com.lingfeng.dao.EmployeeDao;
import com.lingfeng.dao.EmployeeInfoDao;
import com.lingfeng.dao.ViewEmployeeDao;
import com.lingfeng.model.Employee;
import com.lingfeng.model.EmployeeInfo;
import com.lingfeng.viewmodel.ViewEmployee;

import sun.print.resources.serviceui;

public class ViewEmployeeDaoImpl extends BaseDaoImpl<ViewEmployee> implements   ViewEmployeeDao {

	public ViewEmployeeDaoImpl() {
		this(ViewEmployee.class);
	}
	
	public ViewEmployeeDaoImpl(Class<ViewEmployee> tClass) {
		super(tClass);
	}

	EmployeeDao employeeDao;
	EmployeeInfoDao employeeInfoDao;

	private static String selectSql = "select employee.employee_id,job_number,name,state,gender,age,id_card_no,e.department_id,department_name,post,phone,phone_other,native_place,address,politics_status,remark from employee left join employee_info as e on employee.employee_id=e.employee_id  left join department  on e.department_id= department.department_id";

	@Override
	public int insert(ViewEmployee... model) {
		Employee employee =ModelUtil.CloneValueModelToModel(model, new Employee());
		EmployeeInfo employeeInfo =ModelUtil.CloneValueModelToModel(model, new EmployeeInfo());
		DBUtil.setAutoCommit(true);
		int rs = employeeDao.insert(employee);
		int rs2 = employeeInfoDao.insert(employeeInfo);
		if(rs<0||rs2<0) {
			DBUtil.rollback();
		}else {
			DBUtil.commit();
		}
		return 0;
	}

	@Override
	public int deleteById(Serializable... ids) {
		if(ids!=null && ids[0]instanceof  Integer ||ids[0]instanceof  String) {
			DBUtil.setAutoCommit(true);
			int rs = employeeDao.deleteById(ids);
			int rs2 = employeeInfoDao.deleteById(ids);
			if(rs<0||rs2<0) {
				DBUtil.rollback();
			}else {
				DBUtil.commit();
			}
		}
		return -1;
	}
	


	@Override
	public int update(ViewEmployee... viewEmployees) {
		Employee[] employees =ModelUtil.CloneValueModelToModelList(viewEmployees, Employee.class);
		EmployeeInfo[] employeeInfos = ModelUtil.CloneValueModelToModelList(viewEmployees, EmployeeInfo.class);
		DBUtil.setAutoCommit(false);
		int rs1=employeeDao.update(employees);
		int rs2=employeeInfoDao.update(employeeInfos);
		if(rs1>0&&rs2>0) {
			DBUtil.commit();
			return 1;
		}else {
			DBUtil.rollback();
			return -1;
		}
	}

	 @Override
	protected String getSelectAllSql() {
		
		 	String sql ="select employee.employee_id,job_number,name,state,gender,age,id_card_no,e.department_id,department_name,post,phone,phone_other,native_place,address,politics_status,remark from employee left join employee_info as e on employee.employee_id=e.employee_id  left join department  on e.department_id= department.department_id ";
		 	return sql;
	}
	
	@Override
	public ViewEmployee selectById(Serializable idOrModel) {
		String sql ="select employee.employee_id,job_number,name,state,gender,age,id_card_no,e.department_id,department_name,post,phone,phone_other,native_place,address,politics_status,remark from employee left join employee_info as e on employee.employee_id=e.employee_id  left join department  on e.department_id= department.department_id where e.employee_id=?";
		int employee_id=-1;
		if(idOrModel instanceof ViewEmployee) {
			employee_id=((ViewEmployee)idOrModel).getEmployee_id();
		}
		if(idOrModel instanceof Integer) {
			employee_id=(Integer)idOrModel;
		}
		SqlParameter parameters = new SqlParameter(1,employee_id);
		try (ResultSet rs = DBUtil.executeQuery(sql, parameters)){
			return resultSetToModel(rs);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ViewEmployee> selectAll() {
		try(ResultSet rs = DBUtil.executeQuery(selectSql)){
			return resultSetToModelList(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
				
	}

















	
	
}
