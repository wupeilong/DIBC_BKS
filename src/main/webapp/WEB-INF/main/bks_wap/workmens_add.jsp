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
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/js/layui/css/layui.css">
	<script  type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.1.1.min.js"></script>
	<script  type="text/javascript" src="${pageContext.request.contextPath}/static/js/layui/layui.js"></script>	
	<script  type="text/javascript" src="${pageContext.request.contextPath}/static/js/ajaxfileupload.js"></script>	
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
					  <span class="input-group-addon border0 clear-bg" id="sizing-addon1"><i class="padding-side05 text-danger vertical-mid">*</i>所属企业</span>
					  <div class="form-control box-shadow0 border0">${user.unitName}</div>
					  <%-- <input type="text" class="form-control box-shadow0 border-bottom" name="unitName" placeholder="请输入企业名称" aria-describedby="sizing-addon1" value="${user.unitName}"> --%>
					</div>
					<div class="input-group form-group fs">
					  <span class="input-group-addon border0 clear-bg" id="sizing-addon1"><i class="padding-side05 text-danger vertical-mid">*</i>职&ensp;&ensp;&ensp;&ensp;务</span>
					  <input type="text" class="form-control box-shadow0 border-bottom" name="duty" placeholder="请输入职务" aria-describedby="sizing-addon1">
					</div>
					<div class="input-group form-group fs">
					  <span class="input-group-addon border0 clear-bg" id="sizing-addon1"><i class="padding-side05 text-danger vertical-mid">*</i>姓&ensp;&ensp;&ensp;&ensp;名</span>
					  <input type="text" class="form-control box-shadow0 border-bottom" name="username" placeholder="请输入姓名" aria-describedby="sizing-addon1">
					</div>
					<div class="input-group form-group fs">
					  <span class="input-group-addon border0 clear-bg" id="sizing-addon1"><i class="padding-side05 text-danger vertical-mid">*</i>身份证号</span>
					  <input type="text" class="form-control box-shadow0 border-bottom" id="idCard" name="idCard" value="5222" placeholder="请输入身份证号" aria-describedby="sizing-addon1">
					</div>
					<div class="input-group form-group fs">
					  <span class="input-group-addon border0 clear-bg" id="sizing-addon1"><i class="padding-side05 text-danger vertical-mid">*</i>年&ensp;&ensp;&ensp;&ensp;龄</span>
					  <input type="text" class="form-control box-shadow0 border-bottom" name="age" placeholder="请输入年龄" aria-describedby="sizing-addon1">
					</div>
					<div class="input-group form-group fs">
					  <span class="input-group-addon border0 clear-bg" id="sizing-addon1"><i class="padding-side05 text-danger vertical-mid">*</i>健康证编号</span>
					  <input type="text" class="form-control box-shadow0 border-bottom" name="healthCertificateCode" placeholder="请输入健康证编号" aria-describedby="sizing-addon1">
					</div>
				</div>
				
				<div class="">
					<div class="fc">
						<div class="upload_imgs">
							<div class="fc tip_text">
								<div class="text-info">
									<div class="fc"> <i class="fa fa-plus padding-side05"></i> </div>
									<div class="text-center">上传图片</div>
								</div>
							</div>
							<input type="file" name="" id="fileinput" value="" accept="image/*"/>
							<img src="" id="preview">
						</div>
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
				<!-- <input id="ficard" type="file" name="file" /> -->
			</form>
			
			<div class="margin-top2 margin-bot2">
				<button type="button" class="btn btn-primary form-control" id="register">保存</button>
			</div>
		</main>		
		<script type="text/javascript">
		$(function() {			
			  $('#register').click(function() {
			    var data = {};
			    var t = $('form').serializeArray();
			    $.each(t, function() {
	                 data [this.name] = this.value;
	            });
	            alert(JSON.stringify(data));
	            var formData = new FormData();				
				formData.append('file',$("#ficard")[0].files[0]);
				formData.append('idCard',JSON.stringify(data));
				 $.ajax({
					 url: '../file/upload',
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
							}				
						}
					}); 
			  });
			});
			
		
			
		
		
			layui.use('upload', function(){
			  var $ = layui.jquery
			  ,upload = layui.upload;
			  var idDard=$("#idCard").val();
				console.log(idDard);
				
				
				
			  //普通图片上传
			  var uploadInst = upload.render({
			    elem: '#test1'
			    ,url: '${pageContext.request.contextPath}/file/upload' //改成您自己的上传接口
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
