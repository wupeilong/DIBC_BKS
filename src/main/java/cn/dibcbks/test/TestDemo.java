package cn.dibcbks.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import cn.dibcbks.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-mapper.xml","classpath:spring-mvc.xml"})
public class TestDemo {
	@Autowired 
	private IUserService iUserService;
	
	@Test
	public void test(){
		System.out.println("用户：" + iUserService.userIsExist("123").toString());
	}
	
} 