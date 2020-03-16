package cn.dibcbks.service;

import java.util.List;

import org.springframework.ui.ModelMap;

import cn.dibcbks.entity.Unit;
import cn.dibcbks.util.ResponseResult;

public interface IUnitService {

	ResponseResult<Void> updatUunit(Unit unit);

	ResponseResult<List<Unit>> getAllUnit();

	ResponseResult<Unit> unitDetail(Integer unitId);

	String updateUnitPage(ModelMap modelMap);

	ResponseResult<List<Unit>> queryUnitList(Integer unitId, String unitName);

	String CooprationList(ModelMap modelMap);
	List<Unit> CooprationList();

	String CooprationDetal(ModelMap modelMap, Integer unitId);


}
