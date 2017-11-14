package com.diary.zhuxianjun.enums;

public enum LoginEnum {
	
	/**
	 * 登录成功
	 */
	LOGIN_SUCCESS(10000,"登录成功"),
	/**
	 * 账号不存在
	 */
	ACCOUNT_NOT_EXIST(10001,"账号不存在"),
	/**
	 * 密码不正确
	 */
	WRONG_PASSWORD(10002,"密码不正确"),
	/**
	 * 账号已被锁定
	 */
	ACCOUNT_LOCKED(10003,"账号已被锁定"),
	/**
	 * 系统异常
	 */
	SYSTEM_ERROR(11111,"系统异常");
	
	private Integer resultCode;
	
	private String resultMessage;
	
	public Integer getResultCode() {
		return resultCode;
	}

	public void setResultCode(Integer resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultMessage() {
		return resultMessage;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}

	private LoginEnum(Integer resultCode , String resultMessage)
	{
		this.resultCode = resultCode;
		this.resultMessage = resultMessage;
	}
	
}

