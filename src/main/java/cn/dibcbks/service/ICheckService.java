package cn.dibcbks.service;

import java.util.List;
import org.springframework.ui.ModelMap;
import cn.dibcbks.util.ResponseResult;

public interface ICheckService {

	String getCheckList(ModelMap modelMap);

	String businessPage(ModelMap modelMap);

	String supervisePage(ModelMap modelMap);

	String supervisionPage(ModelMap modelMap);

	ResponseResult<Void> addCheckInfo(Integer unitId,String unitName,String unitType,String unitAddress,
			String unitPrincipal,String unitPhone,List<Integer> resultList,String other,String inspectors,
			String dailyTime,Integer checkType,String checkPhoto);

	ResponseResult<Void> checkDetailInfo(Integer id);

}
