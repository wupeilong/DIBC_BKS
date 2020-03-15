<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset=utf-8>
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no">
	<title>配送信息</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/bks_wap/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/bks_wap/style.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/bks_wap/index.css"/>
	<script  type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.1.1.min.js"></script>
	<script  type="text/javascript" src="${pageContext.request.contextPath}/static/js/layer/2.4/layer.js"></script>		
</head>
	<body class="bg-info container">
		<div class="container">
			<div class="text-center margin-top2">
				<h3 class="fonwei">云岩区市场监督管理局</h3>
			</div>
			<div class="margin-top3">
				<form class="">
					<legend>用户注册</legend>
					<div class="register_progress fc" style="background-image: url();">
						<img src="${pageContext.request.contextPath}/static/images/bks_wap/progress.png" class="width100">
						<div class="progbox clearfix">
							<div class="prog prog1 cur"></div>
							<div class="prog prog2"></div>
						</div>
					</div>
					<div class="login_form inputbox cur margin-top3 margin-bot">
						<h5 class="fonwei margin-bot2">填写注册资料：</h5>
						<div class="input-group form-group">
						  <span class="input-group-addon">身份证号</span>
						  <input type="text" class="form-control box-shadow0" id="idCard" name="idCard" placeholder="请输入身份证号" aria-describedby="sizing-addon1">
						</div>						
						<div class="input-group form-group">
						  <span class="input-group-addon">真实姓名</span>
						  <input type="text" class="form-control box-shadow0" id="username" name="username" placeholder="请输入真实姓名" aria-describedby="sizing-addon1">
						</div>
						<div class="input-group form-group">
						  <span class="input-group-addon">职务</span>
						  <input type="text" class="form-control box-shadow0" id="duty" name="duty" placeholder="请输入职务" aria-describedby="sizing-addon1">
						</div>
						<div class="input-group form-group">
						  <span class="input-group-addon">年龄</span>
						  <input type="text" class="form-control box-shadow0" id="age" name="age" placeholder="请输入年龄" aria-describedby="sizing-addon1">
						</div>
						<div class="input-group form-group">
						  <span class="input-group-addon">密码</span>
						  <input type="text" class="form-control box-shadow0" id="password" name="password" placeholder="请输入密码" aria-describedby="sizing-addon1">
						</div>
						<div class="input-group form-group">
						  <span class="input-group-addon">确认密码</span>
						  <input type="text" class="form-control box-shadow0" id="newpassword" name="newpassword" placeholder="请确认密码" aria-describedby="sizing-addon1">
						</div>
						<div class="margin-bot2 text-right">
							<a href="http://192.168.1.106:8848/wap_MCLZ/login.html" class="">已有账号？去登陆</a>
						</div>
						<div class="text-center margin-top margin-bot2"><a href="javascript:;" class="next_step btn btn-primary form-control" >下一步</a></div>
					</div>
					
					<div class="login_form1 inputbox margin-top3 margin-bot2">
						<h5 class="fonwei margin-bot2">完善个人信息：</h5>
						<div class="input-group form-group">
						  <span class="input-group-addon">企业名称</span>
						  <input type="text" class="form-control box-shadow0" name="account" placeholder="请输入企业名称 " aria-describedby="sizing-addon1">
						</div>
						<div class="input-group form-group">
						  <span class="input-group-addon" >统一社会信用代码</span>
						  <input type="text" class="form-control box-shadow0" name="account" placeholder="请输入统一社会信用代码" aria-describedby="sizing-addon1">
						</div>
						<div class="fsa border-bottom">
							
							<div class="margin-bot2">
								  <div class="fc">
								  	<div class="layui-upload-list fc">
								  	  <label for="demo1" class="input-group-addon border0 clear-bg" id="test1"><i class="fa fa-plus padding-side05"></i>营业执照</label>
								  	  <img class="layui-upload-img" id="demo1">
								  	  <p id="demoText"></p>
								  	</div>
								  </div>
							</div>
							<div class="margin-bot2">
								  <div class="fc">
								  	<div class="layui-upload-list fc">
								  	  <label for="demo2" class="input-group-addon border0 clear-bg" id="test2"><i class="fa fa-plus padding-side05"></i>食品许可证</label>
								  	  <img class="layui-upload-img" id="demo2">
								  	  <p id="demoText2"></p>
								  	</div>
								  </div>
							</div>
						</div>
						<div class="input-group form-group">
						  <span class="input-group-addon">到期日期</span>
						  <input type="text" class="form-control box-shadow0" name="account" placeholder="请输入企业名称" aria-describedby="sizing-addon1">
						</div>
						<div class="input-group form-group">
						  <span class="input-group-addon">营业地址</span>
						  <input type="text" class="form-control box-shadow0" name="account" placeholder="请输入统一社会信用代码" aria-describedby="sizing-addon1">
						</div>
						<div class="input-group form-group">
						  <span class="input-group-addon">企业类型</span>
						  <input type="text" class="form-control box-shadow0" name="account" placeholder="请输入统一社会信用代码" aria-describedby="sizing-addon1">
						</div>
						<div class="input-group form-group">
						  <span class="input-group-addon">法人姓名</span>
						  <input type="text" class="form-control box-shadow0" name="account" placeholder="请输入统一社会信用代码" aria-describedby="sizing-addon1">
						</div>
						<div class="text-center margin-top2 margin-bot2"><button type="button" class="btn btn-primary form-control" id="register" value="注册">注册</button></div>
					</div>
				</form>
				
			</div>
		</div>
		<script>
			$(".next_step").click(function() {
				 if ($("#duty").val() == "") {
						layer.msg("请输入职务",{icon:2,time:1000});
						$("#duty").focus();		
					}else if($("#username").val() == ""){
						layer.msg("请输入姓名",{icon:2,time:1000});
						$("#username").focus();		
					}else if($("#idCard").val() == ""){				
						layer.msg("请输入18位身份证号码",{icon:2,time:1000});
						$("#idCard").focus();		
					}else if($("#age").val() == ""){
						layer.msg("请填写年龄",{icon:2,time:1000});
						$("#age").focus();		
					}else if($("#healthCertificateCode").val() == ""){
						layer.msg("请输入健康证编号",{icon:2,time:1000});
						$("#healthCertificateCode").focus();		
					}else if($("#preview").attr('src') == ""){
						layer.msg("请输入上传健康证",{icon:2,time:1000});
						$("#preview").focus();		
					}else{
						
					}
				$(this).parents("form").find(".register_progress .prog2").addClass("cur");
				$(this).parents("form").find(".inputbox").removeClass("cur");
				$(this).parents("form").find(".login_form1").addClass("cur");
			})			
		</script>
	</body>
</html>
