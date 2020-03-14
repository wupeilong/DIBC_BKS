package cn.dibcbks.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import cn.dibcbks.entity.Distribution;


public interface DistributionMapper {
	
	Integer insert(Distribution distribution);
	
	List<Distribution> select(@Param("where") String where,
					  @Param("orderBy") String orderBy, 
					  @Param("offset") String offset,
					  @Param("offset") String countPerPage);
	
	Distribution queryUser(@Param("id")String id);
	
	Distribution updateById(Distribution distribution);
	
	Integer deleteById(Integer id);
}
