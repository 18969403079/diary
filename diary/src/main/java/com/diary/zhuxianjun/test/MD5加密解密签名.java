package com.diary.zhuxianjun.test;

import java.security.NoSuchAlgorithmException;

import com.diary.zhuxianjun.util.MD5;

public class MD5加密解密签名 {
	
	public static void main(String[] args) throws NoSuchAlgorithmException {
		
		//测试MD5加密
		String preEncryptStr = "19920628";
		String encryptedStr = MD5.crypt(preEncryptStr);
		System.out.println("加密后的字符串为:"+encryptedStr);
		
		//测试MD5签名
		String signKey = "BigPigMan";
		String preSignStr = "www.baidu.com";
		String signCharset = "UTF-8";
		String signedStr = MD5.sign(signKey,preSignStr,signCharset);
		System.out.println("签名后的字符串为:"+signedStr);
		
		//验证签名
		Boolean signValidate = MD5.verify(preSignStr, signedStr, signKey, signCharset);
		System.out.println("签名验证结果为:"+signValidate);
	}
	
	
}
