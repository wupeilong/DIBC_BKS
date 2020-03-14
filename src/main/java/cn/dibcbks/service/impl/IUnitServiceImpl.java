package cn.dibcbks.service.impl;


import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;
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
import cn.dibcbks.mapper.UnitMapper;
import cn.dibcbks.service.IUnitService;
import cn.dibcbks.util.Constants;
import cn.dibcbks.util.ResponseResult;

@Service
public class IUnitServiceImpl implements IUnitService {
	private static final Logger logger = LogManager.getLogger(IUnitServiceImpl.class.getName());
	@Autowired
	private UnitMapper unitMapper;
	
	
	@Override
	public ResponseResult<Void> updatUunit(Unit unit) {
		ResponseResult<Void> rr = null;
		try {
			User currentUser = (User)SecurityUtils.getSubject().getSession().getAttribute("user");
			if(!currentUser.getParentId().equals(0)){
				logger.info(Constants.SUCCESSU_HEAD_INFO + "该账户不是管理员，不能修改企业信息！");
				rr = new ResponseResult<>(ResponseResult.ERROR, "该账户不是管理员，不能修改企业信息！");
			}else{
				if(StringUtils.isNotEmpty(unit.getBusinessLicenseCode())){
					Unit queryUnit = unitMapper.queryUnit(unit.getBusinessLicenseCode());
					if(queryUnit != null && !unit.getBusinessLicenseCode().equals(queryUnit.getBusinessLicenseCode())){
						logger.error(Constants.ERROR_HEAD_INFO + "企业资料修改失败，原因：营业执照编码已存在！");
						return new ResponseResult<>(ResponseResult.ERROR, "营业执照编码已存在！");
					}
				}
				unitMapper.updateById(unit);
				logger.info(Constants.SUCCESSU_HEAD_INFO + "企业资料修成功！");
				rr = new ResponseResult<>(ResponseResult.SUCCESS, "企业资料修改成功！");
			}			
		} catch (Exception e) {
			logger.error(Constants.ERROR_HEAD_INFO + "企业资料修改失败，原因：" + e.getMessage());
			rr = new ResponseResult<>(ResponseResult.ERROR, "企业资料修改失败！");
		}
		return rr;
	}


	@Override
	public ResponseResult<List<Unit>> getAllUnit() {
		ResponseResult<List<Unit>> rr = null;
		try {
			List<Unit> unitList = unitMapper.select(" n.unit_type BETWEEN 2 AND 4 ", null, null, null);
			logger.info(Constants.SUCCESSU_HEAD_INFO + "企业列表查询成功！");
			rr = new ResponseResult<>(ResponseResult.SUCCESS,"操作成功！",unitList);
		} catch (Exception e) {
			logger.error(Constants.ERROR_HEAD_INFO + "企业列表查询失败，原因：" + e.getMessage());
			rr = new ResponseResult<>(ResponseResult.ERROR, "企业列表查询失败！");
		}
		return rr;
	}


	@Override
	public ResponseResult<Unit> unitDetail(Integer unitId) {
		ResponseResult<Unit> rr = null;
		try {
			Unit unit = null;
			List<Unit> list = unitMapper.select(" unit_id = '" + unitId + "'", null, null, null);
			if (!list.isEmpty()) {
				unit = list.get(0);
			}
			logger.info(Constants.SUCCESSU_HEAD_INFO + "企业详情查询成功！");
			rr = new ResponseResult<>(ResponseResult.SUCCESS,"操作成功！", unit);
		} catch (Exception e) {
			logger.error(Constants.ERROR_HEAD_INFO + "企业详情查询失败，原因：" + e.getMessage());
			rr = new ResponseResult<>(ResponseResult.ERROR, "企业详情查询失败！");
		}
		return rr;
	}


	@Override
	public String updateUnitPage(ModelMap modelMap) {
		try {
			Session session = SecurityUtils.getSubject().getSession();
			User user = (User)session.getAttribute("user");
			List<Unit> detailUnit = unitMapper.select(" n.unit_id = '" + user.getUnitId() + "'", null, null, null);
			modelMap.addAttribute("detailUnit", detailUnit);
			logger.info(Constants.SUCCESSU_HEAD_INFO + "用户进入企业编辑页面成功！");
			//TODO 企业编辑页面
			return "";
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(Constants.ERROR_HEAD_INFO + "用户进入企业编辑页面失败，原因：" + e.getMessage());
		}
		return "error/404";
	}


	@Override
	public List<Unit> queryUnitList(Integer unitId, String unitName) {
		List<Unit> unitList = new ArrayList<>();
		try {
			String where = "";
			if(unitId == null && StringUtils.isEmpty(unitName)){
				where = null;
			}
			boolean addAnd = false;
			if(unitId != null){
				where += " n.unit_id = '" + unitId + "'";
				addAnd =true;
			}
			if(StringUtils.isNotEmpty(unitName)){
				if (addAnd) {
					where += " AND n.unit_name = '" + unitName + "'";
				}else {
					where += " n.unit_name = '" + unitName + "'";
				}				
 			}
			unitList = unitMapper.select(where, null, null, null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return unitList;
	}

}
