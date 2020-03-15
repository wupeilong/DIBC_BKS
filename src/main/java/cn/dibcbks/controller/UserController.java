package cn.dibcbks.controller;

import java.io.File;
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
import cn.dibcbks.entity.User;
import cn.dibcbks.service.IUserService;
import cn.dibcbks.util.GetCommonUser;
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
	public String workmensAdd(ModelMap modelMap){			
		return "bks_wap/workmens_add";
	}
	
	/**
	 * 文件上传
	 * @param file 文件名
	 * @param idCard 身份证号
	 * @return
	 */
	@PostMapping("/workmens_reg")
	@ResponseBody
	public ResponseResult<Void> uploadFiesle(@RequestParam(value="unimg",required=false)MultipartFile file,
			String duty,String username,String idCard,Integer age,String healthCertificateCode){
		ResponseResult<Void> responseResult=null;		
		GetCommonUser get=new GetCommonUser();
		String stratpath=get.uoladimg(file,idCard,healthCertificateCode);
		if (stratpath==null) {
			responseResult=new ResponseResult<Void>(ResponseResult.ERROR,"健康证上传异常,人员信息添加失败");
		}else{
			responseResult=iUserService.allocateAccount(idCard, username, null, duty, age,healthCertificateCode,stratpath);			
		}		
		return responseResult;
	}
	
	/**
	 * 进入从业人员信息详情页
	 * @return
	 *art=
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
	@RequestMapping("/updateUser")
	@ResponseBody
	public ResponseResult<Void> updateUser(User user){
		
		return iUserService.updateUser(user);
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
