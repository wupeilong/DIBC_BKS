package cn.dibcbks.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import cn.dibcbks.entity.User;

public interface UserMapper {
	/**
	 * 新增用户信息
	 * @param user
	 * @return
	 */
	Integer insert(User user);
	
	/**
	 * 查询用户列表信息 
	 * @param where
	 * @param orderBy
	 * @param offset
	 * @param countPerPage
	 * @return
	 */
	List<User> select(
			@Param("where")String where,
			@Param("orderBy")String orderBy,
			@Param("offset")Integer offset,
			@Param("countPerPage")Integer countPerPage);	

	
	/**
	 * 查询单个用户(用于登陆验证)
	 * @param phone
	 * @return
	 */
	User queryUser(@Param("account")String account);
	
	
	/**
	 * 修改用户信息
	 * @param phone
	 * @return
	 */
	Integer updateById(User user);
	
	
	/**
	 * 删除用户信息
	 * @param phone
	 * @return
	 */
	Integer deleteById(@Param("id")Integer id);
}
