package com.diary.zhuxianjun.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diary.zhuxianjun.entity.User;
import com.diary.zhuxianjun.enums.LoginEnum;
import com.diary.zhuxianjun.mapper.UserMapper;
import com.diary.zhuxianjun.service.LoginService;
import com.diary.zhuxianjun.util.LogUtil;

@Service("loginServiceImpl")
public class LoginServiceImpl implements LoginService {

	@Autowired
	private UserMapper userMapper;

	private static final Logger LOGGER = LogUtil.getLooger().logger;

	public Map<Integer, String> validateAccount(String loginNum , String password)
	{
		LOGGER.error("验证账号开始");
		Map<Integer, String> data = new HashMap<Integer, String>();
		User user = userMapper.SelectUserByLoginNum(loginNum);
		if(null == user)
		{
			data.put(LoginEnum.ACCOUNT_NOT_EXIST.getResultCode(), LoginEnum.ACCOUNT_NOT_EXIST.getResultMessage());
		}
		LOGGER.error(user.toString());
		if(!user.getEnable())
		{
			data.put(LoginEnum.ACCOUNT_LOCKED.getResultCode(), LoginEnum.ACCOUNT_LOCKED.getResultMessage());
		}
		if(!user.getPassword().equals(password))
		{
			data.put(LoginEnum.WRONG_PASSWORD.getResultCode(), LoginEnum.WRONG_PASSWORD.getResultMessage());
		}
		return data;
	}
}
