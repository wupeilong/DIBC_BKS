package cn.dibcbks.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.dibcbks.entity.Unit;

public interface UnitMapper {
	/**
	 * 新增企业/单位信息
	 * @param unit
	 * @return
	 */
	Integer insert(Unit unit);
	
	/**
	 * 查询企业/单位信息
	 * @param businessLicenseCode
	 * @return
	 */
	Unit queryUnit(String businessLicenseCode);
	
	/**
	 * 查询企业/单位列表信息
	 * @param where
	 * @param orderBy
	 * @param offset
	 * @param countPerPage
	 * @return
	 */
	List<Unit> select(@Param("where") String where,
			  @Param("orderBy") String orderBy, 
			  @Param("offset") String offset,
			  @Param("offset") String countPerPage);
	
	/**
	 * 修改企业/单位信息
	 * @param unit
	 * @return
	 */
	Integer updateById(Unit unit);
	
	/**
	 * 删除企业/单位信息
	 * @param unitId
	 * @return
	 */
	Integer deleteById(Integer unitId);
}
