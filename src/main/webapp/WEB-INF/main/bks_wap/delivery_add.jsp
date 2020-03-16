<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset=utf-8>
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no">
	<title>配送信息添加</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/bks_wap/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/fonts/font-awesome-4.7.0/css/font-awesome.min.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/bks_wap/style.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/bks_wap/index.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/js/layui/css/layui.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/js/selector/jquery.searchableSelect.css"/>
	<script  type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.1.1.min.js"></script>
	<script  type="text/javascript" src="${pageContext.request.contextPath}/static/js/layui/layui.js"></script>
	<script  type="text/javascript" src="${pageContext.request.contextPath}/static/js/selector/jquery.searchableSelect.js"></script>
	<script  type="text/javascript" src="${pageContext.request.contextPath}/static/js/layer/2.4/layer.js"></script>	
	<script  type="text/javascript" src="${pageContext.request.contextPath}/static/js/ajaxfileupload.js"></script>	
</head>
	<body class="contain">
		<div class="navigation bg-primary">
			<div class="fb padding-side">
				<a href="javascript:history.go(-1)" class="text-white"><i class="fa fa-angle-left"></i></a>
			</div>
		</div>
		<main class="main margin-top2 padding-side05">
			<form action="" method="post">
				<fieldset>
					<div class="input-group form-group fs">
					  <span class="input-group-addon border0 clear-bg" id="sizing-addon1"><i class="padding-side05 text-danger vertical-mid">*</i>配餐类型</span>
					  <!-- <input type="text" class="form-control box-shadow0 border-bottom" name="account" placeholder="请输入姓名" aria-describedby="sizing-addon1"> -->
							<select id="type">		
								<option value="">请选择送餐类型</option>					
								<option value="1">早餐</option>
								<option value="2">午餐</option>
								<option value="3">晚餐</option>					
							</select>
					</div>
					<div class="input-group form-group fs">
					  <span class="input-group-addon border0 clear-bg" id="sizing-addon1"><i class="padding-side05 text-danger vertical-mid">*</i>配餐单位</span>
					  <%-- <input type="text" class="form-control box-shadow0 border-bottom" name="account" value="${user.unitName }" aria-describedby="sizing-addon1"> --%>
						<select id="mealsUnitName"">
								<option value="">请选择送餐企业</option>
								<c:forEach items="${unitList}" var="item">								
									<option value="${item.unitName}">${item.unitName}</option>
								</c:forEach>							
							</select>
					</div>					
					<div class="input-group form-group fs">
					  <span class="input-group-addon border0 clear-bg" id="sizing-addon1"><i class="padding-side05 text-danger vertical-mid">*</i>订餐单位</span>
					  <input type="text" class="form-control box-shadow0 border-bottom" name="acceptance_unit_name" value="${user.unitName }" readonly aria-describedby="sizing-addon1">
					</div>
					<div class="input-group form-group fs">
					  <span class="input-group-addon border0 clear-bg" id="sizing-addon1"><i class="padding-side05 text-danger vertical-mid">*</i>送餐人</span>
					  <input type="text" class="form-control box-shadow0 border-bottom" name="meals_user_name" value="${user.username }" readonly aria-describedby="sizing-addon1">
					</div>
					<div class="input-group form-group fs">
					  <span class="input-group-addon border0 clear-bg" id="sizing-addon1"><i class="padding-side05 text-danger vertical-mid">*</i>配送地址</span>
					  <input type="text" class="form-control box-shadow0 border-bottom" name="address" id="address"  aria-describedby="sizing-addon1">
					</div>
					<div class="fsa margin-bot2">
						<div class="">
							<div class="fc">
								<div class="upload_imgs margin_tb10">
									<div class="fc tip_text">
										<div class="text-info">
											<div class="fc"> <i class="fa fa-plus padding-side05"></i> </div>
											<div class="text-center">送餐装箱图</div>
										</div>
									</div>
									<input type="file" name="" id="fileinput" value="" accept="image/*"/>
									<img src="" id="preview">
								</div>
							</div>
						</div>
						<div class="">
							<div class="fc">
								<div class="upload_imgs margin_tb10">
									<div class="fc tip_text">
										<div class="text-info">
											<div class="fc"> <i class="fa fa-plus padding-side05"></i> </div>
											<div class="text-center">装箱封条图</div>
										</div>
									</div>
									<input type="file" name="" id="fileinput1" value="" accept="image/*"/>
									<img src="" id="preview1">
								</div>
							</div>
						</div>
						<div class="">
							<div class="fc">
								<div class="upload_imgs margin_tb10">
									<div class="fc tip_text">
										<div class="text-info">
											<div class="fc"> <i class="fa fa-plus padding-side05"></i> </div>
											<div class="text-center">送餐车图</div>
										</div>
									</div>
									<input type="file" name="" id="fileinput2" value="" accept="image/*"/>
									<img src="" id="preview2">
								</div>
							</div>
						</div>
					</div>
				  </fieldset>
			</form>
			<div class="margin-top2 margin-bot2">
				<button type="button" class="btn btn-primary form-control" id="add">提交</button>
			</div>
		</main>		
	<c:import url="public/footer.jsp"></c:import>
	</body>
	<script type="text/javascript">
			$(function(){
				$('select').searchableSelect();
			});
	
			//新增图片
			$("#add").click(function() {				
				if($("#preview").attr('src') == ""){
					layer.msg("请上传送餐装箱照",{icon:2,time:1000});
					$("#preview").focus();
				}else if($("#preview1").attr('src') == ""){
					layer.msg("请上传装箱封条照",{icon:2,time:1000});
					$("#preview1").focus();
				}else if($("#preview2").attr('src') == ""){
					layer.msg("请上传送餐车照",{icon:2,time:1000});
					$("#preview2").focus();
				}else if($("#mealsUnitName").val() == ""){
					layer.msg("请选择供配餐企业",{icon:2,time:1000});
					$("#mealsUnitName").focus();
				}else if($("#address").val() == ""){
					layer.msg("请填写配送地址",{icon:2,time:1000});
					$("#address").focus();
				}else if($("#type").val() == ""){
					layer.msg("请填写配餐类型",{icon:2,time:1000});
					$("#type").focus();
				}else{
					var formData = new FormData();		
					formData.append('type',$("#type").val());//送餐类型
					formData.append('mealsUnitName',$("#mealsUnitName").val());//供餐企业
					formData.append('acceptanceUnitName','${user.unitName}');//订餐企业
					formData.append('mealsUserName','${user.username}');//订餐企业
					formData.append('packingPhoto',$("#fileinput")[0].files[0]);//送餐装箱图
					formData.append('sealPhoto',$("#fileinput1")[0].files[0]);//装箱封条图
					formData.append('carPhoto',$("#fileinput2")[0].files[0]);//送餐车图
					formData.append('address',$("#address").val());//送餐地址
					$.ajax({
						 url: "${pageContext.request.contextPath}/dry/add",
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
									alert(obj.message);
									layer.msg(obj.message,{icon:1,time:1000});
									//延时刷新页面
									setTimeout(function (){							 
										window.location.href = "${pageContext.request.contextPath}/dry/delivery";
									}, 3000);	
								}
								
							}
						}); 
				}
			});		
		
			
			$("#fileinput").on("change",function() {
				changepic("fileinput","preview");						
			})
			$("#fileinput1").on("change",function() {						
				changepic("fileinput1","preview1");
			})
			$("#fileinput2").on("change",function() {						
				changepic("fileinput2","preview2");
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
