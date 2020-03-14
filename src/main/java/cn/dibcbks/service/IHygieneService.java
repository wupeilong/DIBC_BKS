package cn.dibcbks.service;

import org.springframework.ui.ModelMap;

import cn.dibcbks.entity.Hygiene;
import cn.dibcbks.util.ResponseResult;

public interface IHygieneService {

	String queryhygieneList(ModelMap modelMap, String userId);

	String queryhygieneDetail(ModelMap modelMap, Integer hygieneId);

	String addHygienePag(ModelMap modelMap);

	ResponseResult<Void> addHygiene(Hygiene hygiene);

}
