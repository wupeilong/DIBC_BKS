package cn.dibcbks.test;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.dibcbks.entity.Unit;
import cn.dibcbks.entity.User;
import cn.dibcbks.mapper.UnitMapper;
import cn.dibcbks.mapper.UserMapper;
import cn.dibcbks.service.IUserService;
import cn.dibcbks.util.CommonUtil;
import cn.dibcbks.util.Constants;
import cn.dibcbks.util.ResponseResult;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-mapper.xml","classpath:spring-mvc.xml"})
public class TestDemo {
	@Autowired 
	private IUserService iUserService;
	@Autowired 
	private UserMapper userMapper;
	@Autowired 
	private UnitMapper unitMapper;
	
	@Test
	public void test(){
//		ResponseResult<Void> userIsExist = iUserService.userIsExist("123");
//		System.out.println("状态：" + userIsExist.getState());
//		System.out.println("消息：" + userIsExist.getMessage());
//		
//		Unit unit = new Unit();
//		unit.setUnitName("贵州随机森林科技有限责任公司");
//		unit.setLegalPerson("吴培龙");
//		unit.setBusinessLicenseCode("19921001");
//		unit.setBusinessLicense("http://www.gzws.online");
//		unit.setProductionLicense("http://www.gzws.online");
//		unit.setUnitAddress("贵州黔东南");
//		unit.setExpirationDate(new Date());
//		unit.setUnitType(1);
//		unitMapper.insert(unit);
//		
//		String password = "wpl1201314";
//		String uuid = CommonUtil.getUUID();
//		String hashPassword = CommonUtil.getEncrpytedPassword(Constants.MD5, password, uuid, 1024);
//		User user = new User();
//		user.setIdCard("522601199210015432");
//		user.setUsername("吴培龙");
//		user.setUuid(uuid);
//		user.setPassword(hashPassword);
//		user.setDuty("采购员");
//		user.setAge(27);
//		user.setParentId(0);//父级ID: 默认 0
//		user.setType(2);//用户类型：1-监管 2-企业
//		user.setUnitId(unit.getUniId());
//		userMapper.insert(user);
//		System.out.println("用户信息" + user);
//		System.out.println("企业信息" + unit);
		
//		System.out.println(userMapper.queryUser("522601199210015432"));
//		System.out.println(unitMapper.queryUnit("19921001"));
		
		ResponseResult<Void> login = iUserService.login("522601199210015432", "wpl1201314");
		System.err.println(login.getState() + " " + login.getMessage());
	}
	
} 