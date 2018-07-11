package com.lingfeng.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lingfeng.model.Employee;
import com.lingfeng.service.EmployeeService;

@Controller
@RequestMapping("/dictionary")
public class DictionaryController {

	@Autowired
	private EmployeeService  employeeService;
	
	@ResponseBody
	@RequestMapping(value="/getEmployee.ajax",produces="application/json;charset=utf-8")
	public String getEmployee(HttpServletResponse response) {

		return new JSONObject(employeeService.getDictionary()).toString();

	}
	
	
}
