package cn.dibcbks.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import cn.dibcbks.entity.Hygiene;
import cn.dibcbks.mapper.HygieneMapper;
import cn.dibcbks.service.IHygieneService;
import cn.dibcbks.util.ResponseResult;

@Service
public class IHygieneServiceImpl implements IHygieneService {
	@Autowired
	private HygieneMapper hygieneMapper;
	
	@Override
	public String queryhygieneList(ModelMap modelMap, String userId) {
		try {			
			List<Hygiene> hygieneList = hygieneMapper.select(" h.user_id = '" + userId + "'", " h.upload_time DESC", null, null);
			modelMap.addAttribute("hygieneList", hygieneList);
			//TODO 从业人员健康状况列表页
			return "";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "erro/404";
	}

	@Override
	public String queryhygieneDetail(ModelMap modelMap, Integer hygieneId) {
		try {			
			Hygiene hygieneDetail = hygieneMapper.queryHygiene(hygieneId);
			modelMap.addAttribute("hygieneDetail", hygieneDetail);
			//TODO 从业人员健康状况详情页
			return "";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "erro/404";
	}

	@Override
	public String addHygienePag(ModelMap modelMap) {
		try {			
			//TODO 从业人员健康状况新增页
			return "";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "erro/404";
	}

	@Override
	public ResponseResult<Void> addHygiene(Hygiene hygiene) {
		ResponseResult<Void> rr = null;
		try {
			hygieneMapper.insert(hygiene);
			rr = new ResponseResult<>(ResponseResult.SUCCESS,"操作成功！");
		} catch (Exception e) {
			e.printStackTrace();
			rr = new ResponseResult<>(ResponseResult.ERROR,"操作失败！");
		}
		return rr;
	}

}
