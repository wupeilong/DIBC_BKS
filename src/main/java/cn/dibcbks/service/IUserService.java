package cn.dibcbks.service;

import java.util.Date;
import java.util.List;

import org.springframework.ui.ModelMap;

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

	ResponseResult<Void> login(String idCard, String password);

	ResponseResult<Void> allocateAccount(String idCard, String username, String password, String duty, Integer age);

	ResponseResult<Void> updateUser(User user);

	String userCenter(ModelMap modelMap);

	String allocateAccountPage();

	ResponseResult<Void> userIsExist(String username, String idCard);

	ResponseResult<List<User>> queryUnitUser(Integer unitId, String unitName);

	String queryUnitUserDetail(ModelMap modelMap,String id);

	String workmens(ModelMap modelMap);

	
}
