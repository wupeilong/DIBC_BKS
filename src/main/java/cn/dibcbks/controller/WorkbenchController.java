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
	@RequestMapping("/workbench.do")
	private String workbench(ModelMap modelMap){
		
		return iWorkbenchService.workbench(modelMap);
	}
	
	/**
	 * 进入企业信息页面
	 * @return
	 */
	@RequestMapping("/unitInfo.do")
	private String unitInfo(ModelMap modelMap){
		
		return iWorkbenchService.unitInfo(modelMap);
	}
	
	/**
	 * 进入从业人员信息页面
	 * @return
	 */
	@RequestMapping("/practitioners.do")
	private String practitioners(ModelMap modelMap){
		
		return iWorkbenchService.practitioners(modelMap);
	}
	
	/**
	 * 进入采购报送页面
	 * @return
	 */
	@RequestMapping("/purchaseReport.do")
	private String purchaseReport(ModelMap modelMap){
		
		return iWorkbenchService.purchaseReport(modelMap);
	}
	
	/**
	 * 进入加工制作检视页面
	 * @return
	 */
	@RequestMapping("/manufacturingInspection.do")
	private String manufacturingInspection(ModelMap modelMap){
		
		return iWorkbenchService.manufacturingInspection(modelMap);
	}
	
	/**
	 * 进入配送报备页面
	 * @return
	 */
	@RequestMapping("/deliveryDistribution.do")
	private String deliveryDistribution(ModelMap modelMap){
		
		return iWorkbenchService.deliveryDistribution(modelMap);
	}
	
	/**
	 * 进入清洗消毒页面
	 * @return
	 */
	@RequestMapping("/cleaningDisinfection.do")
	private String cleaningDisinfection(ModelMap modelMap){
		
		return iWorkbenchService.cleaningDisinfection(modelMap);
	}
	
	/**
	 * 进入监管采集页面
	 * @return
	 */
	@RequestMapping("/regulatory.do")
	private String regulatory (ModelMap modelMap){
		
		return iWorkbenchService.regulatory(modelMap);
	}
	
	/**
	 * 进入检查报送页面
	 * @return
	 */
	@RequestMapping("/inspectionReport.do")
	private String inspectionReport (ModelMap modelMap){
		
		return iWorkbenchService.inspectionReport(modelMap);
	}
	
	/**
	 * 进入视频监控页面
	 * @return
	 */
	@RequestMapping("/videoSurveillance.do")
	private String videoSurveillance (ModelMap modelMap){
		
		return iWorkbenchService.videoSurveillance(modelMap);
	}
}
