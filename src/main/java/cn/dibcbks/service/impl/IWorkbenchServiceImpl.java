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

import cn.dibcbks.entity.Detection;
import cn.dibcbks.entity.Disinfection;
import cn.dibcbks.entity.Distribution;
import cn.dibcbks.entity.Procurement;
import cn.dibcbks.entity.Unit;
import cn.dibcbks.entity.User;
import cn.dibcbks.mapper.DetectionMapper;
import cn.dibcbks.mapper.DisinfectionMapper;
import cn.dibcbks.mapper.DistributionMapper;
import cn.dibcbks.mapper.ProcurementMapper;
import cn.dibcbks.mapper.UnitMapper;
import cn.dibcbks.mapper.UserMapper;
import cn.dibcbks.service.IWorkbenchService;
import cn.dibcbks.util.Constants;


@Service
public class IWorkbenchServiceImpl implements IWorkbenchService {
	private static final Logger logger = LogManager.getLogger(IWorkbenchServiceImpl.class.getName());
	@Autowired
	private UnitMapper unitMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private ProcurementMapper procurementMapper;
	@Autowired
	private DistributionMapper distributionMapper;
	@Autowired
	private DisinfectionMapper disinfectionMapper;
	@Autowired
	private DetectionMapper detectionMapper;
	
	@Override
	public String workbench(ModelMap modelMap) {
		try {
			logger.info(Constants.SUCCESSU_HEAD_INFO + "用户进入工作台页面成功！");
			//TODO 工作台页面
			return "";
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(Constants.ERROR_HEAD_INFO + "用户进入工作台页面失败，原因：" + e.getMessage());
		}
		return "error/404";
	}
	
