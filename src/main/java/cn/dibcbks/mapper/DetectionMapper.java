package cn.dibcbks.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import cn.dibcbks.entity.Detection;

public interface DetectionMapper {
	Integer insert(Detection detection);
	
	List<Detection> select(@Param("where") String where,
					  @Param("orderBy") String orderBy, 
					  @Param("offset") String offset,
					  @Param("offset") String countPerPage);
	
	Detection queryDetection(@Param("id")Integer id);
	
	Integer updateById(Detection detection);
	
	Integer deleteById(Integer id);
}
