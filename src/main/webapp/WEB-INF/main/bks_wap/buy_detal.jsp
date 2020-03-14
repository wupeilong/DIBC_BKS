<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset=utf-8>
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no">
	<title>从业人员信息添加</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/bks_wap/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/fonts/font-awesome-4.7.0/css/font-awesome.min.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/bks_wap/style.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/bks_wap/index.css"/>
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
			<div class="">
				<div class="input-group form-group fs border-bottom">
				  <span class="input-group-addon border0 clear-bg fonwei" id="sizing-addon1">供应商营业执照</span>
				  <div class="form-control box-shadow0 border0">老干妈</div>
				</div>
				<div class="input-group form-group fs border-bottom">
				  <span class="input-group-addon border0 clear-bg fonwei" id="sizing-addon1">食品经营许可证</span>
				  <div class="form-control box-shadow0 border0">老干妈</div>
				</div>
				<div class="input-group form-group fs border-bottom">
				  <span class="input-group-addon border0 clear-bg fonwei" id="sizing-addon1">经营资质</span>
				  <div class="form-control box-shadow0 border0">老干妈</div>
				</div>
				<div class="input-group form-group fs border-bottom">
				  <span class="input-group-addon border0 clear-bg fonwei" id="sizing-addon1">商品名称</span>
				  <div class="form-control box-shadow0 border0">老干妈</div>
				</div>
				<div class="input-group form-group fs border-bottom">
				  <span class="input-group-addon border0 clear-bg fonwei" id="sizing-addon1">计量规格</span>
				  <div class="form-control box-shadow0 border0">老干妈</div>
				</div>
				<div class="input-group form-group fs border-bottom">
				  <span class="input-group-addon border0 clear-bg fonwei" id="sizing-addon1">联&ensp;系&ensp;人</span>
				  <div class="form-control box-shadow0 border0">老干妈</div>
				</div>
				
				<div class="">
					<table class="table table-striped table-bordered table-hover" cellspacing="" cellpadding="">
						<caption>供货明细：</caption>
						<thead>
							<tr><th>序号</th><th>商品名</th><th>数量</th><th>生产日期</th><th>验收结果</th></tr>
						</thead>
						<tbody>
							<tr>
								<td>1</td><td>白菜</td><td>一大车</td><td>03-12</td>
								<td>
									<select name="">
										<option value="">请选择</option>
										<option value="">合格</option>
										<option value="">不合格</option>
									</select>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				
				<div class="">
					  <div class="fc">
						<div class="layui-upload-list fc">
						  <img class="layui-upload-img" src="">
						</div>
					  </div>
					  <div class="text-center">采购凭证（发票/收据）</div>
				</div>
				
			 </div>
			 
			<div class="margin-top2 margin-bot2">
				<a href="javascript:;" class="btn btn-primary form-control">确定验收</a>
			</div>
		</main>		
		<script type="text/javascript">
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
