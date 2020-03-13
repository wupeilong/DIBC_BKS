package cn.dibcbks.service.impl;

import java.util.Date;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.dibcbks.entity.Unit;
import cn.dibcbks.entity.User;
import cn.dibcbks.mapper.UnitMapper;
import cn.dibcbks.mapper.UserMapper;
import cn.dibcbks.service.IUserService;
import cn.dibcbks.util.CommonUtil;
import cn.dibcbks.util.Constants;
import cn.dibcbks.util.ResponseResult;

/**
 * 用户业务实现类
 * @author Administrator
 *
 */
@Service
public class IUserServiceImpl implements IUserService {
	private static final Logger logger = LogManager.getLogger(IUserServiceImpl.class.getName());
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UnitMapper unitMapper;
	
	
	@Override
	public User queryUser(String idCard) {
		User user = null;
		try {
			user = userMapper.queryUser(idCard);
			logger.info(Constants.SUCCESSU_HEAD_INFO + "用户查询成功");
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(Constants.ERROR_HEAD_INFO + "用户查询失败");
		}
		return user;
	}

	@Override
	public ResponseResult<Void> registeradd(String idCard, String username, String password, String duty,
			Integer age, String unitName, String legalPerson, String businessLicenseCode, String businessLicense,
			String productionLicense, String unitAddress, Date expirationDate, Integer unitType) {
		ResponseResult<Void> rr = null;
		try {
			Unit queryUnit = unitMapper.queryUnit(businessLicenseCode);
			if(queryUnit != null){
				rr = new ResponseResult<>(ResponseResult.ERROR,"企业账户信息已存在");
				logger.error(Constants.ERROR_HEAD_INFO + "用户注册失败  原因：企业信息已存在");
			}else{
				Unit unit = new Unit();
				unit.setUnitName(unitName);
				unit.setLegalPerson(legalPerson);
				unit.setBusinessLicenseCode(businessLicenseCode);
				unit.setBusinessLicense(businessLicense);
				unit.setProductionLicense(productionLicense);
				unit.setUnitAddress(unitAddress);
				unit.setExpirationDate(expirationDate);
				unit.setUnitType(unitType);
				unitMapper.insert(unit);
				String uuid = CommonUtil.getUUID();
				String hashPassword = CommonUtil.getEncrpytedPassword(Constants.MD5, password, uuid, 1024);
				User user = new User();
				user.setIdCard(idCard);
				user.setUsername(username);
				user.setUuid(uuid);
				user.setPassword(hashPassword);
				user.setDuty(duty);
				user.setAge(age);
				user.setParentId(0);//父级ID: 默认 0
				user.setType(2);//用户类型：1-监管 2-企业
				user.setUnitId(unit.getUniId());
				userMapper.insert(user);
				rr = new ResponseResult<>(ResponseResult.SUCCESS,"企业账户信息注册成功!");
				logger.info(Constants.SUCCESSU_HEAD_INFO + "用户注册成功");
			}			
		} catch (Exception e) {
			e.printStackTrace();
			rr = new ResponseResult<>(ResponseResult.ERROR,"企业账户信息注册失败");
			logger.error(Constants.ERROR_HEAD_INFO + "用户注册失败 原因：" + e.getMessage());
		}
		return rr;
	}

	@Override
	public ResponseResult<Void> userIsExist(String idCard) {
		ResponseResult<Void> rr = null;
		try {
			User user = queryUser(idCard);
			if(user != null){
				rr = new ResponseResult<>(ResponseResult.SUCCESS,"YES");
			}else {
				rr = new ResponseResult<>(ResponseResult.SUCCESS,"NO");
			}
			logger.info(Constants.SUCCESSU_HEAD_INFO + "用户是否存在查询成功");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(Constants.ERROR_HEAD_INFO + "用户是否存在查询失败");
			rr = new ResponseResult<>(ResponseResult.ERROR,"ERROR");
		}
		return rr;
	}

}
