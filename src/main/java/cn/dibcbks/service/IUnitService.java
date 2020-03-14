package cn.dibcbks.service;

import java.util.List;

import cn.dibcbks.entity.Unit;
import cn.dibcbks.util.ResponseResult;

public interface IUnitService {

	ResponseResult<Void> updatUunit(Unit unit);

	ResponseResult<List<Unit>> getAllUnit();

	ResponseResult<Unit> unitDetail(Integer unitId);

}
