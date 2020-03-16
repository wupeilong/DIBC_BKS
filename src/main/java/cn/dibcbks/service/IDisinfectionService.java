package cn.dibcbks.service;


import java.util.List;
import cn.dibcbks.entity.Disinfection;
import cn.dibcbks.util.ResponseResult;
public interface IDisinfectionService {

	ResponseResult<Void> addCleanInfo(String resultList);
	List<Disinfection> getDisinfection();
	List<Disinfection> getDisinfectionbyid(Integer id);
	ResponseResult<List<Disinfection>> getCleanInfo(Integer unitId);

	

}
