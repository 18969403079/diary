package com.diary.zhuxianjun.service;

import java.util.Map;



public interface LoginService {
	
	/**
	 * 通过传入的账号与密码进行账号验证
	 * @param loginNum
	 * @param password
	 * @return
	 */
	Map<Integer, String> validateAccount(String loginNum , String password);
	
}
