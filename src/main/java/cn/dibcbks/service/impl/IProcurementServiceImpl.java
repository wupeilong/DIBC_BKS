package cn.dibcbks.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import cn.dibcbks.entity.Procurement;
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
	@Autowired UnitMapper unitMapper;
	
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String buyList(ModelMap modelMap) {
		Session session = SecurityUtils.getSubject().getSession();
		User user = (User)session.getAttribute("user");
		List<Procurement> procurementList = new ArrayList<>();
		if(user.getType().equals(1)){//市场监管局账户
			procurementList = procurementMapper.select(null, " p.purchasing_time DESC", null, null);
		}else{
			procurementList = procurementMapper.select(" p.unit_id = '" + user.getUnitId() + "'", " p.purchasing_time DESC", null, null);
		}
		modelMap.addAttribute("procurementList", procurementList);
		logger.info(Constants.SUCCESSU_HEAD_INFO + "用户进入采购报送页面成功！");
		//TODO 采购报送页面
		return "bks_wap/buy_list";
	}
	
}
