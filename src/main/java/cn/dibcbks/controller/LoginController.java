package cn.dibcbks.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.fasterxml.jackson.annotation.JsonFormat;
import cn.dibcbks.service.IUserService;
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
	
	/**
	 * 进入首页
	 * @return
	 */
	@RequestMapping("/index")
	public String loginIndex(){
		//TODO 更换登录页 
		return "index";
	}
	
	/**
	 * 进入注册页
	 * @return
	 */
	@RequestMapping("/register")
	public String register(){
		return "register";
	}
	
	/**
	 * 查询用户名是否已注册
	 * @param idCard
	 * @return
	 */
	@RequestMapping("/IsExist")
	private ResponseResult<Void> userIsExist(String username,String idCard){
		
		return iUserService.userIsExist(username,idCard);
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
			@RequestParam(value="duty",required = true) String duty,
			@RequestParam(value="age",required = true) Integer age, 
			@RequestParam(value="unitName",required = true) String unitName,
			@RequestParam(value="legalPerson",required = true) String legalPerson,
			@RequestParam(value="businessLicenseCode",required = true) String businessLicenseCode,
			@RequestParam(value="businessLicense",required = true) String businessLicense,
			@RequestParam(value="productionLicense",required = true) String productionLicense,
			@RequestParam(value="unitAddress",required = true) String unitAddress,
			@RequestParam(value="expirationDate",required = true) @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8") Date expirationDate,
			@RequestParam(value="unitType",required = true) Integer unitType){
		
		return iUserService.registeradd(idCard,username,password,duty,age,unitName,legalPerson,businessLicenseCode,businessLicense,productionLicense,unitAddress,expirationDate,unitType);
	}
	
	/**
	 * 实现用户登录
	 * @param idCard
	 * @param password
	 * @return
	 */
	@RequestMapping("/login")
	@ResponseBody
	public ResponseResult<Void> login(@RequestParam(value="idCard",required = true) String idCard,
									  @RequestParam(value="password",required = true) String password){
		
		return iUserService.login(idCard,password);
	}
	

}
