package cn.dibcbks.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
	 * 进入企业信息页
	 * @return
	 */
	@RequestMapping("/user_ccenter")
	public String userCcenter(){
		return "bks_wap/user_ccenter";
	}
	/**
	 * 进入个人信息页
	 * @return
	 */
	@RequestMapping("/user_pcenter")
	public String userPcenter(){
		return "bks_wap/user_pcenter";
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
	 * 进入从业人员信息添加页
	 * @return
	 */
	@RequestMapping("/workmens_add")
	public String workmensAdd(){		
		return "bks_wap/workmens_add";
	}
	
	/**
	 * 进入从业人员信息详情页
	 * @return
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
	public String workmensHealth(){		
		return "bks_wap/workmens_health";
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
	 * 进入从业人员信息健康信息添加页
	 * @return
	 */
	@RequestMapping("/workmens_health_detal")
	public String workmensHealthDetal(){		
		return "bks_wap/workmens_health_detal";
	}
	/**
	 * 用户进入分配账户页(从业人员添加)
	 * @return
	 */
	@RequestMapping("/allocateAccountPage")
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
	@RequestMapping("/allocateAccount")
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
	@RequestMapping("/updateUser")
	@ResponseBody
	private ResponseResult<Void> updateUser(User user){
		
		return iUserService.updateUser(user);
	}
	
	
	/**
	 * 进入个人中心页面
	 * @return
	 */
	@RequestMapping("/center")
	private String userCenter(ModelMap modelMap){
		
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
	private ResponseResult<List<User>> queryUnitUser(String unitId,String unitName){
		
		return iUserService.queryUnitUser(unitId,unitName);
	}
	
	
}
