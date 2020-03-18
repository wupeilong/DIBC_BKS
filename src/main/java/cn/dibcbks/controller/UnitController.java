package cn.dibcbks.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.dibcbks.entity.Unit;
import cn.dibcbks.entity.User;
import cn.dibcbks.mapper.UnitMapper;
import cn.dibcbks.service.IUnitService;
import cn.dibcbks.util.CommonUtil;
import cn.dibcbks.util.GetCommonUser;
import cn.dibcbks.util.ResponseResult;
/**
 * 企业控制器
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/unit")
public class UnitController {
	@Autowired
	private IUnitService iUnitService;
	@Autowired
	private UnitMapper unitMapper;
	
	/**
	 * 进入企业信息列表页
	 * @return
	 */
	@RequestMapping("/coopration_list")
	public String CooprationList(ModelMap modelMap){
		
		return iUnitService.CooprationList(modelMap);		
	}
	
	
	/**
	 * 进入企业信息详情页
	 * @return
	 */
	@RequestMapping("/coopration_detal")
	public String CooprationDetal(ModelMap modelMap,Integer unitId){	
		
		return iUnitService.CooprationDetal(modelMap,unitId);
	}
	
	
	/**
	 * 进入企业信息修改页
	 * @return
	 */
	@RequestMapping("/coopration_update")
	public String updateUnitPage(ModelMap modelMap){
		
		return iUnitService.updateUnitPage(modelMap);
	}
	
	
	/**
	 * 修改企业信息
	 * @param unit
	 * @return
	 */
	@RequestMapping("/update")
	@ResponseBody
	public ResponseResult<Void> updateUnit(
			@RequestParam(value="unitName",required = true) String unitName,			
			@RequestParam(value="businessLicenseCode",required = true) String businessLicenseCode,
			@RequestParam(value="businessLicense",required=false)MultipartFile file,
			@RequestParam(value="productionLicense",required=false)MultipartFile file1,				
			@RequestParam(value="unitAddress",required = true) String unitAddress,			
			@RequestParam(value="unitType",required = true) Integer unitType,
			@RequestParam(value="legalPerson",required = true) String legalPerson){
		
		GetCommonUser get = new GetCommonUser();
		User user = CommonUtil.getStessionUser();
		List<Unit> unitList = unitMapper.select(" n.unit_id = '" + user.getUnitId() + "'", null, null, null);
		if(unitList.isEmpty()){
			return new ResponseResult<Void>(ResponseResult.ERROR,"企业信息异常，操作失败！");
		}
		Unit update = unitList.get(0);
		update.setUnitName(unitName);
		update.setBusinessLicenseCode(businessLicenseCode);
		update.setUnitAddress(unitAddress);
		update.setUnitType(unitType);
		update.setLegalPerson(legalPerson);
		System.out.println("11111");
		if(file != null){
			get.deluoladimg(update.getBusinessLicense());
			String businessLicense = get.uoladimg(file, user.getUuid());
			if(businessLicense == null){
				return new ResponseResult<Void>(ResponseResult.ERROR,"营业执照上传异常,人员信息添加失败");
			}
			update.setBusinessLicense(businessLicense);
		}
		System.out.println("2222222");
		if(file1 != null){
			System.out.println("3333333");
			get.deluoladimg(update.getProductionLicense());
			String productionLicense = get.uoladimg(file1, user.getUuid());
			if(productionLicense == null){
				return new ResponseResult<Void>(ResponseResult.ERROR,"许可证上传异常,人员信息添加失败");
			}
			update.setProductionLicense(productionLicense);		
		}		
		return iUnitService.updatUunit(update);
	}
	
	
	/**
	 * 查询企业信息列表
	 * @return
	 */
	@RequestMapping("/list")
	@ResponseBody
	public ResponseResult<List<Unit>> queryUnitList(Integer unitId,String unitName){
		
		return iUnitService.queryUnitList(unitId,unitName);
	}
	

	/**
	 * 查询单位信息详情
	 * @param unitId
	 * @return
	 */
	@RequestMapping("/detail")
	@ResponseBody
	public ResponseResult<Unit> unitDetail(Integer unitId){
		
		return iUnitService.unitDetail(unitId);
	}
	
	
}
