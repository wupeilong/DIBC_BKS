<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset=utf-8>
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no">
	<title>添加清洗消毒记录</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/bks_wap/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/fonts/font-awesome-4.7.0/css/font-awesome.min.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/bks_wap/style.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/bks_wap/index.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/js/layui/css/layui.css"/>
	<script  type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.1.1.min.js"></script>
	<script  type="text/javascript" src="${pageContext.request.contextPath}/static/js/layui/layui.js"></script>		
</head>
	<body class="contain">
		<div class="navigation bg-primary">
			<div class="fb padding-side">
				<a href="javascript:history.go(-1)" class="text-white"><i class="fa fa-angle-left"></i></a>
			</div>
		</div>
		<main class="main margin-top2 padding-side05">
			<form action="" method="post">
				<legend class="text-center border0">餐饮具、工具及保洁设施清洗消毒记录</legend>
				<fieldset>
					<div class="">
						<table class="table table-bordered" cellspacing="" cellpadding="">
							<caption class="">
								<span class="col-xs-6">消毒人员：</span>
								<span class="col-xs-6">消毒日期：</span>
							</caption>
							<thead>
								<tr><th colspan="2">消毒项目</th><th colspan="2">消毒结果</th></tr>
							</thead>
							<tbody>
								<tr><td rowspan="4">餐(炊)具种类</td><td>小餐具类</td><td>是：<input type="checkbox" name="" id="" value="" /></td><td>否：<input type="checkbox" name="" id="" value="" /></td></tr>
								<tr><td>大餐具类</td><td>是：<input type="checkbox" name="" id="" value="" /></td><td>否：<input type="checkbox" name="" id="" value="" /></td></tr>
								<tr><td>筷子、勺子类</td><td>是：<input type="checkbox" name="" id="" value="" /></td><td>否：<input type="checkbox" name="" id="" value="" /></td></tr>
								<tr><td>锅、盆类</td><td>是：<input type="checkbox" name="" id="" value="" /></td><td>否：<input type="checkbox" name="" id="" value="" /></td></tr>
								
								<tr><td colspan="2">工具类</td><td>是：<input type="checkbox" name="" id="" value="" /></td><td>否：<input type="checkbox" name="" id="" value="" /></td></tr>
								<tr><td colspan="2">餐具保洁设施</td><td>是：<input type="checkbox" name="" id="" value="" /></td><td>否：<input type="checkbox" name="" id="" value="" /></td></tr>
								<tr><td rowspan="2">消毒方法</td><td>电子消毒柜</td><td>是：<input type="checkbox" name="" id="" value="" /></td><td>否：<input type="checkbox" name="" id="" value="" /></td></tr>
								<tr><td>消毒药水</td><td>是：<input type="checkbox" name="" id="" value="" /></td><td>否：<input type="checkbox" name="" id="" value="" /></td></tr>
								<tr>
									<td colspan="2">消毒时间</td>
									<td colspan="2">
										<div class="">
											<input readonly="" class="form-control" type="text" id="date-group1-6" placeholder="hh:mm">
										</div>
										<!-- <select name="">
											<option value="">请选择时间</option>
										</select> -->
									</td>
								</tr>
							</tbody>
						</table>
					</div>
				  </fieldset>
			</form>
			<div class="margin-top2 margin-bot2">
				<button type="button" class="btn btn-primary form-control">提交</button>
			</div>
		</main>		
		<script src="${pageContext.request.contextPath}/static/js/bks_wap/rolldate.min.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			new Rolldate({
				el: '#date-group1-6',
				format: 'hh:mm'
			})
			
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
