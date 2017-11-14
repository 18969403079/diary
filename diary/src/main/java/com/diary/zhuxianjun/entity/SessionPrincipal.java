package com.diary.zhuxianjun.entity;

/**
 * 登录之后的session里的个人信息
 * Created by BigPigMan on 2017/10/19 0019.
 */
public class SessionPrincipal {

    private Long userId;

    private String userName;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
