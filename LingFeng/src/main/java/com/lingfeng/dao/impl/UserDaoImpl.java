package com.lingfeng.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.lanlan.base.BaseDaoImpl;
import com.lanlan.model.SqlParameter;
import com.lanlan.util.DBUtil;
import com.lingfeng.dao.UserDao;
import com.lingfeng.model.User;


@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

	@Autowired
	public UserDaoImpl() {
		super(User.class);
	}

	@Override
	public User login(User u)  {
		String sql ="select * from "+getTableName()+" where login_name=? and pwd=?";
		if(u!=null) {
			try(ResultSet rs= 
					DBUtil.executeQuery(sql, new SqlParameter(1,u.getLogin_name()),
							new SqlParameter(2, u.getPwd()));){
				return resultSetToModel(rs);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		return null;
	}
	
	
	/**
	 * 重写selectByPage方法,不查询密码
	 */
	@Override
	public List<User> selectByPage(int pageindex, int pagesize) {
		int min = (pageindex-1)*pagesize;
		min=min>0?min:0;
		String  sql =super.mapper.getSelectByPageSql();
		sql=sql.replaceAll("\\*", " id,login_name,\"******\" as pwd,privilege,lister_id ");
		try(ResultSet rs =DBUtil.executeQuery(sql, new SqlParameter(1, min) ,
				new SqlParameter(2,pagesize)))
		{
			return resultSetToModelList(rs);
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return new ArrayList<User>();
	}
	
	@Override
	public int changePassword(User u) {
		String sql="update "+getTableName()+" set pwd = ? where id = ?";
		try {
			return DBUtil.executeUpdate(sql, 
					new SqlParameter(1, u.getPwd()),
					new SqlParameter(2,u.getId()));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public boolean checkPassword(User u) {
		String sql="select count(*) from "+getTableName()+" where id=? and login_name=? and pwd=? ";
		try(ResultSet rs= DBUtil.executeQuery(sql, 
				new SqlParameter(1,u.getId()),
				new SqlParameter(2,u.getLogin_name()),
				new SqlParameter(3,u.getPwd()))){
			while(rs.next()) {
				return rs.getInt(1)>0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
	
	@Override
	public int update(User... model) {
		// TODO 未完成
		String sql=mapper.getUpdateByIdSql();
		System.out.println(sql);
//		return -1;
//		return super.update(model);
		return -1;
	}


	
	
	
	
	
}
