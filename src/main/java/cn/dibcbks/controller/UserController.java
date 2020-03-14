package cn.dibcbks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.dibcbks.entity.User;
import cn.dibcbks.service.IUserService;
import cn.dibcbks.util.ResponseResult;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService iUserService;
	
	/**
	 * 查询身份证号是否已注册
	 * @param idCard
	 * @return
	 */
	@RequestMapping("/idCardIsExist.do")
	private ResponseResult<Void> idCardIsExist(@RequestParam(value = "idCard",required = true) String idCard){
		
		return iUserService.idCardIsExist(idCard);
	}
	
	/**
	 * 查询用户名是否已注册
	 * @param idCard
	 * @return
	 */
	@RequestMapping("/usernameIsExist.do")
	private ResponseResult<Void> usernameIsExist(@RequestParam(value = "username",required = true) String username){
		
		return iUserService.usernameIsExist(username);
	}
	
	/**
	 * 用户进入分配账户页
	 * @return
	 */
	@RequestMapping("/allocateAccountPage.do")
	private String allocateAccountPage(){
		
		return iUserService.allocateAccountPage();
	}
	
	/**
	 * 企业管理员分配账号
	 * @param idCard 身份证号
	 * @param username 姓名
	 * @param passwword 密码
	 * @param duty 职务
	 * @param age 年龄
	 * @return
	 */
	@RequestMapping("/allocateAccount.do")
	@ResponseBody
	private ResponseResult<Void> allocateAccount(
			@RequestParam(value="idCard",required = true) String idCard,
			@RequestParam(value="username",required = true) String username, 
			@RequestParam(value="password",required = false) String password, 
			@RequestParam(value="duty",required = true) String duty,
			@RequestParam(value="age",required = true) Integer age ){
		
		return iUserService.allocateAccount(idCard,username,password,duty,age);
	}
	
	/**
	 * 修改用户信息
	 * @param user
	 * @return
	 */
	@RequestMapping("/updateUser.do")
	@ResponseBody
	private ResponseResult<Void> updateUser(User user){
		
		return iUserService.updateUser(user);
	}
	
	
	/**
	 * 进入个人中心页面
	 * @return
	 */
	@RequestMapping("/center.do")
	private String userCenter(){
		
		return iUserService.userCenter();
	}
}
