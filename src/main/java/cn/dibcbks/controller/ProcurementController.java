package cn.dibcbks.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONArray;

import cn.dibcbks.entity.Procurement;
import cn.dibcbks.entity.ProcurementDetail;
import cn.dibcbks.entity.Unit;
import cn.dibcbks.entity.User;
import cn.dibcbks.mapper.ProcurementMapper;
import cn.dibcbks.mapper.UnitMapper;
import cn.dibcbks.service.IProcurementService;
import cn.dibcbks.util.GetCommonUser;
import cn.dibcbks.util.ResponseResult;

/**
 * 采购控制器
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/procurement")
public class ProcurementController {
	@Autowired
	private IProcurementService iProcurementService;
	@Autowired
	private ProcurementMapper procurementMapper;
	@Autowired
	private UnitMapper unitMapper;
	
	/**
	 * 进入采购列表页
	 * @return
	 */
	@RequestMapping("/buy_list")
	public String buyList(ModelMap modelMap){
		return iProcurementService.buyList(modelMap);
		//return "bks_wap/buy_list";
	}
	/**
	 * 进入采购信息明细页
	 * @return
	 */
	@RequestMapping("/buy_detal")
	public String buyDetal(ModelMap modelMap,Integer id){
		
		return iProcurementService.buyDetal(modelMap,id);
//		return "bks_wap/buy_detal";
	}
	/**
	 * 进入采购信息添加页
	 * @return
	 */
	@RequestMapping("/buy_add")
	public String buyAdd(ModelMap modelMap){
		return iProcurementService.buyAdd(modelMap);
		//return "bks_wap/buy_add";
	}
	

	/**
	 * 新增采购信息
	 * @param supplierUnitId
	 * @param supplierBusinessLicense
	 * @param supplierproductionLicense
	 * @param supplierQualification
	 * @param invoice
	 * @param supplierPerson
	 * @param supplierPhone
	 * @param detailList
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping("/add")
	@ResponseBody
	public ResponseResult<Void> addProcurement(	Integer supplierUnitId,
									MultipartFile supplierBusinessLicense,
									MultipartFile supplierproductionLicense,
									MultipartFile supplierQualification,
									MultipartFile invoice,
									String supplierPerson,
									String supplierPhone,
									String detailList) throws ParseException{
		System.out.println("开始添加采集信息========");
		ResponseResult<Void> rr = null;
		User user = (User)SecurityUtils.getSubject().getSession().getAttribute("user");
		List<Unit> supplierUnit = unitMapper.select(" n.unit_id = '" + supplierUnitId + "'", null, null, null);
		GetCommonUser get = new GetCommonUser();			
		String supplierBusinessLicensePath = get.uoladimg(supplierBusinessLicense,user.getIdCard());//营业执照	
		String supplierproductionLicensePath = get.uoladimg(supplierproductionLicense,user.getIdCard());//许可证
		String supplierQualificationPath = get.uoladimg(supplierQualification,user.getIdCard());//资质
		String invoicePath = get.uoladimg(invoice,user.getIdCard());//发票
		if(supplierUnit.isEmpty()){
			rr = new ResponseResult<>(ResponseResult.ERROR,"供货商信息不存在，添加采购信息失败！");
		}else if(StringUtils.isEmpty(supplierBusinessLicensePath)){
			rr = new ResponseResult<>(ResponseResult.ERROR,"营业执照上传失败，添加采购信息失败！");
		}else if(StringUtils.isEmpty(invoicePath)){
			rr = new ResponseResult<>(ResponseResult.ERROR,"发票上传失败，添加采购信息失败！");
		}else if (StringUtils.isEmpty(detailList)) {
			rr = new ResponseResult<>(ResponseResult.ERROR,"未添加采购详情，添加采购信息失败！");
		}else {
			//上传采购信息
			Procurement procurement = new Procurement();
			procurement.setUnitId(user.getUnitId());
			procurement.setUserId(user.getId());
			procurement.setUnitName(user.getUnitName());			
			procurement.setSupplier(supplierUnit.get(0).getUnitName());
			procurement.setSupplierBusinessLicense(supplierBusinessLicensePath);
			procurement.setSupplierProductionLicense(supplierproductionLicensePath);
			procurement.setSupplierQualification(supplierQualificationPath);
			procurement.setInvoice(invoicePath);
			procurement.setSupplierPerson(supplierPerson);
			procurement.setSupplierPhone(supplierPhone);
			procurement.setPurchasingTime(new Date());
			procurement.setStatus(0);
			System.out.println("采购订单：" + procurement);
			Integer row = procurementMapper.insertProcurement(procurement);
			System.out.println("采购订单：" + row);
			
			ProcurementDetail procurementDetail = null;
			Date productionDate = null;
			JSONArray parseArray = JSONArray.parseArray(detailList);
			JSONArray array = null;
			for(int i=0; i<parseArray.size(); i++){
				array = JSONArray.parseArray(parseArray.getString(i));
				productionDate  = new SimpleDateFormat("yyyy-MM-dd").parse(array.getString(2));
				procurementDetail = new ProcurementDetail();
				procurementDetail.setProcurementId(procurement.getId());
				procurementDetail.setProductName(array.getString(0));
				procurementDetail.setCount(array.getString(1));
				procurementDetail.setProductionDate(productionDate);
				row = procurementMapper.insertProcurementDetail(procurementDetail);
				System.out.println("采购详情：" + row);
			}
			rr = new ResponseResult<>(ResponseResult.SUCCESS,"操作成功！");
		}
		System.out.println("结束添加采集信息========");
		return rr;
	}
	
/*	*//**
	 * 进入采购报送页面
	 * @return
	 *//*
	@RequestMapping("/reportPage")
	public String procurementReportPage(ModelMap modelMap){
		
		return iProcurementService.procurementReportPage(modelMap);
	}*/
	
	/**
	 * 采购信息列表
	 * @return
	 */
	@RequestMapping("/list")
	@ResponseBody
	public ResponseResult<List<Procurement>> queryProcurementList(Integer unitId){
		
		return iProcurementService.queryProcurementList(unitId);
	}
	
	/**
	 * 验收采购信息
	 * @return
	 */
	@RequestMapping("/acceptance")
	@ResponseBody
	public ResponseResult<Void> acceptanceProcurementList(@RequestParam("result")String result, @RequestParam("id")Integer id){
		
		return iProcurementService.acceptanceProcurementList(result,id);
	}
}
