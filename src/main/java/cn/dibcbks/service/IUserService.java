package cn.dibcbks.service;

import java.util.Date;
import cn.dibcbks.entity.User;
import cn.dibcbks.util.ResponseResult;

/**
 * 用户业务接口
 * @author Administrator
 *
 */
public interface IUserService {

	User queryUser(String idCard);

	ResponseResult<Void> registeradd(String idCard, String username, String password, String duty, Integer age,
			String unitName, String legalPerson, String businessLicenseCode, String businessLicense, String productionLicense, String unitAddress, Date expirationDate, Integer unitType);

	ResponseResult<Void> idCardIsExist(String idCard);

	ResponseResult<Void> login(String idCard, String password);

	ResponseResult<Void> allocateAccount(String idCard, String username, String password, String duty, Integer age);

	ResponseResult<Void> updateUser(User user);

	String userCenter();

	ResponseResult<Void> usernameIsExist(String username);

	
}
