package cn.dibcbks.util;

import java.util.UUID;

import org.apache.shiro.crypto.hash.SimpleHash;

public class CommonUtil {
	/**
	 * 获取用户UUID
	 * @return
	 */
	public static String getUUID(){
		
		return UUID.randomUUID().toString().toUpperCase();
	}
	

	/**
	 * 哈希加密password
	 * @param hashAlgorithmName 哈希算法名称
	 * @param password 密码
	 * @param uuid 唯一识别码
	 * @param hashIterations 哈希迭代次数
	 * @return
	 */
	public static String getEncrpytedPassword(String hashAlgorithmName, String password, String uuid, Integer hashIterations) {
		
		return new SimpleHash(hashAlgorithmName,password,uuid,hashIterations).toString().toUpperCase();
	}
	
	/**
	 * 获取项目路径
	 * @return
	 */ 
	public static String getPath(){
		
		return new CommonUtil().getClass().getResource("/").getPath().replaceAll("/WEB-INF/classes/", "");
	}
}
