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


/**
 * 多频检查控制器
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/detection")
public class DetectionController {
	
	
	@Autowired
	private IDetectionService iDetectionService;
	
	/**
	 * 进入多频检查记录列表页
	 * @return
	 */
	@RequestMapping("/detection_list")
	public String detectionList(){		
		return "bks_wap/detection_list";
	}
	/**
	 * 进入多频检查记录表添加页
	 * @return
	 */
	@RequestMapping("/detection_add")
	public String detectionAdd(){		
		return "bks_wap/detection_add";
	}
	/**
	 * 进入多频检查检查表查询页
	 * @return
	 */
	@RequestMapping("/detection_detal")
	public String detectionDetal(){		
		return "bks_wap/detection_detal";
	}
	
	
	
	/**
	 * 查询多频次检查信息列表
	 * @param unitId
	 * @return
	 */
	@RequestMapping("/queryList")
	@ResponseBody()
	public ResponseResult<List<Detection>> queryDetectionList(ModelMap modelMap,Integer unitId){
		
		return iDetectionService.queryDetectionList(modelMap,unitId);
	}
	
	/**
	 * 进入多频检查信息页
	 * @return
	 */
	@RequestMapping("/addPage")
	public String addDetectionPage(ModelMap modelMap){
		
		return iDetectionService.addDetectionPage(modelMap);
	}
	

	/**
	 * 新增多频检查信息
	 * @param detection
	 * @return
	 */
	@RequestMapping("/add")
	@ResponseBody
	public ResponseResult<Void> addDetection(Detection detection){
		
		return iDetectionService.addDetection(detection);
	}
	
	/**
	 * 查看多频检查信息详情
	 * @param detection
	 * @return
	 */
	@RequestMapping("/detail")
	public String queryDetectionDetail(ModelMap modelMap,Integer id){
		
		return iDetectionService.queryDetectionDetail(modelMap,id);
	}


}
