package cn.dibcbks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.dibcbks.service.IWorkbenchService;

/**
 * 工作台控制器
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/work")
public class WorkbenchController {
	@Autowired
	private IWorkbenchService iWorkbenchService;
	
	
	/**
	 * 进入工作台页面
	 * @return
	 */
	@RequestMapping("/workbench")
	public String workbench(ModelMap modelMap){
		
		return iWorkbenchService.workbench(modelMap);
	}
	
	/**
	 * 进入企业信息页面
	 * @return
	 */
	@RequestMapping("/unitInfo")
	public String unitInfo(ModelMap modelMap){
		
		return iWorkbenchService.unitInfo(modelMap);
	}
	
	/**
	 * 进入从业人员信息页面
	 * @return
	 */
	@RequestMapping("/practitioners")
	public String practitioners(ModelMap modelMap){
		
		return iWorkbenchService.practitioners(modelMap);
	}
	
	/**
	 * 进入采购报送页面
	 * @return
	 */
	@RequestMapping("/procurement")
	public String procurement(ModelMap modelMap){
		
		return iWorkbenchService.procurement(modelMap);
	}
	
	/**
	 * 进入加工制作检视页面
	 * @return
	 */
	@RequestMapping("/manufacturingInspection")
	public String manufacturingInspection(ModelMap modelMap){
		
		return iWorkbenchService.manufacturingInspection(modelMap);
	}
	
	/**
	 * 进入配送报备页面
	 * @return
	 */
	@RequestMapping("/distribution")
	public String distribution(ModelMap modelMap){
		
		return iWorkbenchService.distribution(modelMap);
	}
	
	/**
	 * 进入清洗消毒页面
	 * @return
	 */
	@RequestMapping("/disinfection")
	public String disinfection(ModelMap modelMap){
		
		return iWorkbenchService.disinfection(modelMap);
	}
	
	/**
	 * 进入监管采集页面
	 * @return
	 */
	@RequestMapping("/check")
	public String check (ModelMap modelMap){
		
		return iWorkbenchService.check(modelMap);
	}
	
	/**
	 * 进入检测报送页面
	 * @return
	 */
	@RequestMapping("/detection")
	public String detectionReport(ModelMap modelMap){
		
		return iWorkbenchService.detectionReport(modelMap);
	}
	
	/**
	 * 进入视频监控页面
	 * @return
	 */
	@RequestMapping("/videoSurveillance")
	public String videoSurveillance (ModelMap modelMap){
		
		return iWorkbenchService.videoSurveillance(modelMap);
	}
}
