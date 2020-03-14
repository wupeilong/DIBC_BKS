package cn.dibcbks.util;



import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;


public class UploadUtil {
	/**
	 * 上传文件
	 * @param file 文件流
	 * @param packageName 文件包名
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	public static String uplaodFile(MultipartFile file,String packageName) throws IOException{
		//项目路径
		String path = CommonUtil.getPath();
		File oldFile = new File(path + "/static/images/" + packageName);
		//文金价是否存在
		if (!oldFile.exists()) {
			oldFile.mkdirs();	       			
	    }
		//文件储存路径
		String url = "/static/images/" + packageName 
				   + "/" + new StringBuilder(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())) 
				   + "." + FilenameUtils.getExtension(file.getOriginalFilename());
		file.transferTo(new File(path + url));
		return url;
	}
	
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
	}
}
