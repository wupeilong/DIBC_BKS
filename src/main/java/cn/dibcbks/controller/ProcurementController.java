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
	 * 进入采购列表页
	 * @return
	 */
	@RequestMapping("/buy_list")
	public String buyList(){		
		return "bks_wap/buy_list";
	}
	/**
	 * 进入采购信息明细页
	 * @return
	 */
	@RequestMapping("/buy_detal")
	public String buyDetal(){		
		return "bks_wap/buy_detal";
	}
	/**
	 * 进入采购信息添加页
	 * @return
	 */
	@RequestMapping("/buy_add")
	public String buyAdd(){		
		return "bks_wap/buy_add";
	}
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