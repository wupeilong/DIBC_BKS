package cn.dibcbks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.dibcbks.entity.Check;
import cn.dibcbks.service.ICheckService;
import cn.dibcbks.util.ResponseResult;

/**
 * 监管采集控制器
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/check")
public class CheckController {
	@Autowired
	private ICheckService iCheckService;
	
	/**
	 * 检查信息列表
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("/list.do")
	public String ceckhListInfo(ModelMap modelMap){
		
		return iCheckService.getCheckList(modelMap);
	}
	
	
	/**
	 * 检查信息详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/detail.do")
	@ResponseBody
	public ResponseResult<Void> checkDetailInfo(Integer id){
		
		return iCheckService.checkDetailInfo(id);
	}	
	
	
	/**
	 * 进入商家自检页面
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("/businessPage.do")
	public String businessPage(ModelMap modelMap){
		
		return iCheckService.businessPage(modelMap);
	}
	
	/**
	 * 进入监管局专检页面
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("/supervise.do")
	public String supervisePage(ModelMap modelMap){
		
		return iCheckService.supervisePage(modelMap);
	}
	
	/**
	 * 进入督察队专检页面
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("/supervision.do")
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
	@RequestMapping("/add.do")
	@ResponseBody
	public ResponseResult<Void> addCheckInfo(Integer unitId,String unitName,String unitType,String unitAddress,
			String unitPrincipal,String unitPhone,List<Integer> resultList,String other,String inspectors,
			String dailyTime,Integer checkType,String checkPhoto){
		
		return iCheckService.addCheckInfo(unitId,unitName,unitType,unitAddress,unitPrincipal,unitPhone,resultList,other,inspectors,dailyTime,checkType,checkPhoto);
	}

}
