package cn.dibcbks.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import cn.dibcbks.entity.Disinfection;

public interface DisinfectionMapper {
	
	Integer insert(Disinfection user);
	
	List<Disinfection> select(@Param("where") String where,
					  @Param("orderBy") String orderBy, 
					  @Param("offset") String offset,
					  @Param("offset") String countPerPage);
	
	Disinfection queryUser(@Param("idCard")String idCard);
	
	Disinfection updateById(Disinfection user);
	
	Integer deleteById(Integer id);
}
