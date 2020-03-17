<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset=utf-8>
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no">
	<title>监管人员注册</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/bks_wap/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/fonts/font-awesome-4.7.0/css/font-awesome.min.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/bks_wap/style.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/bks_wap/index.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/js/layui/css/layui.css"/>
	<script  type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.1.1.min.js"></script>
	<script  type="text/javascript" src="${pageContext.request.contextPath}/static/js/layui/layui.js"></script>
	<script  type="text/javascript" src="${pageContext.request.contextPath}/static/js/layer/2.4/layer.js"></script>	
</head>
	<body class="contain">
		<div class="navigation bg-primary">
			<div class="fb padding-side">
				<a href="javascript:history.go(-1)" class="text-white"><i class="fa fa-angle-left"></i></a>
			</div>
		</div>
		<main class="main margin-top padding-side">
			<form action="" method="" class="clearfix">
				<div class="workmens_info_top margin-bot">
					<div class="input-group form-group fs">
					  <span class="input-group-addon border0 clear-bg"><i class="padding-side05 text-danger vertical-mid">*</i>身份证号</span>
					  <input type="text" class="form-control box-shadow0 border-bottom" name="idCard" placeholder="请输入设身份证号" aria-describedby="sizing-addon1">
					</div>
					<div class="input-group form-group fs">
					  <span class="input-group-addon border0 clear-bg"><i class="padding-side05 text-danger vertical-mid">*</i>密&ensp;&ensp;&ensp;&ensp;码</span>
					  <input type="password" class="form-control box-shadow0 border-bottom" name="password" placeholder="请输入密码" aria-describedby="sizing-addon1">
					</div>
					<div class="input-group form-group fs">
					  <span class="input-group-addon border0 clear-bg"><i class="padding-side05 text-danger vertical-mid">*</i>确认密码</span>
					  <input type="password" class="form-control box-shadow0 border-bottom" name="repassword" placeholder="请再次输入密码" aria-describedby="sizing-addon1">
					</div>
					<div class="input-group form-group fs">
					  <span class="input-group-addon border0 clear-bg"><i class="padding-side05 text-danger vertical-mid">*</i>姓&ensp;&ensp;&ensp;&ensp;名</span>
					  <input type="text" class="form-control box-shadow0 border-bottom" name="username" placeholder="请输入姓名" aria-describedby="sizing-addon1">
					</div>
					<div class="input-group form-group fs">
					  <span class="input-group-addon border0 clear-bg"><i class="padding-side05 text-danger vertical-mid">*</i>电&ensp;&ensp;&ensp;&ensp;话</span>
					  <input type="text" class="form-control box-shadow0 border-bottom" name="phone" placeholder="请输入电话" aria-describedby="sizing-addon1">
					</div>
					<div class="input-group form-group fs">
					  <span class="input-group-addon border0 clear-bg"><i class="padding-side05 text-danger vertical-mid">*</i>职&ensp;&ensp;&ensp;&ensp;务</span>
					  <input type="text" class="form-control box-shadow0 border-bottom" name="duty" placeholder="请输入职务" aria-describedby="sizing-addon1">
					</div>
				</div>
				
			</form>
			
			<div class="margin-top2 margin-bot2">
				<button type="button" id="register" class="btn btn-primary form-control">注册</button>
			</div>
		</main>
		<div class="tabBar">
			<ul class="list-unstyled clearfix margin0">
				<li><a href="http://192.168.1.106:8848/wap_MCLZ/home.html"><div><i class="fa fa-home"></i><div>工作台</div></div></a></li>
				<li><a href=""><div><i class="fa fa-user"></i><div>个人中心</div></div></a></li>
			</ul>
		</div>
		<script>			
			$("#register").click(function() {
				var idCard=$("input[name=idCard]").val();
				  var password=$("input[name='password']").val();
				  var repassword=$("input[name='repassword']").val();
				  var username=$("input[name='username']").val();
				  var phone=$("input[name='phone']").val();
				  var duty=$("input[name='duty']").val();
				  var judge = /[a-zA-Z0-9]{6,12}/;
				  var mobileReg = /(^1[3|4|5|7|8|9]\d{9}$)|(^09\d{8}$)/;
				  var nameReg = /^[\u4E00-\u9FA5]{2,4}$/;
				  var idCard_judge=/^[1-9]\d{5}(18|19|([23]\d))\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$/;
				 if(idCard=='' || password=='' || repassword=='' || username=='' || phone=='' || duty==''){
					  layer.msg('请完善信息后再进行操作',{icon:2,time:1000});					
				}else	if (!idCard_judge.test(idCard)) {
					  layer.msg("输入的身份证号不合法",{icon:2,time:1000});						
				}else if (!judge.test(password)) {
					  layer.msg("输入的密码不合法",{icon:2,time:1000});						
				}else if (password != repassword) {
					 layer.msg("两次密码不一致",{icon:2,time:1000});
				}else  if (!nameReg.test(username)) {
					  layer.msg("输入的姓名不合法",{icon:2,time:1000});						
				}else if (!mobileReg.test(phone)) {
					  layer.msg("输入的手机号不合法",{icon:2,time:1000});						
				}else {
					$.ajax({
						url:"admin_add",
						type:"post",
						data:$('form').serialize(),
						// data:{'username':username,'password':password},
						dataType:"json",
						"success" : function(obj) {
							if (obj.state == 0) {
								layer.msg(obj.message,{icon:2,time:1000});									 
								return;				
							}else{					
								layer.msg(obj.message,{icon:1,time:1000},function(){location.href="login"});							
							}
						}
					})
				}				
			})
		</script>
	</body>
</html>
