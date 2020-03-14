package cn.dibcbks.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import cn.dibcbks.entity.Check;

public interface CheckMapper {
	
	Integer insert(Check check);
	
	List<Check> select(@Param("where") String where,
					  @Param("orderBy") String orderBy, 
					  @Param("offset") String offset,
					  @Param("offset") String countPerPage);
	
	Check queryUser(@Param("id")String id);
	
	Check updateById(Check check);
	
	Integer deleteById(Integer id);
}
