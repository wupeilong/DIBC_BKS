package cn.dibcbks.service;

import cn.dibcbks.entity.User;

/**
 * 用户业务接口
 * @author Administrator
 *
 */
public interface IUserService {

	User queryUser(String phone);
	
}
