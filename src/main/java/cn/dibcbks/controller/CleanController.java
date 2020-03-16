package cn.dibcbks.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter.Indenter;
import cn.dibcbks.entity.Disinfection;
import cn.dibcbks.entity.Unit;
import cn.dibcbks.service.IDisinfectionService;
import cn.dibcbks.service.IUnitService;
import cn.dibcbks.util.CommonUtil;
import cn.dibcbks.util.ResponseResult;


@Controller
@RequestMapping("/clean")
public class CleanController {
	@Autowired
	private IDisinfectionService iDisinfectionService;
	@Autowired
	private IUnitService iUnitService;
	/**
	 * 进入清洗/消毒记录列表页
	 * @return
	 */
	@RequestMapping("/clean_list")
	public String cleanList(ModelMap map){	
		if(CommonUtil.getStessionUser().getType()==1){
			List<Unit> unitList = iUnitService.CooprationList();
			map.addAttribute("unitlistall", unitList);
		}		
		List<Disinfection> disinfection = iDisinfectionService.getDisinfection();
		map.addAttribute("disinfectionlist", disinfection);
		return "bks_wap/clean_list";
	}
	@RequestMapping("/clean_alllist")
	@ResponseBody
	public ResponseResult<List<Disinfection>> alllist(Integer unitId){	
		
		return  iDisinfectionService.getCleanInfo(unitId);
	}
	/**
	 * 进入清洗/消毒记录添加页
	 * @return
	 */
	@RequestMapping("/clean_add")
	public String cleanAdd(ModelMap modelMap){
		
		return "bks_wap/clean_add";
	}
	@RequestMapping("/clean_regadd")
	@ResponseBody
	public ResponseResult<Void> addCleanInfo(@RequestParam(value="queryrights") String queryrights){		      
		return  iDisinfectionService.addCleanInfo(queryrights);
	}
	
	/**
	 * 进入清洗/消毒记录详情页
	 * @return
	 */
	@RequestMapping("/clean_detal")
	public String cleanDetal(ModelMap map,Integer id){	
		List<Disinfection> disinfectionbyid = iDisinfectionService.getDisinfectionbyid(id);
		JSONArray jsonArray = JSONArray.parseArray(disinfectionbyid.get(0).getResult());
		map.addAttribute("DisinfectionDetal", jsonArray);
		map.addAttribute("disinfectionbyid", disinfectionbyid);
		return "bks_wap/clean_detal";
	}
}
