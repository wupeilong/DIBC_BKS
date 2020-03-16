package cn.dibcbks.service.impl;


import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import cn.dibcbks.entity.Detection;
import cn.dibcbks.entity.Unit;
import cn.dibcbks.mapper.DetectionMapper;
import cn.dibcbks.mapper.UnitMapper;
import cn.dibcbks.service.IDetectionService;
import cn.dibcbks.util.Constants;
import cn.dibcbks.util.ResponseResult;

@Service
public class IDetectionServiceImpl implements IDetectionService{
	private static final Logger logger = LogManager.getLogger(IDetectionServiceImpl.class.getName());
	@Autowired
	private DetectionMapper detectionMapper;
	@Autowired
	private UnitMapper unitMapper;
	
	@Override
	public ResponseResult<List<Detection>> queryDetectionList(ModelMap modelMap,Integer unitId) {
		ResponseResult<List<Detection>> rr = null;
		try {
			String where = null;
			if (unitId != null) {
				where = "d.unit_id = '" + unitId + "'";
			}
			List<Detection> detectionList = detectionMapper.select(where, " d.create_time DESC", null, null);
			rr = new ResponseResult<>(ResponseResult.SUCCESS,"操作成功！",detectionList);
			logger.info(Constants.SUCCESSU_HEAD_INFO + "用户查询检测报送信息列表成功！");
		} catch (Exception e) {
			e.printStackTrace();
			rr = new ResponseResult<>(ResponseResult.ERROR,"操作失败！");
			logger.error(Constants.ERROR_HEAD_INFO + "用户查询检测报送信息列表失败，原因：" + e.getMessage());
		}
		return rr;
	}

	@Override
	public List<Detection> addDetectionPage() {
		try {
			List<Detection> unitList = detectionMapper.select(null, null, null, null);
			logger.info(Constants.SUCCESSU_HEAD_INFO + "用户进入多频次检测新增信息页！");
			//TODO 多频次检测新增页
			return unitList;
		} catch (Exception e) {	
			logger.error(Constants.ERROR_HEAD_INFO + "用户进入多频次检测新增信息页失败，原因：" + e.getMessage());
			return null;
		}
	
	}

	@Override
	public ResponseResult<Void> addDetection(Detection detection) {
		ResponseResult<Void> rr = null;
		try {	 
			detectionMapper.insert(detection);
			rr = new ResponseResult<>(ResponseResult.SUCCESS,"操作成功！");
			logger.info(Constants.SUCCESSU_HEAD_INFO + "用户新增检测报送信息列表成功！");
		} catch (Exception e) {
			e.printStackTrace();
			rr = new ResponseResult<>(ResponseResult.ERROR,"操作失败！");
			logger.error(Constants.ERROR_HEAD_INFO + "用户新增检测报送信息列表失败，原因：" + e.getMessage());
		}
		return rr;
	}

	@Override
	public String queryDetectionDetail(ModelMap modelMap, Integer id) {
		try {
			Detection detectionDetail = detectionMapper.queryDetection(id);
			modelMap.addAttribute("detectionDetail", detectionDetail);
			System.out.println(detectionDetail);
			logger.info(Constants.SUCCESSU_HEAD_INFO + "用户进入多频次检测详情信息页！");
			//TODO 多频次检测详情页
			return "bks_wap/detection_detal";
		} catch (Exception e) {			
			logger.error(Constants.ERROR_HEAD_INFO + "用户进入多频次检测详情信息页失败，原因：" + e.getMessage());
		}
		return "error/404";
	}

}
