<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset=utf-8>
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no">
	<title>云监食安系统注册页</title>
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
							<a href="${pageContext.request.contextPath}/login" class="">已有账号？去登陆</a>
						</div>
						<div class="text-center margin-top margin-bot2"><a href="javascript:;" class="next_step btn btn-primary form-control" >下一步</a></div>
					</div>
					
					<div class="login_form1 inputbox margin-top3 margin-bot2">
						<h5 class="fonwei margin-bot2">完善信息：</h5>
						<div class="input-group form-group">
						  <span class="input-group-addon">企业名称</span>
						  <input type="text" class="form-control box-shadow0" id="unitName" name="unitName" placeholder="请输入企业名称 " aria-describedby="sizing-addon1">
						</div>
						<div class="input-group form-group">
						  <span class="input-group-addon" >统一社会信用代码</span>
						  <input type="text" class="form-control box-shadow0" id="businessLicenseCode" name="businessLicenseCode" placeholder="请输入统一社会信用代码" aria-describedby="sizing-addon1">
						</div>
						<div class="fsa border-bottom">							
							<div class="margin-bot2">								 
								<div class="fc">
									<div class="upload_imgs">
										<div class="fc tip_text">
											<div class="text-info">
												<div class="fc"> <i class="fa fa-plus padding-side05"></i> </div>
												<div class="text-center">上传营业执照</div>
											</div>
										</div>
										<input type="file" name="" id="fileinput" value="" accept="image/*"/>
										<img src="" id="preview">
									</div>
								</div>			
							</div>
							<div class="margin-bot2">
								  <div class="fc">
								  	<div class="upload_imgs">
										<div class="fc tip_text">
											<div class="text-info">
												<div class="fc"> <i class="fa fa-plus padding-side05"></i> </div>
												<div class="text-center">上传食品许可证</div>
											</div>
										</div>
										<input type="file" name="" id="fileinput1" value="" accept="image/*"/>
										<img src="" id="preview1">
									</div>
								  </div>
							</div>
						</div>	
						<div class="input-group form-group">
						  <span class="input-group-addon">企业类型</span>
						  	<select id="unitType" name="unitType" style=" height: 28px;">
								<option value="0">请选择企业类型</option>								
								<option value="2">学校</option>
								<option value="3">餐饮业</option>
								<option value="4">其他</option>
							</select>
						</div>				
						<div class="input-group form-group">
						  <span class="input-group-addon">营业地址</span>
						  <input type="text" class="form-control box-shadow0" id="unitAddress" name="unitAddress" placeholder="营业地址" aria-describedby="sizing-addon1">
						</div>
						
						<div class="input-group form-group">
						  <span class="input-group-addon">法人姓名</span>
						  <input type="text" class="form-control box-shadow0" id="legalPerson" name="legalPerson" placeholder="请输入法人姓名" aria-describedby="sizing-addon1">
						</div>
						<div class="margin-bot2 text-right">
							<a href="${pageContext.request.contextPath}/login"class="">已有账号？去登陆</a>
						</div>
						<div class="text-center margin-top2 margin-bot2"><button type="button" class="btn btn-primary form-control" id="register" value="注册">注册</button></div>
					</div>
				</form>
				
			</div>
		</div>
		<script>				
			$("#register").click(function() {
				if($("#unitName").val() == ""){
					layer.msg("请输入企业名称",{icon:2,time:1000});
					$("#unitName").focus();		
				}else if ($("#businessLicenseCode").val() == "") {
					layer.msg("请输入社会统一信用代码",{icon:2,time:1000});
					$("#businessLicenseCode").focus();		
				}else if($("#preview").attr('src') == ""){
					layer.msg("请输入上传营业执照",{icon:2,time:1000});							
				}else if($("#preview1").attr('src') == ""){
					layer.msg("请输入上传食品许可证",{icon:2,time:1000});							
				}else if($("#unitType").val() == 0){
					layer.msg("请选择企业类型",{icon:2,time:1000});
					$("#unitType").focus();		
				}else  if($("#unitAddress").val() == ""){
					layer.msg("请填写营业地址",{icon:2,time:1000});
					$("#unitAddress").focus();		
				}else if($("#legalPerson").val() == ""){
					layer.msg("请填写法人姓名",{icon:2,time:1000});
					$("#legalPerson").focus();		
				}else{
					var formData = new FormData();				
					formData.append('idCard',$("#idCard").val());
					formData.append('username',$("#username").val());
					formData.append('duty',$("#duty").val());
					formData.append('age',$("#age").val());
					formData.append('password',$("#password").val());
					formData.append('unitName',$("#unitName").val());	
					formData.append('businessLicenseCode',$("#businessLicenseCode").val());
					formData.append('businessLicense',$("#fileinput")[0].files[0]);
					formData.append('productionLicense',$("#fileinput1")[0].files[0]);
					formData.append('unitAddress',$("#unitAddress").val());					
					formData.append('unitType',$("#unitType").val());
					formData.append('legalPerson',$("#legalPerson").val());					
					 $.ajax({
						 url: 'registeradd',
				          type: 'POST',
				          cache: false,
				          data: formData,				        
				          processData: false,
				          contentType: false,
							"success" : function(obj) {
								if (obj.state == 0) {
									layer.msg(obj.message,{icon:2,time:1000});									 
									return;				
								}else{					
									layer.msg(obj.message,{icon:1,time:1000},function(){layer_close();});
									
									setTimeout(function (){							 
										window.location.href = "${pageContext.request.contextPath}/login";
									}, 3000);
								}
								
							}
						}); 
				}
			})
			$(".next_step").click(function() {
					if($("#idCard").val() == ""){				
						layer.msg("请输入18位身份证号码",{icon:2,time:1000});
						$("#idCard").focus();		
					}else if($("#username").val() == ""){
						layer.msg("请输入姓名",{icon:2,time:1000});
						$("#username").focus();		
					}else if ($("#duty").val() == "") {
						layer.msg("请输入职务",{icon:2,time:1000});
						$("#duty").focus();		
					}else  if($("#age").val() == ""){
						layer.msg("请填写年龄",{icon:2,time:1000});
						$("#age").focus();		
					}else if($("#password").val() == ""){
						layer.msg("请输入密码",{icon:2,time:1000});
						$("#password").focus();		
					}else if($("#password").val() != $("#newpassword").val()){
						layer.msg("两次输入的密码不一致",{icon:2,time:1000});
						$("#newpassword").focus();		
					}else {
						$(this).parents("form").find(".register_progress .prog2").addClass("cur");
						$(this).parents("form").find(".inputbox").removeClass("cur");
						$(this).parents("form").find(".login_form1").addClass("cur");
					}
			})
		</script>
		
	</body>
	<script type="text/javascript">
					$("#fileinput").on("change",function() {
						changepic("fileinput","preview");						
					})
					$("#fileinput1").on("change",function() {						
						changepic("fileinput1","preview1");
					})
					function changepic(fid,img_id) {
						 var reads = new FileReader();
						 f = document.getElementById(fid).files[0];
						 reads.readAsDataURL(f);
						 reads.onload = function(e) {
						 document.getElementById(img_id).src = this.result;
						 $("#"+img_id).css("display", "block");
						 };
					}
				</script>
</html>
