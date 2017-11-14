package com.diary.zhuxianjun.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import com.diary.zhuxianjun.constants.ConfigConstants;

public class MyConvertPropertyConfig extends PropertyPlaceholderConfigurer {

	private static LogUtil LOG = LogUtil.getLooger();
	
	private static List<String> keyList = new ArrayList<String>();

	static {
		keyList.add(ConfigConstants.DB_URL);
		keyList.add(ConfigConstants.DB_DRIVER);
		keyList.add(ConfigConstants.DB_USER_NAME);
		keyList.add(ConfigConstants.DB_PASSWORD);
	}

	@Override
	protected String convertProperty(String propertyName, String propertyValue) {
		try {
			if (1 == 2 && keyList.contains(propertyName)) {
				String value = AESCoder.decrypt(ConfigConstants.PROJECT_PRIVATE_KEY, propertyValue);
				LOG.logger.error("解密属性" + propertyName + ",解密成功");
				return value;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return propertyValue;
	}
}
