package cn.dibcbks.service.impl;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import cn.dibcbks.entity.User;
import cn.dibcbks.service.IUploadService;
import cn.dibcbks.util.Constants;
import cn.dibcbks.util.ResponseResult;
import cn.dibcbks.util.UploadUtil;

@Service
public class IUploadServiceImpl implements IUploadService {
	private static final Logger logger = LogManager.getLogger(IUploadServiceImpl.class.getName());
	@Override
	public ResponseResult<String> uploadFile(MultipartFile file, String idCard) {
		ResponseResult<String> rr = null;
		try {
			System.out.println("idCard：" + idCard);
			if(StringUtils.isEmpty(idCard)){
				Subject subject = SecurityUtils.getSubject();
				if (!subject.isAuthenticated()) {
					rr = new ResponseResult<>(ResponseResult.ERROR,"文件上传操作失败！");
					logger.error(Constants.ERROR_HEAD_INFO + "文件上传失败，原因： 用户未登录！");
				}else {
					User user = (User)subject.getSession().getAttribute("user");
					String url = UploadUtil.uplaodFile(file, user.getIdCard());
					rr = new ResponseResult<String>(ResponseResult.SUCCESS,"文件上传成功！",url);
					logger.error(Constants.SUCCESSU_HEAD_INFO + "文件上传成功！");
				}
			}else{
				String url = UploadUtil.uplaodFile(file, idCard);
				rr = new ResponseResult<String>(ResponseResult.SUCCESS,"文件上传成功！",url);
				logger.error(Constants.SUCCESSU_HEAD_INFO + "文件上传成功！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			rr = new ResponseResult<>(ResponseResult.ERROR,"文件上传操作失败！");
			logger.error(Constants.ERROR_HEAD_INFO + "文件上传失败，原因： " + e.getMessage());
		}
		return rr;
	}
	
}
