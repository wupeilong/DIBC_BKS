package cn.dibcbks.service.impl;

import java.util.ArrayList;
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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import cn.dibcbks.entity.Hygiene;
import cn.dibcbks.entity.Unit;
import cn.dibcbks.entity.User;
import cn.dibcbks.mapper.HygieneMapper;
import cn.dibcbks.mapper.UnitMapper;
import cn.dibcbks.mapper.UserMapper;
import cn.dibcbks.service.IUserService;
import cn.dibcbks.util.CommonUtil;
import cn.dibcbks.util.Constants;
import cn.dibcbks.util.GetCommonUser;
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
	@Autowired
	private HygieneMapper hygieneMapper;
	
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
	@Transactional(rollbackFor=Exception.class)
	public ResponseResult<Void> registeradd(String idCard, String username, String password, String phone, String duty,
			Integer age, String unitName, String legalPerson, String businessLicenseCode, String businessLicense,
			String productionLicense, String unitAddress, String expirationDate, Integer unitType) {
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
			user.setPhone(phone);
			user.setDuty(duty);
			user.setAge(age);
			user.setParentId(0);//父级ID: 默认 0
			user.setType(2);//用户类型：1-监管 2-企业
			user.setUnitId(unit.getUnitId());
			userMapper.insert(user);
			logger.info(Constants.SUCCESSU_HEAD_INFO + "用户注册成功");
			return new ResponseResult<>(ResponseResult.SUCCESS,"企业账户信息注册成功!");		
	}


	@Override
	public ResponseResult<Void> login(String idCard, String password) {
		ResponseResult<Void> rr = null;
		try {
			System.out.println("用户：" + idCard + " " + password);
			Subject subject = SecurityUtils.getSubject();
			User user = userMapper.queryUser(idCard);
			if(user == null){
				user = userMapper.queryUserByPhone(idCard);
			}
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
			rr = new ResponseResult<>(ResponseResult.ERROR,"密码错误！请重新输入...");
			logger.error(Constants.ERROR_HEAD_INFO + "用户注册失败 原因：" + e.getMessage());
		} catch (Exception e) {			
			rr = new ResponseResult<Void>(ResponseResult.ERROR, "数据存在异常，请联系工作人员处理！");
			logger.error(Constants.ERROR_HEAD_INFO + "账户登录失败，原因： " + e.getMessage());
		}
		return rr;
	}

	@Override
	public ResponseResult<Void> allocateAccount(String idCard, String username, String password, String phone, String duty,
			Integer age,String healthCertificateCode,String stratpath) {
		ResponseResult<Void> rr = null;
		GetCommonUser get = new GetCommonUser();
		try {
			Subject subject = SecurityUtils.getSubject();
			if(subject.isAuthenticated()){
				Session session = subject.getSession();
				User currentUser = (User)session.getAttribute("user");
				if(!currentUser.getParentId().equals(0)){
					get.deluoladimg(stratpath);
					rr = new ResponseResult<Void>(ResponseResult.ERROR, "该账户不是管理员，不能分配账户！");
					logger.error(Constants.ERROR_HEAD_INFO + "分配账号失败， 原因：该账户不是管理员账户");
				}else {
					String uuid = CommonUtil.getUUID();
					password = password == null ? Constants.INITIAL_PASSWORD : password;
	 				String hashPassword = CommonUtil.getEncrpytedPassword(Constants.MD5, password, uuid, 1024);
					User user = new User();
					user.setIdCard(idCard);
					user.setUsername(username);
					user.setPhone(phone);
					user.setUuid(uuid);
					user.setPassword(hashPassword);
					user.setDuty(duty);
					user.setAge(age);
					user.setParentId(currentUser.getId());//父级ID
					user.setType(currentUser.getType());//用户类型
					user.setUnitId(currentUser.getUnitId());
					user.setHealthCertificateCode(healthCertificateCode);
					user.setHealthCertificate(stratpath);
					userMapper.insert(user);
					rr = new ResponseResult<>(ResponseResult.SUCCESS,"企业账户分配成功!");
					logger.info(Constants.SUCCESSU_HEAD_INFO + "企业账户分配成功");
				}				
			}else{
				get.deluoladimg(stratpath);
				rr = new ResponseResult<Void>(ResponseResult.ERROR, "请操作后在请此操作！");
				logger.error(Constants.ERROR_HEAD_INFO + "分配账号失败， 原因：未登录账户");
			}
		} catch (Exception e) {
			get.deluoladimg(stratpath);
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
	public String userCenter(ModelMap modelMap) {
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
	public String allocateAccountPage() {
		try {
			logger.info(Constants.SUCCESSU_HEAD_INFO + "用户进入用户进入分配账户页成功！");
			//TODO 用户进入分配账户页
			return "";
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(Constants.ERROR_HEAD_INFO + "用户进入用户进入分配账户页失败，原因：" + e.getMessage());
		}
		return "error/404";
	}

	@Override
	public ResponseResult<Void> userIsExist(String idCard,String phone) {
		try {
			User user = userMapper.queryUser(idCard);
			System.out.println("id_card_user : " + user);
			if(user != null){
				return new ResponseResult<>(ResponseResult.ERROR,"身份证号已存在！");
			}
			List<User> list = userMapper.select(" u.phone = '" + phone + "'", null, null,null);
			System.out.println("phone_card_user : " + list);
			if (!list.isEmpty()) {
				System.out.println("走了这步...");
				return new ResponseResult<>(ResponseResult.ERROR,"手机号已存在！");
			}
			return new ResponseResult<>(ResponseResult.SUCCESS,"操作成功！");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(Constants.ERROR_HEAD_INFO + "用户是否存在查询失败");
			return new ResponseResult<>(ResponseResult.ERROR,"操作失败！");
		}
	}

	@Override
	public ResponseResult<List<User>> queryUnitUser(Integer unitId, String unitName) {
		ResponseResult<List<User>> rr = null;
		try {
			String where = "";
			if(unitId == null && StringUtils.isEmpty(unitName)){
				where = null;
			}
			boolean addAnd = false;
			if(unitId != null){
				where += " n.unit_id = '" + unitId + "'";
				addAnd =true;
			}
			if(StringUtils.isNotEmpty(unitName)){
				if (addAnd) {
					where += " AND n.unit_name = '" + unitName + "'";
				}else {
					where += " n.unit_name = '" + unitName + "'";
				}				
			}
			System.out.println( "where: "+where);
			List<User> list = userMapper.select(where, null, null, null);
			rr = new ResponseResult<>(ResponseResult.SUCCESS,"操作成功！",list);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
			rr = new ResponseResult<>(ResponseResult.ERROR,"操作失败！");
		}		
		return rr;
	}

	@Override
	public String queryUnitUserDetail(ModelMap modelMap,String id) {
		try {
			List<User> list = userMapper.select(" u.id = '" + id + "'", null, null, null);
			modelMap.addAttribute("userDetail", list.isEmpty() ? null : list.get(0));
			//TODO 用户信息详情页
			return "bks_wap/workmens_detal";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error/404";
	}

	@Override
	public String workmens(ModelMap modelMap) {
		Session session = SecurityUtils.getSubject().getSession();
		User user = (User)session.getAttribute("user");
		List<User> userList = new ArrayList<>();
		if(user.getType().equals(1)){//市场监管局账户
			List<Unit> unitList = unitMapper.select(" n.unit_type BETWEEN 2 AND 4 ", " n.create_time DESC", null, null);
			modelMap.addAttribute("unitList", unitList);
			userList = userMapper.select(null, " u.create_time DESC", null, null);
		}else {//企业用户
			userList = userMapper.select(" u.unit_id = '" + user.getUnitId() + "'", " u.create_time DESC", null, null);
		}
		modelMap.addAttribute("userList", userList);		
		logger.info(Constants.SUCCESSU_HEAD_INFO + "用户进入从业人员信息页面成功！");
		//TODO 从业人员信息页面
		return "bks_wap/workmens";
	}

	@Override
	public String workmensHealth(ModelMap modelMap,Integer userId) {
		List<Hygiene> hygieneList = hygieneMapper.select(" h.user_id = '" + userId + "'", " h.upload_time DESC", null, null);
		System.out.println(hygieneList);
		modelMap.addAttribute("hygieneList", hygieneList);
		return "bks_wap/workmens_health";
	}

	@Override
	public String workmensHealthDetal(ModelMap modelMap, Integer hygieneId) {
		Hygiene hygieneDetail = hygieneMapper.queryHygiene(hygieneId);
		System.out.println("体温信息详情：" + hygieneDetail);
		modelMap.addAttribute("hygieneDetail", hygieneDetail);
		return "bks_wap/workmens_health_detal";
	}

	@Override
	public String queryUserPcenter(ModelMap modelMap, String id) {
		try {
			List<User> list = userMapper.select(" u.id = '" + id + "'", null, null, null);
			modelMap.addAttribute("userPcenter", list.isEmpty() ? null : list.get(0));
			//TODO 用户信息详情页
			return "bks_wap/user_pcenter";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error/404";
	}	
	@Override
	public ResponseResult<Void> addHygiene(Hygiene hygiene) {
		ResponseResult<Void> rr = null;
		try {
			hygieneMapper.insert(hygiene);
			rr = new ResponseResult<>(ResponseResult.SUCCESS,"操作成功！");
		} catch (Exception e) {
			e.printStackTrace();
			rr = new ResponseResult<>(ResponseResult.ERROR,"操作失败！");
		}
		return rr;
	}

	@Override
	public List<Unit> queryUnitUserDetail(Integer unitid) {
		String where="unit_id="+unitid;
		return unitMapper.select(where, null, null, null);
	}
}
