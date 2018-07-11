package com.lingfeng.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lanlan.util.PageBarUtil;
import com.lingfeng.dao.UserDao;
import com.lingfeng.model.Employee;
import com.lingfeng.model.User;
import com.lingfeng.service.EmployeeService;
import com.lingfeng.service.UserService;
import com.lingfeng.util.UserUtil;

@Controller
@RequestMapping("/user")
public class UserController {
	
	
	//@Autowired
//	private UserDao userDao;
	
	
	/**
	 * 显示登录页面
	 */
	@Autowired
	private UserService userService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/login")
	public String login() {
		return "user/Login";
	}
	
	/**
	 * 	登录
	 * @param map
	 * @param u
	 * @param session
	 * @return
	 */
	@PostMapping("/login")
	public String add(ModelMap map, @ModelAttribute(name="user") User u, HttpSession session) {
		User loginUser =userService.login(u);
		if(loginUser==null) {
			return "redirect:/user/login.do";
		}
		session.setAttribute("loginUser", loginUser);
		return "main/Index";
	}
	
	/**
	 * 显示用户
	 * @param map
	 * @param request
	 * @return
	 */
	@RequestMapping("/userlist.do")
	public String userList(ModelMap map, HttpServletRequest request ) {
		Integer pageIndex=PageBarUtil.getPageIndex(request);
		Integer pageSize=PageBarUtil.getPageSize(request);
		List<User> userList = userService.selectByPage(pageIndex, pageSize);
		map.put("map",employeeService.getDictionary());
		map.put("userList", userList);
		map.put("pageBar", PageBarUtil.getPageBar(request, userService, pageSize));
		return "user/UserList";
	}
	
	/**
	 * 显示添加用户页
	 * @return
	 */
	@GetMapping("/userAdd")
	public String addlist(ModelMap map) {
		map.put("VALIDATE_LOGINNAME", UserUtil.VALIDATE_LOGINNAME);
		map.put("VALIDATE_PWD", UserUtil.VALIDATE_PWD);
		return "user/UserAdd";
	}
	
	/**
	 * 添加用户
	 * @return
	 */
	@PostMapping("/userAdd")
	public String addUser(ModelMap map, User u,String repwd) {
		
		boolean b = true;
		if(u.getPwd().equals(repwd)) {
			map.put("repwdmsg","");
			b= b&&true;
		}else {
			map.put("repwdmsg","两次密码不一致");
			b= false;
		}
		String nameMsg  =UserUtil.validateLoginName(u.getLogin_name());
		if(UserUtil.SUCCESSED.equals(nameMsg)) {
			map.put("nameMsg","");
			b=b&&true;
		}else {
			map.put("nameMsg", nameMsg);
			b= false;
		}
		
		
		String pwdMsg = UserUtil.validatePwd(u.getPwd());
		if(UserUtil.SUCCESSED.equals(pwdMsg)) {
			map.put("pwdMsg","");
			b=b&&true;
		}else {
			map.put("pwdMsg", pwdMsg);
			b= false;
		}
		if(b) {
			userService.insert(u);
		}
		else {
			return "/user/UserAdd";
		}
		map.clear();
		return "redirect:/user/userlist.do";
	}
	
	
	/**
	 * 显示修改密码页
	 * @param map
	 * @param id
	 * @return
	 */
	@GetMapping("/password")
	public String userPassword(ModelMap map, Integer id) {
		map.put("VALIDATE_PWD", UserUtil.VALIDATE_PWD);
		if(id==null) {
			return "error/ErrorPage";
		}
		User user = new User();
		user.setId(id);
		map.put("user",userService.selectById(user));
		return "user/UserPassword";
	}

	/**
	 * 修改密码
	 * @param map
	 * @param id
	 * @param login_name
	 * @param oldpwd
	 * @param pwd
	 * @param repwd
	 * @return
	 */
	@PostMapping("/password")
	public String changePassword(ModelMap map ,Integer id ,String login_name,String oldpwd,String pwd ,String repwd ) {
		User user =new User();
		user.setId(id);
		user.setLogin_name(login_name);
		user.setPwd(pwd);
		map.put("user", user);
		
		//验证
		if(!pwd.equals(repwd)) {
			map.put("repwdmsg", "两次密码不一致");
			return "user/UserPassword";
		}else {
			map.put("repwdmsg", "");
		}
		
		/*
		 * 密码格式验证
		 */
		String msg = UserUtil.validatePwd(pwd);
		if(UserUtil.SUCCESSED.equals(msg)) {
			map.put("pwdmsg","");
		}else {
			map.put("pwdmsg", msg);
			return "user/UserPassword";
		}
		
		//密码验证  不做密码验证
		/*
		if(!userService.checkPassword(user)) {
			map.put("oldpwdmsg", "原密码错误");
			return "user/password";
		}else {
			map.put("oldpwdmsg", "");
		}
		*/
		
		//修改密码
		if(userService.changePassword(user)>0) {
			map.clear();
			return "user/UserPasswordSuccessed";
		}
		return "erro/ErrorPage";
	}
	
	@ExceptionHandler
	public String error(Exception e) {
		e.printStackTrace();
		return "/error/errorPage";
	}
	
	/**
	 * 进入删除页
	 * @return
	 */
	@GetMapping("/delete.do")
	public String delete(ModelMap map, User user) {
		User rsuser= userService.selectById(user);
		
		map.put("user",rsuser);
		map.put("employee", employeeService.selectById(user.getLister_id()));
		return "user/UserDelete";
	}
	
	/**
	 * 删除
	 * @param map
	 * @param user
	 * @return
	 */
	@PostMapping("/delete.do")
	public String deleteUser(ModelMap map,User user) {
		
		if(userService.deleteById(user)>0) {
			return "redirect:/user/userlist.do";
		}
		return "/error/errorPage";
	}
	
}
