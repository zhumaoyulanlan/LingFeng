package com.lingfeng.util;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.junit.Test;

public class UserUtil {
	
	public static String SUCCESSED ="successed";
	
	public static String VALIDATE_LOGINNAME="6-24位字母开头";
	public static String VALIDATE_PWD="6-24位数,数字字母组合";
	
	
	public static String validateLoginName(String login_name) {
		boolean result =true;
		result =result&&login_name.matches("^.{6,24}$");
		result =result&&login_name.matches("[a-zA-Z].*");
		if(result==true) {
			return SUCCESSED;
		}
		return "用户名要求6-24位数,并以字母开头";
	}
	
	/**
	 * @message 密码要求6-24位数,至少包含一个字母,至少包含一个数字
	 * @param pwd
	 * @return
	 */
	public static String validatePwd(String pwd) {
		boolean result =true;
		result = result&&pwd.matches("^.{6,24}$");
		result =result&&pwd.matches(".*\\d.*");
		result =result&&pwd.matches(".*[a-zA-Z].*");
		
		if(result==true) {
			return SUCCESSED;
		}
		return "密码要求6-24位数,至少包含一个字母,至少包含一个数字";
	}
	
	@Test
	public void test() {
		System.out.println(UserUtil.validatePwd("9999999"));
	}
	
}
