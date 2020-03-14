package cn.dibcbks.service;

import org.springframework.web.multipart.MultipartFile;

import cn.dibcbks.util.ResponseResult;

public interface IUploadService {

	ResponseResult<String> uploadFile(MultipartFile file, String idCard);

}
