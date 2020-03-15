<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset=utf-8>
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no">
	<title>添加多频检查记录</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/bks_wap/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/fonts/font-awesome-4.7.0/css/font-awesome.min.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/js/selector/jquery.searchableSelect.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/bks_wap/style.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/bks_wap/index.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/js/layui/css/layui.css"/>
	<script  type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.1.1.min.js"></script>
	<script  type="text/javascript" src="${pageContext.request.contextPath}/static/js/layui/layui.js"></script>	
	<script  type="text/javascript" src="${pageContext.request.contextPath}/static/js/selector/jquery.searchableSelect.js"></script>	
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
				    <legend class="">检测详情:</legend>
					<div class="border-bottom margin-bot2">
						<div class="input-group form-group fs">
						  <span class="input-group-addon border0 clear-bg fonwei" id="sizing-addon1"><i class="padding-side05 text-danger vertical-mid">*</i>检测对象</span>
						  <div class="form-control padding0 box-shadow0 border0">
							  <div class="">
							  	<!-- <a href="" class="btn bg-primary padding-side"><i class="fa fa-search"></i></a> -->
							  	<select>
							  		<option value="BlackBerry">BlackBerry</option>
							  		<option value="device">device</option>
							  		<option value="with">with</option>
							  		<option value="entertainment">entertainment</option>
							  		<option value="and">and</option>
							  		<option value="social">social</option>
							  		<option value="networking">networking</option>
							  		<option value="apps">apps</option>
							  		<option value="or">or</option>
							  		<option value="apps">apps</option>
							  		<option value="that">that</option>
							  		<option value="will">will</option>
							  		<option value="boost">boost</option>
							  		<option value="your">your</option>
							  		<option value="productivity">productivity</option>
							  		<option value="Download">Download</option>
							  		<option value="or">or</option>
							  		<option value="buy">buy</option>
							  		<option value="apps">apps</option>
							  		<option value="from">from</option>
							  		<option value="Afbb">Afbb</option>
							  		<option value="Akademie">Akademie</option>
							  		<option value="Berlin">Berlin</option>
							  		<option value="reviews">reviews</option>
							  		<option value="by">by</option>
							  		<option value="real">real</option>
							  	</select>
							  	<script>
							  		$(function(){
							  			$('select').searchableSelect();
							  		});
							  	</script>
							  </div>
						  </div>
						  <!-- <input type="text" class="form-control box-shadow0 border-bottom" name="account" placeholder="请输入姓名" aria-describedby="sizing-addon1"> -->
						</div>
						<div class="input-group form-group fs">
						  <span class="input-group-addon border0 clear-bg fonwei" id="sizing-addon1"><i class="padding-side05 text-danger vertical-mid">*</i>检测时间</span>
						  <input type="text" class="box-shadow0 width100 border-bottom" name="account" placeholder="请输入姓名" aria-describedby="sizing-addon1">
						</div>
						<div class="input-group form-group fs">
						  <span class="input-group-addon border0 clear-bg fonwei" id="sizing-addon1"><i class="padding-side05 text-danger vertical-mid">*</i>样品名</span>
						  <input type="text" class="box-shadow0 width100 border-bottom" name="account" placeholder="请输入姓名" aria-describedby="sizing-addon1">
						</div>
						<div class="input-group form-group fs">
						  <span class="input-group-addon border0 clear-bg fonwei" id="sizing-addon1"><i class="padding-side05 text-danger vertical-mid">*</i>包装分类</span>
						  <input type="text" class="width100 box-shadow0 border-bottom" name="account" placeholder="请输入姓名" aria-describedby="sizing-addon1">
						</div>
						<div class="input-group form-group fs">
						  <span class="input-group-addon border0 clear-bg fonwei" id="sizing-addon1"><i class="padding-side05 text-danger vertical-mid">*</i>抽检批次</span>
						  <input type="text" class="width100 box-shadow0 border-bottom" name="account" placeholder="请输入姓名" aria-describedby="sizing-addon1">
						</div>
						<div class="input-group form-group fs">
						  <span class="input-group-addon border0 clear-bg fonwei" id="sizing-addon1"><i class="padding-side05 text-danger vertical-mid">*</i>检测项目</span>
						  <input type="text" class="width100 box-shadow0 border-bottom" name="account" placeholder="请输入姓名" aria-describedby="sizing-addon1">
						</div>
						<div class="input-group form-group fs">
						  <span class="input-group-addon border0 clear-bg fonwei" id="sizing-addon1"><i class="padding-side05 text-danger vertical-mid">*</i>检测结果</span>
						  <input type="text" class="width100 box-shadow0 border-bottom" name="account" placeholder="请输入姓名" aria-describedby="sizing-addon1">
						</div>
						<div class="input-group form-group fs">
						  <span class="input-group-addon border0 clear-bg fonwei" id="sizing-addon1"><i class="padding-side05 text-danger vertical-mid">*</i>备注</span>
						  <input type="text" class="width100 box-shadow0 border-bottom" name="account" placeholder="请输入姓名" aria-describedby="sizing-addon1">
						</div>
					</div>
					<div class="margin-top">
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
					</div>
					
				  </fieldset>
			</form>
			<div class="margin-top2 margin-bot2">
				<button type="button" class="btn btn-primary form-control">提交</button>
			</div>
		</main>		
	<c:import url="public/footer.jsp"></c:import>
	</body>

</html>
