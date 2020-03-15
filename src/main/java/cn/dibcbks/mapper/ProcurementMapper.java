package cn.dibcbks.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import cn.dibcbks.entity.Procurement;
import cn.dibcbks.entity.ProcurementDetail;


public interface ProcurementMapper {
	/**
	 * 新增采购信息
	 * @param unit
	 * @return
	 */
	Integer insertProcurement(Procurement procurement);
	
	/**
	 * 新增采购详情信息
	 * @param unit
	 * @return
	 */
	Integer insertProcurementDetail(ProcurementDetail procurementDetail);
	
	/**
	 * 查询采购信息
	 * @param businessLicenseCode
	 * @return
	 */
	Procurement queryProcurement(Integer id);
	
	/**
	 * 查询采购信息列表
	 * @param where
	 * @param orderBy
	 * @param offset
	 * @param countPerPage
	 * @return
	 */
	List<Procurement> select(@Param("where") String where,
			  @Param("orderBy") String orderBy,
			  @Param("offset") String offset,
			  @Param("offset") String countPerPage);
	
	/**
	 * 修改采购信息
	 * @param unit
	 * @return
	 */
	Integer updateProcurementById(Procurement procurement);
	
	/**
	 * 修改采购详情信息
	 * @param unit
	 * @return
	 */
	Integer updateProcurementDetailById(ProcurementDetail procurementDetail);
	
	/**
	 * 删除采购信息
	 * @param unitId
	 * @return
	 */
	Integer deleteProcurementById(Integer id);
	
	/**
	 * 删除采购详情信息
	 * @param unitId
	 * @return
	 */
	Integer deleteProcurementDetailById(Integer procurementId);
}
