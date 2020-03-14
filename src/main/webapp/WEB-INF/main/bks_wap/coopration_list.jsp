<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset=utf-8>
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no">
	<title>企业信息列表</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/bks_wap/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/fonts/font-awesome-4.7.0/css/font-awesome.min.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/js/selector/jquery.searchableSelect.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/bks_wap/style.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/bks_wap/index.css"/>
	<script  type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.1.1.min.js"></script>
	<script  type="text/javascript" src="${pageContext.request.contextPath}/static/js/layui/layui.js"></script>
	<script  type="text/javascript" src="${pageContext.request.contextPath}/static/js/selector/jquery.searchableSelect.js"></script>
</head>
	<body class="contain">
		<div class="navigation bg-primary">
			<div class="fb padding-side">
				<a href="javascript:history.go(-1)" class="text-white"><i class="fa fa-angle-left"></i></a>
				<div class="">
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
				<!-- <a href="http://192.168.1.106:8848/wap_MCLZ/check_add.html" class="btn bg-primary"><i class="fa fa-plus"></i></a> -->
			</div>
		</div>
		<main class="main margin-top2 padding-side05">
			<div class="">
				<table class="table table-striped table-hover" cellspacing="" cellpadding="">
					<thead>
						<tr><th>序号</th><th>企业名称</th><th>企业法人</th><th>操作</th></tr>
					</thead>
					<tbody>
						<tr><td>1</td><td>老干妈</td><td>data</td><td><a href="${pageContext.request.contextPath}/unit/coopration_detal">详情</a></td></tr>
						<tr><td>2</td><td>老干妈</td><td>data</td><td><a href="">详情</a></td></tr>
					</tbody>
				</table>
			</div>
		</main>
	<c:import url="public/footer.jsp"></c:import>
	</body>

</html>
