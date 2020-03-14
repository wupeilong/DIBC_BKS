package cn.dibcbks.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.dibcbks.entity.Detection;
import cn.dibcbks.service.IDetectionService;
import cn.dibcbks.util.ResponseResult;

@RequestMapping("/detection")
@Controller
public class DetectionCtroller {
	@Autowired
	private IDetectionService iDetectionService;
	
	/**
	 * 查询多频次检查信息列表
	 * @param unitId
	 * @return
	 */
	@RequestMapping("/queryList.do")
	@ResponseBody()
	public ResponseResult<List<Detection>> queryDetectionList(ModelMap modelMap,Integer unitId){
		
		return iDetectionService.queryDetectionList(modelMap,unitId);
	}
	
	/**
	 * 进入多频检查信息页
	 * @return
	 */
	@RequestMapping("/addPage.do")
	public String addDetectionPage(ModelMap modelMap){
		
		return iDetectionService.addDetectionPage(modelMap);
	}
	

	/**
	 * 新增多频检查信息
	 * @param detection
	 * @return
	 */
	@RequestMapping("/add.do")
	@ResponseBody
	public ResponseResult<Void> addDetection(Detection detection){
		
		return iDetectionService.addDetection(detection);
	}
	
	/**
	 * 查看多频检查信息详情
	 * @param detection
	 * @return
	 */
	@RequestMapping("/detail.do")
	public String queryDetectionDetail(ModelMap modelMap,Integer id){
		
		return iDetectionService.queryDetectionDetail(modelMap,id);
	}
}
