package cn.dibcbks.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/clean")
public class CleanController {
	
	
	/**
	 * 进入清洗/消毒记录列表页
	 * @return
	 */
	@RequestMapping("/clean_list")
	public String cleanList(){		
		return "bks_wap/clean_list";
	}
	
	/**
	 * 进入清洗/消毒记录添加页
	 * @return
	 */
	@RequestMapping("/clean_add")
	public String cleanAdd(ModelMap modelMap){
		
		return "bks_wap/clean_add";
	}
	
	
	/**
	 * 进入清洗/消毒记录详情页
	 * @return
	 */
	@RequestMapping("/clean_detal")
	public String cleanDetal(){		
		return "bks_wap/clean_detal";
	}
}
