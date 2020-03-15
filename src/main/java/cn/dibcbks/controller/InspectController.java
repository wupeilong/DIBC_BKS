package cn.dibcbks.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;

import cn.dibcbks.entity.Check;
import cn.dibcbks.entity.Unit;
import cn.dibcbks.entity.User;
import cn.dibcbks.service.ICheckService;
import cn.dibcbks.service.IUserService;
import cn.dibcbks.util.ResponseResult;

/**
 * 监管采集控制器
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/inspect")
public class InspectController {
	
	@Autowired
	private ICheckService iCheckService;
	@Autowired
	private IUserService iUserService;
	/**
	 * 进入监管采集选择页
	 * @return
	 */
	@RequestMapping("/inspect_choise")
	public String InspectChoise(){		
		return "bks_wap/inspect_choise";
	}
	/**
	 * 进入监管采集记录列表页
	 * @return
	 */
	@RequestMapping("/inspect_list")
	public String InspectList(ModelMap modelMap){		
		return iCheckService.getCheckList(modelMap);// "bks_wap/inspect_list";
	}
	/**
	 * 进入监管采集记录表添加页
	 * @return
	 */
	@RequestMapping("/inspect_add")
	public String InspectAdd(ModelMap map){	
		Integer unitid = ((User)SecurityUtils.getSubject().getSession().getAttribute("user")).getUnitId();
		List<Unit> queryUnitUserDetail = iUserService.queryUnitUserDetail(unitid);		
		map.addAttribute("unitlist", queryUnitUserDetail);
		return "bks_wap/inspect_add";
	}
	/**
	 * 进入监管采集检查表查询页
	 * @return
	 */
	@RequestMapping("/inspect_detal")
	public String InspectDetal(){		
		return "bks_wap/inspect_detal";
	}
	
	/**
	 * 查询检查信息列表
	 * @param unitId
	 * @param unitType
	 * @return
	 */
	@RequestMapping("/queryList")
	@ResponseBody
	public ResponseResult<List<Check>> queryCheckListInfo(String unitId,Integer unitType){
		
		return iCheckService.queryCheckListInfo(unitId,unitType);
	}
	
	/**
	 * 进入检查信息列表页
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("/list")
	public String checkhListInfo(ModelMap modelMap){
		
		return iCheckService.getCheckList(modelMap);
	}
	
	
	/**
	 * 检查信息详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/detail")
	public String checkDetailInfo(ModelMap modelMap,Integer id){
		
		return iCheckService.checkDetailInfo(modelMap,id);
	}
	
	
	/**
	 * 进入商家自检页面
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("/business")
	public String businessPage(ModelMap modelMap){
		
		return iCheckService.businessPage(modelMap);
	}
	
	/**
	 * 进入监管局专检页面
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("/supervise")
	public String supervisePage(ModelMap modelMap){
		
		return iCheckService.supervisePage(modelMap);
	}
	
	/**
	 * 进入督察队专检页面
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("/supervision")
	public String supervisionPage(ModelMap modelMap){
		
		return iCheckService.supervisionPage(modelMap);
	}
	
	
	/**
	 * 新增商家自检、监管局专检、督察组专检信息
	 * @param unitId 单位ID
	 * @param unitName 检查单位公司
	 * @param unitType 检查单位类型
	 * @param unitAddress 检查单位地址
	 * @param unitPrincipal 单位负责人
	 * @param unitPhone 联系电话
	 * @param resultList 检查结果集
	 * @param other 其他需要说明的情况
	 * @param inspectors 检查人员
	 * @param dailyTime 检查日期
	 * @param checkType 检查类型：1-单位自检 2-市监局专监 3-督查组检查
	 * @param checkPhoto 检查图片
	 * @return
	 */
	@RequestMapping("/inspect_regadd")
	@ResponseBody
	public ResponseResult<Void> addCheckInfo(@RequestParam(value="queryrights") String queryrights,Integer unitId,String unitType,String other,String unitPhone){
		List<Unit> queryUnit = iUserService.queryUnitUserDetail(unitId);
		String username = ((User)SecurityUtils.getSubject().getSession().getAttribute("user")).getUsername();
		String resultList=JSONArray.toJSONString(queryrights);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");        
		return  iCheckService.addCheckInfo(unitId,queryUnit.get(0).getUnitName(),unitType,queryUnit.get(0).getUnitAddress(),queryUnit.get(0).getLegalPerson(),unitPhone,resultList,other,username,sdf.format(new Date()),1,null);
	}
}
