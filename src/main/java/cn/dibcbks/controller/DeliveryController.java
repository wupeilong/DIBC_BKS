package cn.dibcbks.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.dibcbks.entity.Distribution;
import cn.dibcbks.entity.Unit;
import cn.dibcbks.entity.User;
import cn.dibcbks.mapper.DistributionMapper;
import cn.dibcbks.mapper.UnitMapper;
import cn.dibcbks.util.CommonUtil;


/**
 * 配送控制器
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/dry")
public class DeliveryController {
	@Autowired
	private DistributionMapper distributionMapper;
	@Autowired
	private UnitMapper unitMapper;
	
	/**
	 * 进入配送信息列表页
	 * @return
	 */
	@RequestMapping("/delivery")
	public String delivery(ModelMap modelMap){
		User user = CommonUtil.getStessionUser();
		List<Distribution> distributionList = new ArrayList<>();
		if (user.getType().equals(1)) {//监管局用户
			distributionList = distributionMapper.select(null, " d.create_time DESC", null, null);
			List<Unit> unitList = unitMapper.select(" n.unit_type BETWEEN 2 AND 4 ", " n.create_time DESC", null, null);
			modelMap.addAttribute("unitList", unitList);
		}else {
			distributionList = distributionMapper.select("d.meals_unit_name = '" + user.getUnitName() + "' or d.acceptance_unit_name = '" + user.getUnitName() + "'", " d.create_time DESC", null, null);
		}
		modelMap.addAttribute("distributionList", distributionList);
		return "bks_wap/delivery";
	}
	/**
	 * 进入配送信息详情页
	 * @return
	 */
	@RequestMapping("/delivery_detal")
	public String deliveryDetal(){		
		return "bks_wap/delivery_detal";
	}
	/**
	 * 进入配送信息添加页
	 * @return
	 */
	@RequestMapping("/delivery_add")
	public String deliveryAdd(){		
		return "bks_wap/delivery_add";
	}

}
