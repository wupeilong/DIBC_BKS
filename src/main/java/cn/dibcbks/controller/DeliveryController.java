package cn.dibcbks.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 配送控制器
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/dry")
public class DeliveryController {
		
	/**
	 * 进入配送信息列表页
	 * @return
	 */
	@RequestMapping("/delivery")
	public String delivery(){		
		return "bks_wap/delivery";
	}
	/**
	 * 进入配送信息详情页
	 * @return
	 */
	@RequestMapping("/delivery_detal")
	public String deliveryDetal(){		
		return "bks_wap/delivery_detal";
	}
	/**
	 * 进入配送信息添加页
	 * @return
	 */
	@RequestMapping("/delivery_add")
	public String deliveryAdd(){		
		return "bks_wap/delivery_add";
	}

}