	@Override
	public String unitInfo(ModelMap modelMap) {
		try {			
			Session session = SecurityUtils.getSubject().getSession();
			User user = (User)session.getAttribute("user");
			if(user.getType().equals(1)){//市场监管局账户
				List<Unit> unitList = unitMapper.select(" n.unit_type BETWEEN 2 AND 4 ", " n.create_time DESC", null, null);
				modelMap.addAttribute("unitList", unitList);
				logger.info(Constants.SUCCESSU_HEAD_INFO + "用户进入企业信息列表页面成功！");
				//TODO 企业信息列表页面
				return "";
			}else{//企业用户
				List<Unit> unitList = unitMapper.select(" n.unit_id = '" + user.getUnitId() + "'", null, null, null);
				modelMap.addAttribute("unitDetail", unitList.get(0));
				logger.info(Constants.SUCCESSU_HEAD_INFO + "用户进入企业信息详情页面成功！");
				//TODO 企业信息页面
				return "";
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(Constants.ERROR_HEAD_INFO + "用户进入企业信息页面失败，原因：" + e.getMessage());
		}
		return "error/404";
	}
	
	@Override
	public String practitioners(ModelMap modelMap) {
		try {
			Session session = SecurityUtils.getSubject().getSession();
			User user = (User)session.getAttribute("user");
			List<User> userList = new ArrayList<>();
			if(user.getType().equals(1)){//市场监管局账户
				userList = userMapper.select(null, " u.create_time DESC", null, null);
			}else {//企业用户
				userList = userMapper.select(" u.unit_id = '" + user.getUnitId() + "'", " u.create_time DESC", null, null);
			}
			modelMap.addAttribute("userList", userList);
			logger.info(Constants.SUCCESSU_HEAD_INFO + "用户进入从业人员信息页面成功！");
			//TODO 从业人员信息页面
			return "";
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(Constants.ERROR_HEAD_INFO + "用户进入从业人员信息页面失败，原因：" + e.getMessage());
		}
		return "error/404";
	}
	
	@Override
	public String purchaseReport(ModelMap modelMap) {
		try {
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
			return "";
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(Constants.ERROR_HEAD_INFO + "用户进入采购报送页面失败，原因：" + e.getMessage());
		}
		return "error/404";
	}
	
	@Override
	public String manufacturingInspection(ModelMap modelMap) {
		try {
			logger.info(Constants.SUCCESSU_HEAD_INFO + "用户进入加工制作检视页面成功！");
			//TODO 加工制作检视页面
			return "";
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(Constants.ERROR_HEAD_INFO + "用户进入加工制作检视页面失败，原因：" + e.getMessage());
		}
		return "error/404";
	}
	
	@Override
	public String deliveryDistribution(ModelMap modelMap) {
		try {
			Session session = SecurityUtils.getSubject().getSession();
			User user = (User)session.getAttribute("user");
			Unit unit = unitMapper.select(" n.unit_id = '" + user.getUnitId() + "'", null, null, null).get(0);
			List<Distribution> distributionList = new ArrayList<>();
			if(user.getType().equals(1)){//市场监管局账户
				distributionList = distributionMapper.select(null, " d.create_time DESC", null, null);
			}else{
				distributionList = distributionMapper.select("d.meals_unit_name = '" + unit.getUnitName() + "' or d.acceptance_unit_name = '" + unit.getUnitName() + "'", " d.create_time DESC", null, null);
			}
			modelMap.addAttribute("distributionList", distributionList);
			logger.info(Constants.SUCCESSU_HEAD_INFO + "用户进入配送报备页面成功！");
			//TODO 配送报备页面
			return "";
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(Constants.ERROR_HEAD_INFO + "用户进入配送报备页面失败，原因：" + e.getMessage());
		}
		return "error/404";
	}
	
	@Override
	public String cleaningDisinfection(ModelMap modelMap) {
		try {
			Session session = SecurityUtils.getSubject().getSession();
			User user = (User)session.getAttribute("user");
			List<Disinfection> disinfectionList = new ArrayList<>();			
			if(user.getType().equals(1)){//市场监管局账户
				disinfectionList = disinfectionMapper.select(null, " d.create_time DESC ", null, null);
			}else {
				disinfectionList = disinfectionMapper.select(" d.unit_id = '" + user.getUnitId() + "'", " d.create_time DESC ", null, null);
			}
			modelMap.addAttribute("disinfectionList", disinfectionList);
			logger.info(Constants.SUCCESSU_HEAD_INFO + "用户进入清洗消毒页面成功！");
			//TODO 清洗消毒页面
			return "";
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(Constants.ERROR_HEAD_INFO + "用户进入清洗消毒页面失败，原因：" + e.getMessage());
		}
		return "error/404";
	}
	
	@Override
	public String regulatory(ModelMap modelMap) {
		try {
			logger.info(Constants.SUCCESSU_HEAD_INFO + "用户进入监管采集页面成功！");
			//TODO 监管采集页面
			return "";
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(Constants.ERROR_HEAD_INFO + "用户进入监管采集页面失败，原因：" + e.getMessage());
		}
		return "error/404";
	}
	
	@Override
	public String inspectionReport(ModelMap modelMap) {
		try {
			List<Detection> detectionList = detectionMapper.select(null, " d.create_time DESC", null, null);
			modelMap.addAttribute("detectionList", detectionList);
			logger.info(Constants.SUCCESSU_HEAD_INFO + "用户进入检测报送页面成功！");
			//TODO 检测报送页面
			return "";
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(Constants.ERROR_HEAD_INFO + "用户进入检测报送页面失败，原因：" + e.getMessage());
		}
		return "error/404";
	}
	
	@Override
	public String videoSurveillance(ModelMap modelMap) {
		try {
			logger.info(Constants.SUCCESSU_HEAD_INFO + "用户进入视频监控页面成功！");
			//TODO 检测报送页面
			return "";
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(Constants.ERROR_HEAD_INFO + "用户进入视频监控页面失败，原因：" + e.getMessage());
		}
		return "error/404";
	}
	
}
