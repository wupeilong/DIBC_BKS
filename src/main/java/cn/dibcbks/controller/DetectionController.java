package cn.dibcbks.controller;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.dibcbks.entity.Detection;
import cn.dibcbks.entity.Unit;
import cn.dibcbks.service.IDetectionService;
import cn.dibcbks.service.IUnitService;
import cn.dibcbks.util.CommonUtil;
import cn.dibcbks.util.GetCommonUser;
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
	@Autowired
	private IUnitService iUnitService;
	
	/**
	 * 进入多频检查记录列表页
	 * @return
	 */
	@RequestMapping("/detection_list")
	public String detectionList(ModelMap modelMap){	
		List<Detection> unitList=iDetectionService.addDetectionPage();
		List<Unit> unitListadd = iUnitService.CooprationList();
		modelMap.addAttribute("unitlistall", unitListadd);
		modelMap.addAttribute("unitList", unitList);		
		return "bks_wap/detection_list";
	}
	/**
	 * 进入多频检查记录表添加页
	 * @return
	 */
	@RequestMapping("/detection_add")
	public String detectionAdd(ModelMap map){	
		List<Unit> unitList = iUnitService.CooprationList();
		map.addAttribute("unitlistall", unitList);
		return "bks_wap/detection_add";
	}
	@RequestMapping("/detection_regadd")
	@ResponseBody
	public ResponseResult<Void> registeradd(
			@RequestParam(value="unitId",required = true) Integer unitId,
			@RequestParam(value="unitName",required = true) String unitName,
			@RequestParam(value="samplName",required = true) String samplName,
			@RequestParam(value="specifications",required = true) String specifications,
			@RequestParam(value="bath",required = true) String bath, 
			@RequestParam(value="item",required = true) String item,			
			@RequestParam(value="result",required = true) String result,
			@RequestParam(value="remark",required = true) String remark,
			@RequestParam(value="detectionPhoto",required=false)MultipartFile file){
		ResponseResult<Void> responseResult=null;		
		GetCommonUser get=new GetCommonUser();			
		String detectionpath=get.uoladimg(file,CommonUtil.getStessionUser().getUuid());
		if (detectionpath==null) {
			responseResult=new ResponseResult<Void>(ResponseResult.ERROR,"图片上传异常,人员信息添加失败");
		}else{
			Detection detection=new Detection();
			detection.setUserId(CommonUtil.getStessionUser().getId());
			detection.setUnitId(unitId);
			detection.setUnitName(unitName);
			detection.setSamplName(samplName);
			detection.setSpecifications(specifications);
			detection.setBath(bath);
			detection.setItem(item);
			detection.setResult(result);
			detection.setRemark(remark);
			detection.setDetectionPhoto(detectionpath);
			detection.setCreateTime(new Date());
			responseResult=iDetectionService.addDetection(detection);						
		}		
		return responseResult;

	}
	/**
	 * 进入多频检查检查表查询页
	 * @return
	 */
	@RequestMapping("/detection_detal")
	public String detectionDetal(ModelMap modelMap,Integer id){	
		return iDetectionService.queryDetectionDetail(modelMap,id);
		//return "bks_wap/detection_detal";
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
	 * 查看多频检查信息详情
	 * @param detection
	 * @return
	 */
	@RequestMapping("/detail")
	public String queryDetectionDetail(ModelMap modelMap,Integer id){
		
		return iDetectionService.queryDetectionDetail(modelMap,id);
	}


}
