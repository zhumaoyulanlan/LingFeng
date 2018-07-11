package com.lingfeng.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lanlan.util.PageBarUtil;
import com.lingfeng.model.Employee;
import com.lingfeng.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/list")
	public String list(ModelMap map, HttpServletRequest request ) {
		int pageindex= PageBarUtil.getPageIndex(request);
		int pagesize = PageBarUtil.getPageSize(request);
		String pageBar = PageBarUtil.getPageBar(request, employeeService, pagesize);
		map.put("pageBar", pageBar);
		List<Employee> modelList = employeeService.selectByPage(pageindex, pagesize);
		map.put("modelList", modelList);
		return "employee/list";
	}
	
//	@PostMapping("/list")
//	@ResponseBody
//	public String listEmployee(ModelMap map, HttpServletRequest request ) {
//		int pageindex= PageBarUtil.getPageIndex(request);
//		int pagesize = PageBarUtil.getPageSize(request);
//		String pageBar = PageBarUtil.getPageBar(request, employeeService, pagesize);
//		map.put("pageBar", pageBar);
//		List<Employee> modelList = employeeService.selectByPage(pageindex, pagesize);
//		map.put("modelList", modelList);
//		return "employee/list";
//	}
	
	
}
