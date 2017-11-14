package com.diary.zhuxianjun.controller;



import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.diary.zhuxianjun.constants.ConfigConstants;
import com.diary.zhuxianjun.entity.User;
import com.diary.zhuxianjun.util.ExcelExportUtil;
import com.diary.zhuxianjun.util.Student;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.diary.zhuxianjun.mapper.UserMapper;
import com.diary.zhuxianjun.service.impl.LoginServiceImpl;
import com.diary.zhuxianjun.util.LogUtil;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	private static final LogUtil log = LogUtil.getLooger();
	
	@Autowired
	private LoginServiceImpl loginService;
	
	@Autowired
	private UserMapper userMapper;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public Map<Integer , String> login(Model model,String loginNum,String password,String redirectUrl,HttpServletRequest request){
		Map<Integer , String> data = new HashMap<Integer, String>();
		String loginIP = request.getRemoteAddr();
		log.logger.error("已进入loginController,操作者ip为:"+loginIP);
		//Integer resultCode = loginService.validateAccount(loginNum, password);
		data = loginService.validateAccount(loginNum, password);
		return data;
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(Model model, HttpServletRequest request, HttpServletResponse response) throws ParseException {
		HttpSession session = request.getSession();
		return "main";
	}
	
}
