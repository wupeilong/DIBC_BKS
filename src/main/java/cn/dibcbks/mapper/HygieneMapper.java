package cn.dibcbks.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import cn.dibcbks.entity.Hygiene;


public interface HygieneMapper {
	Integer insert(Hygiene hygiene);
	
	List<Hygiene> select(@Param("where") String where,
					  @Param("orderBy") String Hygiene, 
					  @Param("offset") String offset,
					  @Param("offset") String countPerPage);
	
	Hygiene queryHygiene(@Param("hygieneId")Integer hygieneId);
	
	Hygiene updateById(Hygiene hygiene);
	
	Integer deleteById(Integer id);
}
