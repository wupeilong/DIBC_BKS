package cn.dibcbks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import cn.dibcbks.service.IUploadService;
import cn.dibcbks.util.ResponseResult;

@Controller
@RequestMapping("/file")
public class UploadController {
	@Autowired
	private IUploadService IUploadService;
	
	/**
	 * 文件上传
	 * @param file 文件名
	 * @param idCard 身份证号
	 * @return
	 */
	@PostMapping("/upload")
	@ResponseBody
	public ResponseResult<String> uploadFiesle(
			@RequestParam("file") MultipartFile file,
			@RequestParam("idCard") String idCard){
		System.out.println("idCard：" + idCard);
		return IUploadService.uploadFile(file,idCard);
	}
	
}
