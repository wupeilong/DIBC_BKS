package cn.dibcbks.service.impl;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter.Indenter;

import cn.dibcbks.entity.Disinfection;
import cn.dibcbks.mapper.DisinfectionMapper;
import cn.dibcbks.service.IDisinfectionService;
import cn.dibcbks.util.CommonUtil;
import cn.dibcbks.util.Constants;
import cn.dibcbks.util.ResponseResult;

@Service
public class IDisinfectionServiceImpl implements IDisinfectionService {
	private static final Logger logger = LogManager.getLogger(IDetectionServiceImpl.class.getName());
	@Autowired
	private DisinfectionMapper disinfectionMapper;
	@Override
	public ResponseResult<Void> addCleanInfo(String resultList) {
		ResponseResult<Void> rr = null;
		try {
			Disinfection disinfection=new Disinfection();
			Date now =new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");        
	        String dailyTime=sdf.format(now);
			disinfection.setDailyTime(dailyTime);
			disinfection.setUnitId(CommonUtil.getStessionUser().getUnitId());
			disinfection.setUnitName(CommonUtil.getStessionUser().getUnitName());
			disinfection.setUserId(CommonUtil.getStessionUser().getId());
			disinfection.setUsername(CommonUtil.getStessionUser().getUsername());
			disinfection.setResult(resultList);
			disinfection.setCreateTime(now);
			disinfectionMapper.insert(disinfection);
			rr = new ResponseResult<>(ResponseResult.SUCCESS,"操作成功！");
			logger.info(Constants.SUCCESSU_HEAD_INFO + "用户查询检测报送信息列表成功！");
		} catch (Exception e) {
			e.printStackTrace();
			rr = new ResponseResult<>(ResponseResult.ERROR,"操作失败！");
			logger.error(Constants.ERROR_HEAD_INFO + "用户查询检测报送信息列表失败，原因：" + e.getMessage());
		}
		return rr;		
	}
	@Override
	public List<Disinfection> getDisinfection() {
		String where=null;
		if (CommonUtil.getStessionUser().getType()!=1){
			where="unit_id='"+CommonUtil.getStessionUser().getUnitId()+"'";
		}
		return disinfectionMapper.select(where, null, null, null);
	}
	@Override
	public ResponseResult<List<Disinfection>> getCleanInfo(Integer unitId) {
		ResponseResult<List<Disinfection>> df=null;
		String where=null;
		if (unitId!=0) {
			where="unit_id='"+unitId+"'";
		}		
		List<Disinfection> select = disinfectionMapper.select(where, null, null, null);		
		df=new ResponseResult<List<Disinfection>>(ResponseResult.SUCCESS,select);		
		return df;
	}
	@Override
	public List<Disinfection> getDisinfectionbyid(Integer id) {		
		String where="id="+id;			
		return disinfectionMapper.select(where, null, null, null);
	}


	

}
