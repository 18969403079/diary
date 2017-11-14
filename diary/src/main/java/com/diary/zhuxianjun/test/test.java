package com.diary.zhuxianjun.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.diary.zhuxianjun.entity.User;

public class test {
	public static void main(String[] args) {
	}

	public User selectUser() throws IOException {
		// mybatis配置文件
		String resource = "/diary/src/main/resources/mybatis.xml";
		InputStream input = Resources.getResourceAsStream(resource);
		// 创建会话工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(input);
		return null;
	}
}
