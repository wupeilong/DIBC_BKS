package cn.dibcbks.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
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
import net.sf.json.JSONObject;

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
				logger.error(Constants.ERROR_HEAD_INFO + "用户注册失败  原因：企业信息已存在");
				return new ResponseResult<>(ResponseResult.ERROR,"企业账户信息已存在");
			}
			List<Unit> list = unitMapper.select(" n.unit_name = '" + unitName + "'", null, null, null);
			if (!list.isEmpty()) {
				logger.error(Constants.ERROR_HEAD_INFO + "用户注册失败  原因：企业信息已存在");
				return new ResponseResult<>(ResponseResult.ERROR,"企业账户信息已存在");
			}
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
			logger.info(Constants.SUCCESSU_HEAD_INFO + "用户注册成功");
			return new ResponseResult<>(ResponseResult.SUCCESS,"企业账户信息注册成功!");		
		}catch (Exception e) {
			e.printStackTrace();
			logger.error(Constants.ERROR_HEAD_INFO + "用户注册失败 原因：" + e.getMessage());
			return new ResponseResult<>(ResponseResult.ERROR,"企业账户信息注册失败");
		}
	}

	@Override
	public ResponseResult<Void> idCardIsExist(String idCard) {
		ResponseResult<Void> rr = null;
		try {
			User user = queryUser(idCard);
			if(user != null){
				rr = new ResponseResult<>(ResponseResult.SUCCESS,"1");
			}else {
				rr = new ResponseResult<>(ResponseResult.SUCCESS,"0");
			}
			logger.info(Constants.SUCCESSU_HEAD_INFO + "用户是否存在查询成功");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(Constants.ERROR_HEAD_INFO + "用户是否存在查询失败");
			rr = new ResponseResult<>(ResponseResult.ERROR,"ERROR");
		}
		return rr;
	}

	@Override
	public ResponseResult<Void> login(String idCard, String password) {
		ResponseResult<Void> rr = null;
		try {
			Subject subject = SecurityUtils.getSubject();
			User user = userMapper.queryUser(idCard);
			if (user == null) {
				rr = new ResponseResult<Void>(ResponseResult.ERROR, "账户信息不存在！请重新输入...");
				logger.error(Constants.ERROR_HEAD_INFO + "账户信息不存在 ，账号：" + idCard);
			} else {
				System.err.println("password:" + password);
				UsernamePasswordToken token = new UsernamePasswordToken(idCard, password);
				subject.login(token);
				Session session = subject.getSession();
				JSONObject userJson = JSONObject.fromObject(user);
				session.setAttribute("userJson", userJson);
				session.setAttribute("user", user);
				rr = new ResponseResult<Void>(ResponseResult.SUCCESS, "登录成功");
				logger.info(Constants.SUCCESSU_HEAD_INFO + "账号登录成功，账号：" + idCard);
			}
		}catch(IncorrectCredentialsException e){
			e.printStackTrace();
			rr = new ResponseResult<>(ResponseResult.ERROR,"密码错误！请重新输入...");
			logger.error(Constants.ERROR_HEAD_INFO + "用户注册失败 原因：" + e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			rr = new ResponseResult<Void>(ResponseResult.ERROR, "数据存在异常，请联系工作人员处理！");
			logger.error(Constants.ERROR_HEAD_INFO + "账户登录失败，原因： " + e.getMessage());
		}
		return rr;
	}

	@Override
	public ResponseResult<Void> allocateAccount(String idCard, String username, String password, String duty,
			Integer age) {
		ResponseResult<Void> rr = null;
		try {
			User queryUser = queryUser(idCard);
			if (queryUser != null ) {
				logger.error(Constants.ERROR_HEAD_INFO + "用户资料修改失败，原因：身份证已存在！");
				return new ResponseResult<>(ResponseResult.ERROR, "身份证已存在！");
			}
			Subject subject = SecurityUtils.getSubject();
			if(subject.isAuthenticated()){
				Session session = subject.getSession();
				User currentUser = (User)session.getAttribute("user");
				if(!currentUser.getParentId().equals(0)){
					rr = new ResponseResult<Void>(ResponseResult.ERROR, "该账户不是管理员，不能分配账户！");
					logger.error(Constants.ERROR_HEAD_INFO + "分配账号失败， 原因：该账户不是管理员账户");
				}else {
					String uuid = CommonUtil.getUUID();
					password = password == null ? Constants.INITIAL_PASSWORD : password;
	 				String hashPassword = CommonUtil.getEncrpytedPassword(Constants.MD5, password, uuid, 1024);
					User user = new User();
					user.setIdCard(idCard);
					user.setUsername(username);
					user.setUuid(uuid);
					user.setPassword(hashPassword);
					user.setDuty(duty);
					user.setAge(age);
					user.setParentId(currentUser.getId());//父级ID
					user.setType(currentUser.getType());//用户类型
					user.setUnitId(currentUser.getUnitId());
					userMapper.insert(user);
					rr = new ResponseResult<>(ResponseResult.SUCCESS,"企业账户分配成功!");
					logger.info(Constants.SUCCESSU_HEAD_INFO + "企业账户分配成功");
				}				
			}else{
				rr = new ResponseResult<Void>(ResponseResult.ERROR, "请操作后在请此操作！");
				logger.error(Constants.ERROR_HEAD_INFO + "分配账号失败， 原因：未登录账户");
			}
		} catch (Exception e) {
			e.printStackTrace();
			rr = new ResponseResult<Void>(ResponseResult.ERROR, "操作失败！");
			logger.error(Constants.ERROR_HEAD_INFO + "分配账号失败，原因：" + e.getMessage());
		}		
		return rr;
	}

	@Override
	public ResponseResult<Void> updateUser(User user) {
		ResponseResult<Void> rr = null;
		try {
			User oldUser = (User)SecurityUtils.getSubject().getSession().getAttribute("user");
			user.setId(oldUser.getId());
			if(StringUtils.isNotEmpty(user.getIdCard())){
				User queryUser = queryUser(user.getIdCard());
				if (queryUser != null && !oldUser.getIdCard().equals(queryUser.getIdCard())) {
					logger.error(Constants.ERROR_HEAD_INFO + "用户资料修改失败，原因：身份证已存在！");
					return new ResponseResult<>(ResponseResult.ERROR, "身份证已存在！");
				}
			}
			if(StringUtils.isNotEmpty(user.getPassword())){
				user.setPassword(CommonUtil.getEncrpytedPassword(Constants.MD5, user.getPassword(), user.getUuid(), 1024));
			}
			userMapper.updateById(user);
			rr = new ResponseResult<>(ResponseResult.SUCCESS,"操作成功");
			logger.info(Constants.SUCCESSU_HEAD_INFO + "用户资料修改成功！");
		} catch (Exception e) {
			e.printStackTrace();
			rr = new ResponseResult<Void>(ResponseResult.ERROR, "用户资料修改操作失败！");
			logger.error(Constants.ERROR_HEAD_INFO + "用户资料修改失败，原因：" + e.getMessage());
		}
		return rr;
	}

	

	@Override
	public String userCenter() {
		try {
			logger.info(Constants.SUCCESSU_HEAD_INFO + "用户进入个人中心页面成功！");
			//TODO 个人中心页面
			return "";
		} catch (Exception e) {
			logger.error(Constants.ERROR_HEAD_INFO + "用户进个人中心页面失败，原因：" + e.getMessage());
		}
		return "error/404";
	}

	@Override
	public ResponseResult<Void> usernameIsExist(String username) {
		ResponseResult<Void> rr = null;
		try {
			List<User> userList = userMapper.select(" u.username = '" + username + "'", null, null, null);
			if(!userList.isEmpty()){
				rr = new ResponseResult<>(ResponseResult.SUCCESS,"1");
			}else {
				rr = new ResponseResult<>(ResponseResult.SUCCESS,"0");
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
