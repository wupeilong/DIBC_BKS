package cn.dibcbks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.dibcbks.entity.Procurement;
import cn.dibcbks.service.IProcurementService;
import cn.dibcbks.util.ResponseResult;

/**
 * 采购控制器
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/procurement")
public class ProcurementController {
	@Autowired
	private IProcurementService iProcurementService;
	
	/**
	 * 进入采购报送页面
	 * @return
	 */
	@RequestMapping("/reportPage")
	private String procurementReportPage(ModelMap modelMap){
		
		return iProcurementService.procurementReportPage(modelMap);
	}
	
	/**
	 * 采购信息列表
	 * @return
	 */
	@RequestMapping("/list")
	@ResponseBody
	private ResponseResult<List<Procurement>> queryProcurementList(Integer unitId){
		
		return iProcurementService.queryProcurementList(unitId);
	}
}
