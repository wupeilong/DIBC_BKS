package cn.dibcbks.service;

import java.util.List;

import org.springframework.ui.ModelMap;

import cn.dibcbks.entity.Detection;
import cn.dibcbks.entity.Unit;
import cn.dibcbks.util.ResponseResult;

public interface IDetectionService {

	ResponseResult<List<Detection>> queryDetectionList(ModelMap modelMap,Integer unitId);

	List<Detection> addDetectionPage();

	ResponseResult<Void> addDetection(Detection detection);

	String queryDetectionDetail(ModelMap modelMap, Integer id);

}
