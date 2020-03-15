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
								<tr><td rowspan="4">餐(炊)具种类</td><td>小餐具类</td><td>是：<input type="radio" name="tableware" id="" value="" /></td><td>否：<input type="radio" name="tableware" id="" value="" /></td></tr>
								<tr><td>大餐具类</td><td>是：<input type="radio" name="bigTableware" id="" value="" /></td><td>否：<input type="radio" name="bigTableware" id="" value="" /></td></tr>
								<tr><td>筷子、勺子类</td><td>是：<input type="radio" name="chopsticks" id="" value="" /></td><td>否：<input type="radio" name="chopsticks" id="" value="" /></td></tr>
								<tr><td>锅、盆类</td><td>是：<input type="radio" name="panPot" id="" value="" /></td><td>否：<input type="radio" name="panPot" id="" value="" /></td></tr>
								
								<tr><td colspan="2">工具类</td><td>是：<input type="radio" name="toolsType" id="" value="" /></td><td>否：<input type="radio" name="toolsType" id="" value="" /></td></tr>
								<tr><td colspan="2">餐具保洁设施</td><td>是：<input type="radio" name="establish" id="" value="" /></td><td>否：<input type="radio" name="establish" id="" value="" /></td></tr>
								<tr><td rowspan="2">消毒方法</td><td>电子消毒柜</td><td>是：<input type="radio" name="sterilizer" id="" value="" /></td><td>否：<input type="radio" name="sterilizer" id="" value="" /></td></tr>
								<tr><td>消毒药水</td><td>是：<input type="radio" name="disinfectant" id="" value="" /></td><td>否：<input type="radio" name="disinfectant" id="" value="" /></td></tr>
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
	<c:import url="public/footer.jsp"></c:import>
	</body>

</html>
