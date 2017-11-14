package com.diary.zhuxianjun.util;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import com.diary.zhuxianjun.constants.ConfigConstants;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public abstract class AESCoder
{
	/**
	 * AES加密
	 * @param strKey
	 * @param strIn
	 * @return
	 * @throws Exception
	 */
    public static String encrypt(String strKey, String strIn) throws Exception
    {
        SecretKeySpec skeySpec = getKey(strKey);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        IvParameterSpec iv = new IvParameterSpec("0102030405060708".getBytes());
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
        byte[] encrypted = cipher.doFinal(strIn.getBytes());
        return new BASE64Encoder().encode(encrypted);
    }
    
    /**
     * AES解密
     * @param strKey
     * @param strIn
     * @return
     * @throws Exception
     */
    public static String decrypt(String strKey, String strIn) throws Exception
    {
        SecretKeySpec skeySpec = getKey(strKey);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        IvParameterSpec iv = new IvParameterSpec("0102030405060708".getBytes());
        cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
        byte[] encrypted1 = new BASE64Decoder().decodeBuffer(strIn);
        byte[] original = cipher.doFinal(encrypted1);
        String originalString = new String(original);
        return originalString;
    }
    
    private static SecretKeySpec getKey(String strKey) throws Exception
    {
        byte[] arrBTmp = strKey.getBytes();
        byte[] arrB = new byte[16]; // 创建一个空的16位字节数组（默认值为0）
        
        for (int i = 0; i < arrBTmp.length && i < arrB.length; i++)
        {
            arrB[i] = arrBTmp[i];
        }
        
        SecretKeySpec skeySpec = new SecretKeySpec(arrB, "AES");
        
        return skeySpec;
    }
    
    public static void main(String[] args) throws Exception
    {
        String db_driver="com.mysql.jdbc.Driver";
        String db_url="jdbc:mysql://localhost:3306/yrlife?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull";
        String db_username="root";
        String db_password="root";
        String key = ConfigConstants.PROJECT_PRIVATE_KEY;
        String str = AESCoder.encrypt(key, db_url);
        System.out.println("加密后的db_driver为:"+AESCoder.encrypt(key, db_driver));
        System.out.println("加密后的db_url为:"+AESCoder.encrypt(key, db_url));
        System.out.println("加密后的db_username为:"+AESCoder.encrypt(key, db_username));
        System.out.println("加密后的db_password为:"+AESCoder.encrypt(key, db_password));
        System.out.println("为:"+AESCoder.decrypt(key, str));
    }
}
