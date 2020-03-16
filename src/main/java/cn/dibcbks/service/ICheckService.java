package cn.dibcbks.service;

import java.util.List;
import org.springframework.ui.ModelMap;

import cn.dibcbks.entity.Check;
import cn.dibcbks.util.ResponseResult;

public interface ICheckService {

	ResponseResult<List<Check>> queryCheckListInfo(String unitId, Integer unitType);
	
	String getCheckList(ModelMap modelMap);

	String businessPage(ModelMap modelMap);

	String supervisePage(ModelMap modelMap);

	String supervisionPage(ModelMap modelMap);

	ResponseResult<Void> addCheckInfo(Integer unitId,String unitName,String unitType,String unitAddress,
			String unitPrincipal,String unitPhone,String resultList,String other,String inspectors,
			String dailyTime,Integer checkType,String checkPhoto);

	String checkDetailInfo(ModelMap modelMap,Integer id);


}
