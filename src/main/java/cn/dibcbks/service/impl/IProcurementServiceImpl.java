package cn.dibcbks.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;

import com.alibaba.fastjson.JSONArray;

import cn.dibcbks.entity.Procurement;
import cn.dibcbks.entity.ProcurementDetail;
import cn.dibcbks.entity.Unit;
import cn.dibcbks.entity.User;
import cn.dibcbks.mapper.ProcurementMapper;
import cn.dibcbks.mapper.UnitMapper;
import cn.dibcbks.service.IProcurementService;
import cn.dibcbks.util.Constants;
import cn.dibcbks.util.ResponseResult;

@Service
public class IProcurementServiceImpl implements IProcurementService {
	private static final Logger logger = LogManager.getLogger(IProcurementServiceImpl.class.getName());
	@Autowired
	private ProcurementMapper procurementMapper;
	@Autowired 
	private UnitMapper unitMapper;
	
	
	@Override
	public String procurementReportPage(ModelMap modelMap) {
		try {
			Session session = SecurityUtils.getSubject().getSession();
			User user = (User)session.getAttribute("user");
			List<Procurement> procurementList = new ArrayList<>();
			if(user.getType().equals(1)){//市场监管局账户
				procurementList = procurementMapper.select(null, " p.purchasing_time DESC", null, null);
			}else{
				procurementList = procurementMapper.select(" p.unit_id = '" + user.getUnitId() + "'", " p.purchasing_time DESC", null, null);
			}
			List<Unit> unitList = unitMapper.select(null, " n.create_time DESC", null, null);
			modelMap.addAttribute("unitList", unitList);
			modelMap.addAttribute("procurementList", procurementList);
			logger.info(Constants.SUCCESSU_HEAD_INFO + "用户进入采购报送页面成功！");
			//TODO 采购报送页面
			return "";
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(Constants.ERROR_HEAD_INFO + "用户进入采购报送页面失败，原因：" + e.getMessage());
		}
		return "error/404";
	}

	@Override
	public ResponseResult<List<Procurement>> queryProcurementList(Integer unitId) {
		ResponseResult<List<Procurement>> rr = null;
		try {
			String where = null;
			if (unitId != null) {
				where = "n.unit_id = '" + unitId + "'";
			}
			List<Procurement> list = procurementMapper.select(where, " p.purchasing_time DESC", null, null);
			rr = new ResponseResult<>(ResponseResult.SUCCESS,"操作成功！",list);
		} catch (Exception e) {
			rr = new ResponseResult<>(ResponseResult.SUCCESS,"操作失败！");
		}		
		return rr;
	}

	@Override
	public String buyList(ModelMap modelMap) {
		Session session = SecurityUtils.getSubject().getSession();
		User user = (User)session.getAttribute("user");
		List<Procurement> procurementList = new ArrayList<>();
		if(user.getType().equals(1)){//市场监管局账户
			List<Unit> unitList = unitMapper.select(" n.unit_type BETWEEN 2 AND 4 ", " n.create_time DESC", null, null);
			modelMap.addAttribute("unitList", unitList);
			procurementList = procurementMapper.select(null, " p.purchasing_time DESC", null, null);
		}else{
			procurementList = procurementMapper.select(" p.unit_id = '" + user.getUnitId() + "'", " p.purchasing_time DESC", null, null);
		}
		modelMap.addAttribute("procurementList", procurementList);		
		logger.info(Constants.SUCCESSU_HEAD_INFO + "用户进入采购报送页面成功！");
		//TODO 采购报送页面
		return "bks_wap/buy_list";
	}
	


	@Override
	public String buyDetal(ModelMap modelMap, Integer id) {
		Procurement procurementDetail = procurementMapper.queryProcurement(id);
		modelMap.addAttribute("procurementDetail", procurementDetail);
		return "bks_wap/buy_detal";
	}

	@Override
	@Transactional
	public ResponseResult<Void> acceptanceProcurementList(String result, Integer id) {
		ResponseResult<Void> rr = null;
		try {
			User user = (User)SecurityUtils.getSubject().getSession().getAttribute("user");
			Procurement procurement = procurementMapper.queryProcurement(id);
			if(procurement.getStatus().equals(1)){//已验收
				rr = new ResponseResult<>(ResponseResult.ERROR,"操作失败！");
			}
			JSONArray array = JSONArray.parseArray(result);
			JSONArray array2 = null;
			ProcurementDetail update = null;
			for(int i=0; i<array.size(); i++){
				array2 = JSONArray.parseArray(array.getString(i));
				update = new ProcurementDetail();
				update.setProcurementDetailId(array2.getInteger(0));
				update.setQualified(array2.getIntValue(1));
				Integer row = procurementMapper.updateProcurementDetailById(update);		
				System.err.println("ProcurementDetailId：" + array2.getInteger(0) + "  修改条数：" + row);
			}			
			//修改采购订单状态
			procurement.setStatus(1);
			procurement.setAcceptanceUsername(user.getUsername());
			procurement.setAcceptanceTime(new Date());
			procurementMapper.updateProcurementById(procurement);
			rr = new ResponseResult<>(ResponseResult.SUCCESS,"操作成功！");
		} catch (Exception e) {
			rr = new ResponseResult<>(ResponseResult.ERROR,"操作失败！");
		}
		return rr;
	}

	@Override
	public String buyAdd(ModelMap modelMap) {
		List<Unit> unitList = unitMapper.select(" n.unit_type BETWEEN 2 AND 4", " n.create_time DESC", null, null);
		modelMap.addAttribute("unitList", unitList);
		return "bks_wap/buy_add";
	}
}
