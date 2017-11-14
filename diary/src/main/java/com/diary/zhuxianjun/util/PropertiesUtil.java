package com.diary.zhuxianjun.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import com.diary.zhuxianjun.constants.ConfigConstants;

/**
 * 配置文件工具类
 * @author	BigPigMan
 * @Date	2017年10月17日
 */
public class PropertiesUtil {

	private static Properties properties;
	
	public static Map<String, ResourceBundle> bundles = new HashMap<String, ResourceBundle>();
	static{
		try {
			properties = PropertiesLoaderUtils.loadProperties(new ClassPathResource(ConfigConstants.PROPERTIES_FILE_PATH));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static ResourceBundle load(String name){
		ResourceBundle res = bundles.get(name);
		try {
			if(res == null){
				res = ResourceBundle.getBundle(name);
				if ( res == null ){
					res = ResourceBundle.getBundle(name, null, PropertiesUtil.class.getClassLoader() );
				}
				if ( null != res ){
					bundles.put(name, res);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public PropertiesUtil() {
		
	}
	
	public static String get(String key){
		return get(null,key);
	}
	
	/** 
	 * @Title: get 
	 * @Description: 获取属性配置信息
	 * @param path   属性所在文件
	 * @param key    属性key
	 * @return
	 * @return: String
	 */
	public static String get(String path, String key) {
		if(null == path){
			return properties.getProperty(key);
		}else{
			try {
				return PropertiesLoaderUtils.loadProperties(new ClassPathResource(path)).getProperty(key);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
	}
	
	public static String get2(String baseName, String key) {
		try{
			return load(baseName).getString(key);
		}catch(Throwable e){
			return null;
		}
	}
	
	public static String get2(String baseName, String key,String defaultValue) {
		try{
			return load(baseName).getString(key);
		}catch(Throwable e){
			return defaultValue;
		}
	}
}
