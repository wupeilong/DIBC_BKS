package cn.dibcbks.service.impl;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import com.alibaba.fastjson.JSONArray;
import cn.dibcbks.entity.Check;
import cn.dibcbks.entity.Unit;
import cn.dibcbks.entity.User;
import cn.dibcbks.mapper.CheckMapper;
import cn.dibcbks.mapper.UnitMapper;
import cn.dibcbks.service.ICheckService;
import cn.dibcbks.util.Constants;
import cn.dibcbks.util.ResponseResult;

@Service
public class ICheckServiceImpl implements ICheckService {
	private static final Logger logger = LogManager.getLogger(ICheckServiceImpl.class.getName());
	@Autowired
	private CheckMapper checkMapper;
	@Autowired
	private UnitMapper unitMapper;
	
	@Override
	public String getCheckList(ModelMap modelMap) {
		try {
			Subject subject = SecurityUtils.getSubject();
			Session session = subject.getSession();
			User user = (User)session.getAttribute("user");
			List<Check> checkList = new ArrayList<>();
			if (user.getType().equals(1)) {//监管局账户
				checkList = checkMapper.select(null, " c.create_time DESC", null, null);
			}else {
				checkList = checkMapper.select(" c.unit_id = '" + user.getUnitId() + "'", " c.create_time DESC", null, null);
			}
			modelMap.addAttribute("checkList", checkList);
			logger.info(Constants.SUCCESSU_HEAD_INFO + "用户进入监管采集信息查看页面成功！");
			//TODO 监管采集信息查看页面
			return "";
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(Constants.ERROR_HEAD_INFO + "用户进入信息采集信息查看页面失败，原因：" + e.getMessage());
		}
		return "error/404";
	}


	@Override
	public String businessPage(ModelMap modelMap) {
		try {
			Subject subject = SecurityUtils.getSubject();
			Session session = subject.getSession();
			User user = (User)session.getAttribute("user");
			List<Unit> unitList = unitMapper.select("n.unit_id = '" + user.getUnitId() + "'", null, null, null);
			modelMap.addAttribute("unitList", unitList);
			logger.info(Constants.SUCCESSU_HEAD_INFO + "用户进入商家自检页面成功！");
			//TODO 商家自检页面
			return "";
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(Constants.ERROR_HEAD_INFO + "用户进入商家自检页面失败，原因：" + e.getMessage());
		}
		return "error/404";
	}

	@Override
	public String supervisePage(ModelMap modelMap) {
		try {
			List<Unit> unitList = unitMapper.select(null, null, null, null);
			modelMap.addAttribute("unitList", unitList);
			logger.info(Constants.SUCCESSU_HEAD_INFO + "用户进入监管局专检页面成功！");
			//TODO 监管局专检页面
			return "";
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(Constants.ERROR_HEAD_INFO + "用户进入监管局专检页面失败，原因：" + e.getMessage());
		}
		return "error/404";
	}

	@Override
	public String supervisionPage(ModelMap modelMap) {
		try {
			List<Unit> unitList = unitMapper.select(null, null, null, null);
			modelMap.addAttribute("unitList", unitList);
			logger.info(Constants.SUCCESSU_HEAD_INFO + "用户进入督察组专检页面成功！");
			//TODO 督察组专检页面
			return "";
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(Constants.ERROR_HEAD_INFO + "用户进入督察组专检页面失败，原因：" + e.getMessage());
		}
		return "error/404";
	}


	@Override
	public ResponseResult<Void> addCheckInfo(Integer unitId,String unitName,String unitType,String unitAddress,
			String unitPrincipal,String unitPhone,List<Integer> resultList,String other,String inspectors,
			String dailyTime,Integer checkType,String checkPhoto) {
		ResponseResult<Void> rr = null;
		try {
//			Subject subject = SecurityUtils.getSubject();
//			Session session = subject.getSession();
//			User user = (User)session.getAttribute("user");
			Check check = new Check();
			check.setUnitId(unitId);
			check.setUnitName(unitName);
			check.setUnitType(unitType);
			check.setUnitAddress(unitAddress);
			check.setUnitPrincipal(unitPrincipal);
			check.setUnitPhone(unitPhone);
			check.setResult(JSONArray.toJSONString(resultList));
			check.setOther(other);
			check.setInspectors(inspectors);
			check.setDailyTime(dailyTime);
			check.setCheckType(checkType);
			check.setCheckPhoto(checkPhoto);
			check.setCreateTime(new Date());
			checkMapper.insert(check);
			rr = new ResponseResult<>(ResponseResult.SUCCESS,"操作成功！");
			logger.info(Constants.SUCCESSU_HEAD_INFO + "用户新增检查信息成功！");
		} catch (Exception e) {
			e.printStackTrace();
			rr = new ResponseResult<>(ResponseResult.ERROR,"操作失败！");
			logger.error(Constants.ERROR_HEAD_INFO + "用户进入督察组专检页面失败，原因：" + e.getMessage());
		}
		return rr;
	}


	@Override
	public ResponseResult<Void> checkDetailInfo(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
