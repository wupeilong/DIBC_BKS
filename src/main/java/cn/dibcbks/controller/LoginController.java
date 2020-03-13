package cn.dibcbks.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
	@RequestMapping("/index.do")
	public String loginIndex(){
		//TODO 更换登录页 
		return "index";
	}
	
	/**
	 * 进入注册页
	 * @return
	 */
	@RequestMapping("/register.do")
	public String register(){
		return "register";
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
	@RequestMapping("/registeradd.do")
	@ResponseBody
	public ResponseResult<Void> registeradd(String idCard, String username, String password, String duty, Integer age, 
			String unitName, String legalPerson, String businessLicenseCode, String businessLicense, String productionLicense, String unitAddress,@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8") Date expirationDate, Integer unitType){
		
		return iUserService.registeradd(idCard,username,password,duty,age,unitName,legalPerson,businessLicenseCode,businessLicense,productionLicense,unitAddress,expirationDate,unitType);
	}
}
