package cn.dibcbks.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import cn.dibcbks.entity.User;
import cn.dibcbks.mapper.UserMapper;
import cn.dibcbks.service.IUserService;
import cn.dibcbks.util.CommonUtil;
import cn.dibcbks.util.Constants;
import cn.dibcbks.util.GetCommonUser;
import cn.dibcbks.util.ResponseResult;

/**
 * 登录控制器
 * @author Administrator
 *
 */
@Controller
public class LoginController {
	@Autowired
	private IUserService iUserService;
	@Autowired
	private UserMapper userMapper;
	
	/**
	 * 进入登录页
	 * @return
	 */
	@RequestMapping("/login")
	public String loginPage(){		
		return "bks_wap/login";
	}	
	/**
	 * 进入首页
	 * @return
	 */
	@RequestMapping("/home")
	public String Home(){		
		return "bks_wap/home";
	}
	
	/**
	 * 进入注册页
	 * @return
	 */
	@RequestMapping("/register")
	public String register(){
		return "bks_wap/register";
	}
	
	/**
	 * 查询用户名是否已注册
	 * @param idCard
	 * @return
	 */
	@RequestMapping("/is_exist")
	@ResponseBody
	public ResponseResult<Void> userIsExist(String idCard,String phone){
		
		return iUserService.userIsExist(idCard,phone);
	}

	/**
	 * 实现注册功能
	 * @param idCard 身份证号
	 * @param username 姓名
	 * @param password 密码
	 * @param duty 职务
	 * @param age 年龄
	 * @param unitName 单位名称
	 * @param legalPerson 法人名字
	 * @param businessLicenseCode 营业执照编码
	 * @param businessLicense 营业执照图片
	 * @param productionLicense 许可证图片
	 * @param unitAddress 单位地址
	 * @param expirationDate 过期时间
	 * @param unitType 单位类型
	 * @return
	 */
	@RequestMapping("/registeradd")
	@ResponseBody
	public ResponseResult<Void> registeradd(
			@RequestParam(value="idCard",required = true) String idCard,
			@RequestParam(value="username",required = true) String username,
			@RequestParam(value="password",required = true) String password,
			@RequestParam(value="phone",required = true) String phone,
			@RequestParam(value="duty",required = true) String duty,
			@RequestParam(value="age",required = true) Integer age, 
			@RequestParam(value="unitName",required = true) String unitName,			
			@RequestParam(value="businessLicenseCode",required = true) String businessLicenseCode,
			@RequestParam(value="businessLicense",required=false)MultipartFile file,
			@RequestParam(value="productionLicense",required=false)MultipartFile file1,				
			@RequestParam(value="unitAddress",required = true) String unitAddress,			
			@RequestParam(value="unitType",required = true) Integer unitType,
			@RequestParam(value="legalPerson",required = true) String legalPerson){
		ResponseResult<Void> responseResult = null;
		try {
			GetCommonUser get=new GetCommonUser();	
			String businessLicensepath=get.uoladimg(file,idCard);
			if (businessLicensepath==null) {
				responseResult=new ResponseResult<Void>(ResponseResult.ERROR,"营业执照上传异常,人员信息添加失败");
			}else{
				String productionLicensepath=get.uoladimg(file1,idCard);
				if (productionLicensepath==null) {
					responseResult=new ResponseResult<Void>(ResponseResult.ERROR,"许可证上传异常,人员信息添加失败");
				}else{
					responseResult=iUserService.registeradd(idCard,username,password,phone,duty,age,unitName,legalPerson,businessLicenseCode,businessLicensepath,productionLicensepath,unitAddress,null,unitType);
				}			
			}
		}catch (Exception e) {
			e.printStackTrace();
			responseResult = new ResponseResult<>(ResponseResult.ERROR,"账户信息重复，注册失败");
		}
		return responseResult;
	
	}
	
	/**
	 * 实现用户登录
	 * @param idCard
	 * @param password
	 * @return
	 */
	@RequestMapping("/userLogin")
	@ResponseBody
	public ResponseResult<Void> login(@RequestParam(value="idCard",required = true) String idCard,
									  @RequestParam(value="password",required = true) String password){
		
		return iUserService.login(idCard,password);
	}
	
	/**
	 * 错误登录页
	 * @return
	 */
	@RequestMapping("/error")
	public String error(){		
		return "error/404";
	}
	
	
	/**
	 * 进入登录页
	 * @return
	 */
	@RequestMapping("/admin_login")
	public String adminlogin(){		
		return "bks_wap/admin_login";
	}
	
	/**
	 * 监管人员注册
	 */
	@RequestMapping("/admin_add")
	@ResponseBody
	public ResponseResult<Void> adminAdd(User user){
		System.out.println(user);
		ResponseResult<Void> rr = null;
		try {
			User queryUser = userMapper.queryUser(user.getIdCard());
			if (queryUser != null ) {
				rr = new ResponseResult<Void>(ResponseResult.ERROR, "身份证已存在！");
			}else if(userMapper.queryUserByPhone(user.getPhone()) != null){
				rr =  new ResponseResult<Void>(ResponseResult.ERROR,"手机号重复！");
			}else{
				List<User> list = userMapper.select(" u.username = '" + user.getUsername() + "'", null, null,null);
				if (!list.isEmpty()) {
					rr =  new ResponseResult<Void>(ResponseResult.ERROR,"手机号重复！");
				}else{
					String uuid = CommonUtil.getUUID();
					String password = user.getPassword() == null ? Constants.INITIAL_PASSWORD : user.getPassword();
			 		String hashPassword = CommonUtil.getEncrpytedPassword(Constants.MD5, password, uuid, 1024);
			 		user.setUuid(uuid);
					user.setPassword(hashPassword);
					user.setParentId(0);//父级ID
					user.setType(1);//用户类型
					user.setUnitId(1);
					userMapper.insert(user);
					rr =  new ResponseResult<Void>(ResponseResult.SUCCESS,"企业账户分配成功!");
				}				
			}
						
		} catch (Exception e) {			
			rr =  new ResponseResult<Void>(ResponseResult.ERROR, "操作失败！");
		}
		return rr;		
			
	}
	
}
