package cn.dibcbks.service;

import java.util.List;

import org.springframework.ui.ModelMap;

import cn.dibcbks.entity.Detection;
import cn.dibcbks.util.ResponseResult;

public interface IDetectionService {

	ResponseResult<List<Detection>> queryDetectionList(ModelMap modelMap,Integer unitId);

	String addDetectionPage(ModelMap modelMap);

	ResponseResult<Void> addDetection(Detection detection);

	String queryDetectionDetail(ModelMap modelMap, Integer id);

}
