package cn.dibcbks.service;

import java.util.List;

import org.springframework.ui.ModelMap;

import cn.dibcbks.entity.Procurement;
import cn.dibcbks.util.ResponseResult;

public interface IProcurementService {

	String procurementReportPage(ModelMap modelMap);

	ResponseResult<List<Procurement>> queryProcurementList(Integer unitId);

	String buyList(ModelMap modelMap);

	String buyDetal(ModelMap modelMap, Integer id);

	ResponseResult<Void> acceptanceProcurementList(String result, Integer id);

	String buyAdd(ModelMap modelMap);

}
