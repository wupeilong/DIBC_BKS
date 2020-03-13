package cn.dibcbks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import cn.dibcbks.service.IUserService;
import cn.dibcbks.util.ResponseResult;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService iUserService;
	
	@RequestMapping("/isExist.do")
	private ResponseResult<Void> userIsExist(@RequestParam(value = "idCard",required = true) String idCard){
		return iUserService.userIsExist(idCard);
	}
}
