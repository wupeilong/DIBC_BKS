package cn.dibcbks.service;

import org.springframework.ui.ModelMap;

import cn.dibcbks.entity.Hygiene;

public interface IHygieneService {

	String queryhygieneList(ModelMap modelMap, String userId);

	String queryhygieneDetail(ModelMap modelMap, Integer hygieneId);

	String addHygienePag(ModelMap modelMap);

	String addHygiene(Hygiene hygiene);

}
