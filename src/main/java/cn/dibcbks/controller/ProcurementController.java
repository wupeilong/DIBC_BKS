package cn.dibcbks.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	 * 进入采购列表页
	 * @return
	 */
	@RequestMapping("/buy_list")
	public String buyList(ModelMap modelMap){
		return iProcurementService.buyList(modelMap);
		//return "bks_wap/buy_list";
	}
	/**
	 * 进入采购信息明细页
	 * @return
	 */
	@RequestMapping("/buy_detal")
	public String buyDetal(ModelMap modelMap,Integer id){
		
		return iProcurementService.buyDetal(modelMap,id);
//		return "bks_wap/buy_detal";
	}
	/**
	 * 进入采购信息添加页
	 * @return
	 */
	@RequestMapping("/buy_add")
	public String buyAdd(ModelMap modelMap){
		return iProcurementService.buyAdd(modelMap);
		//return "bks_wap/buy_add";
	}
/*	*//**
	 * 进入采购报送页面
	 * @return
	 *//*
	@RequestMapping("/reportPage")
	public String procurementReportPage(ModelMap modelMap){
		
		return iProcurementService.procurementReportPage(modelMap);
	}*/
	
	/**
	 * 采购信息列表
	 * @return
	 */
	@RequestMapping("/list")
	@ResponseBody
	public ResponseResult<List<Procurement>> queryProcurementList(Integer unitId){
		
		return iProcurementService.queryProcurementList(unitId);
	}
	
	/**
	 * 验收采购信息
	 * @return
	 */
	@RequestMapping("/acceptance")
	@ResponseBody
	public ResponseResult<Void> acceptanceProcurementList(@RequestParam("result")String result, @RequestParam("id")Integer id){
		
		return iProcurementService.acceptanceProcurementList(result,id);
	}
}
