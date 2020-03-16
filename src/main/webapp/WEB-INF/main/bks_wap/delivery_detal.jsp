<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset=utf-8>
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no">
	<title>配送信息详情</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/bks_wap/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/fonts/font-awesome-4.7.0/css/font-awesome.min.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/bks_wap/style.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/bks_wap/index.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/js/layui/css/layui.css"/>
	<script  type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.1.1.min.js"></script>
	<script  type="text/javascript" src="${pageContext.request.contextPath}/static/js/layui/layui.js"></script>
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
					<div class="input-group form-group fs border-bottom">
					  <span class="input-group-addon border0 clear-bg fonwei" id="sizing-addon1">食品类型</span>
					  <div class="form-control box-shadow0 border0">
						  <c:if test="${distributionDetial.type == 1}">
						  		早餐
						  </c:if>
						  <c:if test="${distributionDetial.type == 2}">
						  		午餐
						  </c:if>
						  <c:if test="${distributionDetial.type == 3}">
						  		晚餐
						  </c:if>
					  </div>
					</div>
					<div class="input-group form-group fs border-bottom">
					  <span class="input-group-addon border0 clear-bg fonwei" id="sizing-addon1">配餐单位</span>
					  <div class="form-control box-shadow0 border0">${distributionDetial.mealsUnitName }</div>
					</div>
					<div class="input-group form-group fs border-bottom">
					  <span class="input-group-addon border0 clear-bg fonwei" id="sizing-addon1">送餐人</span>
					  <div class="form-control box-shadow0 border0">${distributionDetial.mealsUserName }</div>
					</div>
					<div class="input-group form-group fs border-bottom">
					  <span class="input-group-addon border0 clear-bg fonwei" id="sizing-addon1">启送时间</span>
					  <div class="form-control box-shadow0 border0"><fmt:formatDate value="${distributionDetial.startTime}" pattern="yyyy-MM-dd HH:mm:ss" /></div>
					</div>
					<div class="input-group form-group fs border-bottom">
					  <span class="input-group-addon border0 clear-bg fonwei" id="sizing-addon1">送达时间</span>
					  <div class="form-control box-shadow0 border0"><fmt:formatDate value="${distributionDetial.endTime}" pattern="yyyy-MM-dd HH:mm:ss" /></div>
					</div>
					
					<div class="fsa margin-bot2">
						<div class="">
							<div class="fc">
								<div class="layui-upload-list">
								  <img class="layui-upload-img" src="${pageContext.request.contextPath}${distributionDetial.packingPhoto }">
								</div>
							</div>
							<div class="text-center">送餐装箱图</div>
						</div>
						<div class="">
							<div class="fc">
								<div class="layui-upload-list">
								  <img class="layui-upload-img" src="${pageContext.request.contextPath}${distributionDetial.sealPhoto }">
								</div>
							</div>
							<div class="text-center">装箱封条图</div>
						</div>
					</div>
					<div class="fsa margin-bot2">
						<div class="">
							<div class="fc">
								<div class="layui-upload-list">
								  <img class="layui-upload-img" src="${pageContext.request.contextPath}${distributionDetial.carPhoto }">
								</div>
							</div>
							<div class="text-center">送餐车图</div>
						</div>
						<div class="">
							<div class="fc">
								<div class="upload_imgs margin_tb10">
									<div class="fc tip_text">
										<div class="text-info">
											<div class="fc"> <i class="fa fa-plus padding-side05"></i> </div>
											<div class="text-center">拆封取餐照</div>
										</div>
									</div>
									<input type="file" name="" id="fileinput" value="" accept="image/*"/>
									<c:if test="${distributionDetial.status == 3}">
										<img alt="" src="${pageContext.request.contextPath}${distributionDetial.openedPhoto}" id="preview">
									</c:if>
									<c:if test="${distributionDetial.status != 3}">
										<img src="" id="preview">
									</c:if>	
								</div>
							</div>
							<script type="text/javascript">
								$("#fileinput").on("change",function() {
									changepic("fileinput","preview");
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
							<div class="text-center">拆封取餐照</div>
						</div>
					</div>
					<div class="input-group form-group fs border-bottom">
					  <span class="input-group-addon border0 clear-bg fonwei" id="sizing-addon1">验收时间</span>
					  <div class="form-control box-shadow0 border0"><fmt:formatDate value="${distributionDetial.acceptanceTime}" pattern="yyyy-MM-dd HH:mm:ss" /></div>
					</div>
					<div class="input-group form-group fs border-bottom">
					  <span class="input-group-addon border0 clear-bg fonwei" id="sizing-addon1">配送状态</span>
					  <div class="form-control box-shadow0 border0">
					  		<c:if test="${distributionDetial.status == 1}">
					  			启送中
					  		</c:if>
					  		<c:if test="${distributionDetial.status == 2}">
					  			已送达
					  		</c:if>
					  		<c:if test="${distributionDetial.status == 3}">
					  			已验收
					  		</c:if>
					  </div>
					</div>
					<div class="input-group form-group fs border-bottom">
					  <span class="input-group-addon border0 clear-bg fonwei" id="sizing-addon1">配送地点</span>
					  <div class="form-control box-shadow0 border0">${distributionDetial.address}</div>
					</div>
					<div class="input-group form-group fs border-bottom">
					  <span class="input-group-addon border0 clear-bg fonwei" id="sizing-addon1">创建时间</span>
					  <div class="form-control box-shadow0 border0"><fmt:formatDate value="${distributionDetial.createTime}" pattern="yyyy-MM-dd HH:mm:ss" /></div>
					</div>
				  </fieldset>
			</form>
			<div class="margin-top2 margin-bot2">
				<c:if test="${user.type == 2}">
					<c:if test="${distributionDetial.status == 1}">
						<button type="button" class="btn btn-primary form-control" id="end">确认送达</button>
					</c:if>
					<c:if test="${distributionDetial.status == 2}">
						<button type="button" class="btn btn-primary form-control" id="acceptance">确认验收</button>
					</c:if>
					<c:if test="${distributionDetial.status == 3}">
						<button type="button" class="btn btn-primary form-control">已验收</button>
					</c:if>					
				</c:if>		
			</div>
		</main>		
		<script type="text/javascript">
		$("#end").click(function () { 
			var sd_user = '${user.username}';
			var dd_user = '${distributionDetial.mealsUserName}';
			if(sd_user != dd_user){
				console.log("送达操作人：" + sd_user);
				console.log("送餐人：" + dd_user);
				return;
			}
			layer.confirm('是否确认送达？', {
				  btn: ['是', '否'] //可以无限个按钮
				}, function(index, layero){
					songda();
				  	//按钮【按钮一】的回调
					//layer.close(index);
				}, function(index){
				  	//按钮【按钮二】的回调
					//layer.alert("按钮二");
				});
		})
		
		//确认送达
		function songda(){
			var data = "id=${distributionDetial.id}";
			var url = "${pageContext.request.contextPath}/dry/service";
			$.ajax({
				"url" : url,
				"data" : data,
				"type" : "POST",
				"dataType" : "json",
				"success" : function(obj) {
					if (obj.state == 0) {
						layer.msg(obj.message,{icon:2,time:1000});						
					}else{
						layer.msg(obj.message,{icon:1,time:1000});							
					}		
					//延时刷新页面
					setTimeout(function (){							 
						window.location.reload();
					}, 3000);	
				}
			}); 
		}
		
		
		$("#acceptance").click(function () { 
			var meals_unit_name = '${user.unitName}';
			var acceptance_unit_name = '${distributionDetial.acceptanceUnitName}';
			if(meals_unit_name != acceptance_unit_name){
				console.log("用户企业：" + meals_unit_name);
				console.log("收餐企业：" + acceptance_unit_name);
				return;
			}
			if($("#preview").attr('src') == ""){
				layer.msg("请上传拆封取餐照",{icon:2,time:1000});
				$("#preview").focus();
				return;
			}
			layer.confirm('是否确认验收？', {
				  btn: ['是', '否'] //可以无限个按钮
				}, function(index, layero){
					acceptance();
				  	//按钮【按钮一】的回调
					//layer.close(index);
				}, function(index){
				  	//按钮【按钮二】的回调
					//layer.alert("按钮二");
				});
		})
		//确认验收
		function acceptance(){			
			var formData = new FormData();				
			formData.append('id','${distributionDetial.id}');//订单ID
			formData.append('openedPhoto',$("#fileinput")[0].files[0]);//拆封取餐照
			var url = "${pageContext.request.contextPath}/dry/acceptance";
			$.ajax({
				  url: url,
		          type: 'POST',
		          cache: false,
		          data: formData,				        
		          processData: false,
		          contentType: false,
				"success" : function(obj) {
					if (obj.state == 0) {
						layer.msg(obj.message,{icon:2,time:1000});						
					}else{
						layer.msg(obj.message,{icon:1,time:1000});							
					}		
					//延时刷新页面
					setTimeout(function (){							 
						window.location.reload();
					}, 3000);	
				}
			}); 
		}
		
		
	/* 	
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
			  }); */
		</script>	
	<c:import url="public/footer.jsp"></c:import>
	</body>

</html>
