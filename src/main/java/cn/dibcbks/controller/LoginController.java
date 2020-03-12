package cn.dibcbks.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 登录控制器
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/")
public class LoginController {
	
	@RequestMapping("/index.do")
	public String loginIndex(){
		//TODO 更换登录页 
		return "index";
	}
}
