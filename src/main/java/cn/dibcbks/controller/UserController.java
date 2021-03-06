package cn.dibcbks.controller;


import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import cn.dibcbks.entity.Hygiene;
import cn.dibcbks.entity.User;
import cn.dibcbks.mapper.UserMapper;
import cn.dibcbks.service.IUserService;
import cn.dibcbks.util.CommonUtil;
import cn.dibcbks.util.Constants;
import cn.dibcbks.util.GetCommonUser;
import cn.dibcbks.util.ResponseResult;




@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private IUserService iUserService;
	
	
	/**
	 * 进入个人信息页
	 * @return
	 */
	@RequestMapping("/user_pcenter")
	public String userPcenter(ModelMap modelMap,String id){
		return iUserService.queryUserPcenter(modelMap, id);	
	}
	/**
	 * 进入从业人员信息列表页
	 * @return
	 */
	@RequestMapping("/workmens")
	public String workmens(ModelMap modelMap){	
		return iUserService.workmens(modelMap);
//		return "bks_wap/workmens";
	}
	/**
	 * 进入密码修改页
	 * @return
	 */
	@RequestMapping("/reset_password")
	public String resetPassword(ModelMap modelMap){			
		return "bks_wap/reset_password";
	}
	/**
	 *密码修改方法
	 * @return
	 */
	@PostMapping("/password_update")
	@ResponseBody
	public ResponseResult<Void> uploadPassword(String password,String oldpassword){
		System.out.println(password);
		System.out.println(oldpassword);
		String uuid=CommonUtil.getStessionUser().getUuid();
		String hashPassword = CommonUtil.getEncrpytedPassword(Constants.MD5, oldpassword, uuid, 1024);		
		if (CommonUtil.getStessionUser().getPassword().equals(hashPassword)) {
			String newPassword = CommonUtil.getEncrpytedPassword(Constants.MD5, password, uuid, 1024);
			if (newPassword.equals(hashPassword)) {
				return new ResponseResult<Void>(ResponseResult.ERROR,"新密码不能与原密码相同！");
			}else{
				User user=new User();
				user.setId(CommonUtil.getStessionUser().getId());
				user.setPassword(newPassword);
				return iUserService.updatePassword(user);
			}			
		}else{
			return new ResponseResult<Void>(ResponseResult.ERROR,"原密码输入有误！");
		}		
	}
	
	/**
	 * 进入从业人员信息添加页
	 * @return
	 */
	@RequestMapping("/workmens_add")
	public String workmensAdd(ModelMap modelMap){			
		return "bks_wap/workmens_add";
	}
	/**
	 * 分配员工账户
	 * @param file 文件名
	 * @param idCard 身份证号
	 * @return
	 */
	@PostMapping("/workmens_reg")
	@ResponseBody
	public ResponseResult<Void> uploadFiesle(@RequestParam(value="unimg",required=false)MultipartFile file,
			String duty,String username,String password, String phone, String idCard,Integer age,String healthCertificateCode){
		/*User user = userMapper.queryUser(idCard);
		if (user != null) {
			return new ResponseResult<>(ResponseResult.ERROR,"身份证号已存在！");
		}*/
		User user = userMapper.queryUserByPhone(phone);
		if (user != null) {
			return new ResponseResult<>(ResponseResult.ERROR,"手机号已存在！");
		}
		String uuid = CommonUtil.getUUID();
		GetCommonUser get=new GetCommonUser();
//		String stratpath=get.uoladimg(file,uuid);
//		if (stratpath == null) {
//			return new ResponseResult<Void>(ResponseResult.ERROR,"健康证上传异常,人员信息添加失败");
//		}else{
			return iUserService.allocateAccount(uuid,idCard, username, password, phone, duty, age,healthCertificateCode,null);			
//		}		
	}
	
	/**
	 * 进入从业人员信息详情页
	 * @return
	 *art=
	 */
	@RequestMapping("/workmens_detal")
	public String workmensDetal(ModelMap modelMap,String id){
		
		return iUserService.queryUnitUserDetail(modelMap,id);
	}

	
	/**
	 * 进入从业人员信息健康列表页
	 * @return
	 */
	@RequestMapping("/workmens_health")
	public String workmensHealth(ModelMap modelMap,Integer userId){
		return iUserService.workmensHealth(modelMap,userId);
		//return "bks_wap/workmens_health";
	}
	/**
	 * 进入从业人员信息健康信息添加页
	 * @return
	 */
	@RequestMapping("/workmens_health_add")
	public String workmensHealthAdd(){		
		return "bks_wap/workmens_health_add";
	}
	/**
	 * 新增健康信息
	 * @param modelMap
	 * @param hygieneId
	 * @return
	 */
	@RequestMapping("/workmens_health_regadd")
	@ResponseBody
	public ResponseResult<Void> addHygiene(@RequestParam(value="healthCodePhoto",required=false)MultipartFile file,
													Integer userId,String username,String dailyTime,Double celsius,
													String fever,String diarrhea,String woundsFester,String hygiene,
													String remark){
		ResponseResult<Void> responseResult=null;		
		GetCommonUser get=new GetCommonUser();
		String hygienepath=get.uoladimg(file,CommonUtil.getStessionUser().getUuid());
		if (hygienepath==null) {
			responseResult=new ResponseResult<Void>(ResponseResult.ERROR,"健康码上传异常,信息添加失败");
		}else{	
			Hygiene hygiene2=new Hygiene();
			hygiene2.setUserId(userId);
			hygiene2.setUsername(username);
			hygiene2.setDailyTime(dailyTime);
			hygiene2.setCelsius(celsius);
			hygiene2.setFever(fever);
			hygiene2.setDiarrhea(diarrhea);
			hygiene2.setWoundsFester(woundsFester);
			hygiene2.setHygiene(hygiene);
			hygiene2.setRemark(remark);
			hygiene2.setHealthCodePhoto(hygienepath);
			hygiene2.setUploadTime(new Date());
			responseResult=iUserService.addHygiene(hygiene2);						
		}		
		return responseResult;		
	}
	/**
	 * 进入从业人员信息健康信息添加页
	 * @return
	 */
	@RequestMapping("/workmens_health_detal")
	public String workmensHealthDetal(ModelMap modelMap,Integer hygieneId){
		return iUserService.workmensHealthDetal(modelMap,hygieneId);
		//return "bks_wap/workmens_health_detal";
	}
	/**
	 * 用户进入分配账户页(从业人员添加)
	 * @return
	 */
	@RequestMapping("/allocateAccountPage")
	public String allocateAccountPage(){
		
		return iUserService.allocateAccountPage();
	}
	
	
	
	/**
	 * 修改用户信息
	 * @param user
	 * @return
	 */
	@RequestMapping("/update")
	@ResponseBody
	public ResponseResult<Void> updateUser(
			@RequestParam(value="unimg",required=false)MultipartFile file,
			Integer id,	String duty,String username,
			String password,String phone,String idCard,
			Integer age,String healthCertificateCode,String healthCertificate){
		User user = new User();
		user.setId(id);
		user.setUsername(username);
		user.setPassword(password);
		user.setPhone(phone);
		user.setIdCard(idCard);
		user.setAge(age);
		user.setDuty(duty);
		user.setHealthCertificateCode(healthCertificateCode);		
		if(file != null){
			GetCommonUser get=new GetCommonUser();				
			if(healthCertificate != null || healthCertificate != ""){				
				get.deluoladimg(healthCertificate);
			}
			String stratpath = get.uoladimg(file,CommonUtil.getStessionUser().getUuid());
			if (stratpath == null) {
				return new ResponseResult<Void>(ResponseResult.ERROR,"健康证上传异常,人员信息添加失败");
			}else{
				user.setHealthCertificate(stratpath);
				return iUserService.updateUser(user);
			}		
		}else{
			return iUserService.updateUser(user);
		}
	}
	
	
	/**
	 * 进入个人中心修改页面
	 * @return
	 */
	@RequestMapping("/workmens_update")
	public String updateUserPage(ModelMap modelMap){
		User user = userMapper.queryUser(CommonUtil.getStessionUser().getIdCard());
		modelMap.addAttribute("userDetail", user);
		return "bks_wap/workmens_update";
	}
	
	
	/**
	 * 进入个人中心页面
	 * @return
	 */
	@RequestMapping("/center")
	public String userCenter(ModelMap modelMap){
		
		return iUserService.userCenter(modelMap);
	}
	
	
	/**
	 * 查询企业从业人员信息
	 * @param unitId
	 * @param unitName
	 * @return
	 */
	@RequestMapping("/unitUserList")
	@ResponseBody
	public ResponseResult<List<User>> queryUnitUser(Integer unitId,String unitName){
		
		return iUserService.queryUnitUser(unitId,unitName);
	}
	
	
}
