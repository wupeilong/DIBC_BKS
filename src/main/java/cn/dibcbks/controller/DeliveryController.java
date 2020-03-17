package cn.dibcbks.controller;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.dibcbks.entity.Distribution;
import cn.dibcbks.entity.Unit;
import cn.dibcbks.entity.User;
import cn.dibcbks.mapper.DistributionMapper;
import cn.dibcbks.mapper.UnitMapper;
import cn.dibcbks.util.CommonUtil;
import cn.dibcbks.util.GetCommonUser;
import cn.dibcbks.util.IDWorkUtil;
import cn.dibcbks.util.ResponseResult;


/**
 * 配送控制器
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/dry")
public class DeliveryController {
	@Autowired
	private DistributionMapper distributionMapper;
	@Autowired
	private UnitMapper unitMapper;
	
	/**
	 * 进入配送信息列表页
	 * @return
	 */
	@RequestMapping("/delivery")
	public String delivery(ModelMap modelMap){
		User user = CommonUtil.getStessionUser();
		List<Distribution> distributionList = new ArrayList<>();
		if (user.getType().equals(1)) {//监管局用户
			distributionList = distributionMapper.select(null, " d.create_time DESC", null, null);
			List<Unit> unitList = unitMapper.select(" n.unit_type BETWEEN 2 AND 4 ", " n.create_time DESC", null, null);
			modelMap.addAttribute("unitList", unitList);
		}else {
			distributionList = distributionMapper.select("d.meals_unit_name = '" + user.getUnitName() + "' or d.acceptance_unit_name = '" + user.getUnitName() + "'", " d.create_time DESC", null, null);
		}
		modelMap.addAttribute("distributionList", distributionList);
		return "bks_wap/delivery";
	}
	
	/**
	 * 查询配送信息列表页
	 * @return
	 */
	@RequestMapping("/deliveryList")
	@ResponseBody
	public ResponseResult<List<Distribution>> deliveryList(String unitName){
		ResponseResult<List<Distribution>> rr = null;
		try {
			String where = null;
			if(StringUtils.isNotEmpty(unitName)){
				where = "d.meals_unit_name = '" + unitName + "' or d.acceptance_unit_name = '" + unitName + "'";
			}
			System.out.println("where: " + where);
			List<Distribution> distributionList = distributionMapper.select(where, " d.create_time DESC", null, null);
			rr = new ResponseResult<>(ResponseResult.SUCCESS,"操作成功！",distributionList);
		} catch (Exception e) {
			// TODO: handle exception
			rr = new ResponseResult<>(ResponseResult.ERROR,"操作失败！");
		}
		return rr;
	}
	
	/**
	 * 进入配送信息详情页
	 * @return
	 */
	@RequestMapping("/delivery_detal")
	public String deliveryDetal(ModelMap modelMap, String id){		
		Distribution distributionDetial = distributionMapper.queryDistribution(id);
		modelMap.addAttribute("distributionDetial", distributionDetial);
		return "bks_wap/delivery_detal";
	}
	
	
	/**
	 * 确认已送达
	 * @return
	 */
	@RequestMapping("/service")
	@ResponseBody
	public ResponseResult<Void> deliveryService(String id){
		ResponseResult<Void> rr = null;
		try {
			Distribution distribution = new Distribution();
			distribution.setId(id);
			distribution.setEndTime(new Date());
			distribution.setStatus(2);//已送达
			distributionMapper.updateById(distribution);
			rr = new ResponseResult<>(ResponseResult.SUCCESS,"操作成功！");
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
			System.out.println("11111111111111111111111111111111");
			rr = new ResponseResult<>(ResponseResult.ERROR,"操作失败！");
		}
		return rr;
	}
	
	
	/**
	 * 确认已验收
	 * @return
	 */
	@RequestMapping("/acceptance")
	@ResponseBody
	public ResponseResult<Void> deliveryService(String id,MultipartFile openedPhoto){
		ResponseResult<Void> rr = null;
		try {			
			User user = CommonUtil.getStessionUser();
			GetCommonUser get = new GetCommonUser();			
			String openedPhotoPath = get.uoladimg(openedPhoto,user.getIdCard());
			if (StringUtils.isNotEmpty(openedPhotoPath)) {
				Distribution distribution = new Distribution();
				distribution.setId(id);
				distribution.setAcceptanceUserName(user.getUsername());
				distribution.setOpenedPhoto(openedPhotoPath);//拆封取餐图
				distribution.setAcceptanceTime(new Date());
				distribution.setStatus(3);//已验收
				distributionMapper.updateById(distribution);
				rr = new ResponseResult<>(ResponseResult.SUCCESS,"操作成功！");
			}else{
				rr = new ResponseResult<>(ResponseResult.ERROR,"上传拆封取餐图失败，请重新上传！");
			}			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
			System.out.println("11111111111111111111111111111111");
			rr = new ResponseResult<>(ResponseResult.ERROR,"操作失败！");
		}
		return rr;
	}
	
	
	/**
	 * 进入配送信息添加页
	 * @return
	 */
	@RequestMapping("/delivery_add")
	public String deliveryAdd(ModelMap modelMap){
		List<Unit> unitList = unitMapper.select(" n.unit_type BETWEEN 2 AND 4 ", " n.create_time DESC", null, null);
		modelMap.addAttribute("unitList", unitList);
		modelMap.addAttribute("unitDetail", unitMapper.select(" n.unit_id = '" + CommonUtil.getStessionUser().getUnitId() + "'", null, null, null).get(0));
		return "bks_wap/delivery_add";
	}

	
	/**
	 * 新增配送信息
	 * @param type
	 * @param mealsUnitName
	 * @param acceptanceUnitName
	 * @param mealsUserName
	 * @param packingPhoto
	 * @param sealPhoto
	 * @param carPhoto
	 * @param address
	 * @return
	 */
	@RequestMapping("/add")
	@ResponseBody
	public ResponseResult<Void> deliveryAdd(	Integer type,
								String mealsUnitName,
								String acceptanceUnitName,
								String mealsUserName,
								MultipartFile packingPhoto,
								MultipartFile sealPhoto,
								MultipartFile carPhoto,
								String address){
			
		ResponseResult<Void> rr = null;
		System.out.println(packingPhoto);
		User user = CommonUtil.getStessionUser();
		GetCommonUser get = new GetCommonUser();		
		String packingPhotoPath = get.uoladimg(packingPhoto,user.getIdCard());
		String sealPhotoPath = get.uoladimg(sealPhoto,user.getIdCard());
		String carPhotoPath = get.uoladimg(carPhoto,user.getIdCard());
		
		System.out.println(112);
		if(StringUtils.isEmpty(packingPhotoPath)){
			rr = new ResponseResult<>(ResponseResult.ERROR,"送餐装箱图上传失败，请重新上传！");
		}else if (StringUtils.isEmpty(sealPhotoPath)) {
			rr = new ResponseResult<>(ResponseResult.ERROR,"装箱封条图上传失败，请重新上传！");
		}else if (StringUtils.isEmpty(carPhotoPath)) {
			rr = new ResponseResult<>(ResponseResult.ERROR,"送餐车图上传失败，请重新上传！");
		}else {
			Date createTime = new Date();
			Distribution distribution = new Distribution();
			distribution.setId(IDWorkUtil.getUniqueCode());
			distribution.setDailyTime(new SimpleDateFormat("yyyy年MM月dd日").format(createTime));
			distribution.setType(type);
			distribution.setMealsUnitName(mealsUnitName);
			distribution.setMealsUserName(mealsUserName);
			distribution.setAcceptanceUnitName(acceptanceUnitName);
			distribution.setPackingPhoto(packingPhotoPath);
			distribution.setSealPhoto(sealPhotoPath);
			distribution.setCarPhoto(carPhotoPath);
			distribution.setAddress(address);
			distribution.setStartTime(createTime);
			distribution.setStatus(1);//启送中
			distribution.setCreateTime(createTime);
			System.out.println("distribution : " + distribution);
			
			distributionMapper.insert(distribution);
			rr = new ResponseResult<>(ResponseResult.SUCCESS,"操作成功！");
		}
		return rr;
	}
}
