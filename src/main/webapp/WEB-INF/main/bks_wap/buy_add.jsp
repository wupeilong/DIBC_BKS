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
		<main class="main margin-top padding-side05">
			<form action="" method="post">
				<fieldset>
					<div class="input-group form-group fs">
						  <span class="input-group-addon border0 clear-bg" id="sizing-addon1"><i class="padding-side05 text-danger vertical-mid"></i>供&ensp;应&ensp;商&ensp;&ensp;&ensp;</span>
						  <c:if test="${user.type == 2}">
							<select id="unit_list">
								<option value="">查询所有企业信息</option>
								<c:forEach items="${unitList}" var="item">								
									<option value="${item.unitId}">${item.unitName}</option>
								</c:forEach>
							</select>
						  </c:if>	
						  <!-- <span class="input-group-addon border0 clear-bg" id="sizing-addon1"><i class="padding-side05 text-danger vertical-mid">*</i>供&ensp;应&ensp;商</span>
						  <input type="text" class="form-control box-shadow0 border-bottom" name="account"  aria-describedby="sizing-addon1"> -->					
					</div>
					<div class="fsa margin-bot2">	
				  	<div class="">
							<div class="fc">
								<div class="layui-upload-list">
								  <img class="layui-upload-img" src="">
								</div>
							</div>
							<div class="text-center">供应商营业执照</div>
						</div>
						<div class="">
							<div class="fc">
								<div class="layui-upload-list">
								  <img class="layui-upload-img" src="">
								</div>
							</div>
							<div class="text-center">食品经营许可证</div>
						</div>
						<div class="">
							<div class="fc">
								<div class="layui-upload-list">
								  <img class="layui-upload-img" src="">
								</div>
							</div>
							<div class="text-center">经营资质</div>
						</div>
					</div>					
					<div class="input-group form-group fs border-bottom">
					  <span class="input-group-addon border0 clear-bg fonwei" id="sizing-addon1">联&ensp;系&ensp;人</span>
					  <input type="text" class="form-control box-shadow0 border-bottom" id="supplierPerson"  aria-describedby="sizing-addon1"> 
					</div>
					<div class="input-group form-group fs border-bottom">
					  <span class="input-group-addon border0 clear-bg fonwei" id="sizing-addon1">联系电话</span>
					  <input type="text" class="form-control box-shadow0 border-bottom" id="supplierPhone"  aria-describedby="sizing-addon1"> 
					</div>
					<%-- <div class="input-group form-group fs border-bottom">
					  <span class="input-group-addon border0 clear-bg fonwei" id="sizing-addon1">订&ensp;单&ensp;号</span>
					  <div class="form-control box-shadow0 border0">${procurementDetail.id }</div>
					</div> --%>
					<div class="input-group form-group fs border-bottom">
					  <span class="input-group-addon border0 clear-bg fonwei" id="sizing-addon1">采购公司</span>
					  <div class="form-control box-shadow0 border0">${user.unitName }</div>
					</div>
					<div class="input-group form-group fs border-bottom">
					  <span class="input-group-addon border0 clear-bg fonwei" id="sizing-addon1">采&ensp;购&ensp;人</span>
					  <div class="form-control box-shadow0 border0">${user.username }</div>
					</div>
				  </fieldset>
			</form>
			<div class="margin-top2">
				<table class="table table-striped table-bordered table-hover" cellspacing="" cellpadding="">
					<caption>供货明细：</caption>
					<thead>
						<tr><th>序号</th><th>商品名</th><th>数量</th><th>生产日期</th><th>操作</th></tr>
					</thead>
					<tbody>
						<tr> <td>1</td><td>白菜</td><td>一大车</td><td>03-12</td><td><a href="" class="text-danger">删除</a></td></tr>
					</tbody>
				</table>
				<div class="text-right">
					<a href="" class="btn btn-primary">新增商品</a>
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
			<div class="margin-top2 margin-bot2">
				<button type="button" class="btn btn-primary form-control">提交</button>
			</div>
		</main>		
	<c:import url="public/footer.jsp"></c:import>
	</body>

</html>
