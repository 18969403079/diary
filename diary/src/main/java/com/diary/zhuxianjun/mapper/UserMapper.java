package com.diary.zhuxianjun.mapper;

import com.diary.zhuxianjun.entity.User;

public interface UserMapper {
	
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    /**
     * 通过登录账号查询用户（该账号可以是用户名，也可以是手机号）
     * @param loginNum
     * @return
     */
    User SelectUserByLoginNum(String loginNum);
}