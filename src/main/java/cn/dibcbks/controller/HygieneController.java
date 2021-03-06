package cn.dibcbks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.dibcbks.entity.Hygiene;
import cn.dibcbks.service.IHygieneService;
import cn.dibcbks.util.ResponseResult;

@Controller
@RequestMapping("/hygiene")
public class HygieneController {
	@Autowired
	private IHygieneService iHygieneService;
	
	/**
	 * 查看用户健康信息列表
	 * @param modelMap
	 * @param userId
	 * @return
	 */
	@RequestMapping("/list")
	public String queryhygieneList(ModelMap modelMap,String userId){
		
		return iHygieneService.queryhygieneList(modelMap,userId);
	}
	
	/**
	 * 查看用户健康信息详情
	 * @param modelMap
	 * @param hygieneId
	 * @return
	 */
	@RequestMapping("/detail")
	public String queryhygieneDetail(ModelMap modelMap,Integer hygieneId){
		
		return iHygieneService.queryhygieneDetail(modelMap,hygieneId);
	}
	
	
	
	/**
	 * 新增健康信息
	 * @param modelMap
	 * @param hygieneId
	 * @return
	 */
	@RequestMapping("/add")
	@ResponseBody
	public ResponseResult<Void> addHygiene(Hygiene hygiene){
		
		return iHygieneService.addHygiene(hygiene);
	}
	
}
