<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset=utf-8>
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no">
	<title>健康信息添加</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/bks_wap/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/fonts/font-awesome-4.7.0/css/font-awesome.min.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/bks_wap/style.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/bks_wap/index.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/js/layui/css/layui.css">
	<script  type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.1.1.min.js"></script>
	<script  type="text/javascript" src="${pageContext.request.contextPath}/static/js/layer/2.4/layer.js"></script>
	<script  type="text/javascript" src="${pageContext.request.contextPath}/static/js/layui/layui.js"></script>	
</head>
	<body class="contain">
		<div class="navigation bg-primary">
			<div class="fb padding-side">
				<a href="javascript:history.go(-1)" class="text-white"><i class="fa fa-angle-left"></i></a>
			</div>
		</div>
		
		<main class="main padding-side05 workmen_health_detal">
			<form action="" method="" class="clearfix margin-top">
			
				<div class="margin-bot2">
					<div class="input-group form-group border-bottom">
					  <span class="input-group-addon border0 clear-bg fonwei" id="sizing-addon1">姓名</span>
					   <div class="form-control box-shadow0 border0">${hygieneDetail.username }</div>
					</div>
					<div class="input-group form-group border-bottom">
					  <span class="input-group-addon border0 clear-bg fonwei" id="sizing-addon1">测温日期</span>
					   <div class="form-control box-shadow0 border0">${hygieneDetail.dailyTime }</div>
					</div>
					<div class="input-group form-group border-bottom">
					  <span class="input-group-addon border0 clear-bg fonwei" id="sizing-addon1">体测温度</span>
					   <div class="form-control box-shadow0 border0">${hygieneDetail.celsius }</div>
					</div>
					<div class="input-group form-group border-bottom">
					  <span class="input-group-addon border0 clear-bg fonwei" id="sizing-addon1">发热</span>
					   <div class="form-control box-shadow0 border0">${hygieneDetail.fever }</div>
					</div>
					<div class="input-group form-group border-bottom">
					  <span class="input-group-addon border0 clear-bg fonwei" id="sizing-addon1">腹泻</span>
					  <div class="form-control box-shadow0 border0">${hygieneDetail.diarrhea }</div>
					</div>
					<div class="input-group form-group border-bottom">
					  <span class="input-group-addon border0 clear-bg fonwei" id="sizing-addon1">伤口化脓</span>
					  <div class="form-control box-shadow0 border0">${hygieneDetail.woundsFester }</div>
					</div>
					<div class="input-group form-group border-bottom">
					  <span class="input-group-addon border0 clear-bg fonwei" id="sizing-addon1">个人卫生</span>
					  <div class="form-control box-shadow0 border0">${hygieneDetail.hygiene }</div>
					</div>					
					<div class="input-group form-group border-bottom">
					  <span class="input-group-addon border0 clear-bg fonwei" id="sizing-addon1">备注</span>
					  <div class="form-control box-shadow0 border0">${hygieneDetail.remark }</div>
					</div>
					<div class="input-group form-group border-bottom">
					  <span class="input-group-addon border0 clear-bg fonwei" id="sizing-addon1">上传时间</span>
					  <div class="form-control box-shadow0 border0"><fmt:formatDate value="${hygieneDetail.uploadTime}" pattern="yyyy-MM-dd HH:mm:ss" /></div>
					</div>
					<div class="">
					  <span class="input-group-addon border0 clear-bg" id="sizing-addon1">健康码图片</span>
					  <div class="fc">
					  	<div class="layui-upload-list">
					  		<img class="layui-upload-img" id="demo1" src="${pageContext.request.contextPath}${hygieneDetail.healthCodePhoto}">
					  	</div>
					  </div>
					</div>
					<!-- <div class="layui-upload input-group form-group">
					  <label for="demo1" class="input-group-addon border0 clear-bg" id="test1">健康码图片</label>
					  <div class="layui-upload-list">
					    <img class="layui-upload-img" id="demo1">
					    <p id="demoText"></p>
					  </div>
					</div> -->
				</div>
			</form>
			
			<!-- <div class="margin-top2 margin-bot2">
				<button type="button" class="btn btn-primary form-control">保存</button>
			</div> -->
		</main>
		<script  type="text/javascript" src="${pageContext.request.contextPath}/static/js/bks_wap/imgBase64.js"></script>		
		<script type="text/javascript">
			/* console.log('${hygieneDetail}'); */
			var $current = $("form");		
			$current.find("img").bind("click",function(){
				var path=$(this).attr('src');			
				layerImg(path);
			});	
			layui.use('upload', function(){
			  var $ = layui.jquery
			  ,upload = layui.upload;
			  
			  //普通图片上传
			  var uploadInst = upload.render({
			    elem: '#test1'
			    ,url: 'https://httpbin.org/post' //改成您自己的上传接口
			    ,before: function(obj){
			      //预读本地文件示例，不支持ie8
			      obj.preview(function(index, file, result){
			        $('#demo1').attr('src', result); //图片链接（base64）
			      });
			    }
			    ,done: function(res){
			      //如果上传失败
			      if(res.code > 0){
			        return layer.msg('上传失败');
			      }
			      //上传成功
			    }
			    ,error: function(){
			      //演示失败状态，并实现重传
			      var demoText = $('#demoText');
			      demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
			      demoText.find('.demo-reload').on('click', function(){
			        uploadInst.upload();
			      });
			    }
			  });
			  });
		</script>	
	<c:import url="public/footer.jsp"></c:import>
	</body>

</html>
