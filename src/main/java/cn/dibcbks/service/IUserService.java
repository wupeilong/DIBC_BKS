package cn.dibcbks.service;



import java.util.Date;
import java.util.List;

import org.springframework.ui.ModelMap;

import cn.dibcbks.entity.Hygiene;
import cn.dibcbks.entity.Unit;
import cn.dibcbks.entity.User;
import cn.dibcbks.util.ResponseResult;

/**
 * 用户业务接口
 * @author Administrator
 *
 */
public interface IUserService {

	User queryUser(String idCard);

	ResponseResult<Void> registeradd(String uuid,String idCard, String username, String password, String phone, String duty, Integer age,
			String unitName, String legalPerson, String businessLicenseCode, String businessLicense, String productionLicense, String unitAddress, String expirationDate, Integer unitType);

	ResponseResult<Void> login(String idCard, String password);

	ResponseResult<Void> allocateAccount(String uuid, String idCard, String username, String password, String phone, String duty, Integer age,String healthCertificateCode,String stratpath);

	ResponseResult<Void> updateUser(User user);
	ResponseResult<Void> updatePassword(User user);

	String userCenter(ModelMap modelMap);

	String allocateAccountPage();

	ResponseResult<Void> userIsExist(String idCard,String phone);

	ResponseResult<List<User>> queryUnitUser(Integer unitId, String unitName);

	String queryUnitUserDetail(ModelMap modelMap,String id);
	List<Unit> queryUnitUserDetail(Integer unitid);
	String queryUserPcenter(ModelMap modelMap,String id);

	String workmens(ModelMap modelMap);

	String workmensHealth(ModelMap modelMap,Integer userId);

	String workmensHealthDetal(ModelMap modelMap, Integer hygieneId);
	ResponseResult<Void> addHygiene(Hygiene hygiene);

	
}
