<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset=utf-8>
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no">
	<title>从业人员健康状况</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/bks_wap/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/fonts/font-awesome-4.7.0/css/font-awesome.min.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/bks_wap/style.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/bks_wap/index.css"/>
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
			<div class="fb">
				<!-- <a href="" class="btn bg-primary padding-side"><i class="fa fa-search"></i></a> -->
				<%-- <select>
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
				<a href="${pageContext.request.contextPath}/user/workmens_health_add" class="btn bg-primary padding-side"><i class="fa fa-plus"></i></a> --%>
			</div>
			<div class="">
				<table class="table table-striped table-hover" cellspacing="" cellpadding="">
					<caption>从业人员健康信息</caption>
					<thead>
						<tr><th>编号</th><th>姓名</th><th>体温状况℃</th><th>测温日期</th><th>操作</th></tr>
					</thead>
					<tbody>
						<c:forEach items="${hygieneList}" var="item">
							<tr><td>${item.hygieneId}</td><td>${item.username}</td><td>${item.celsius}</td><td>${item.dailyTime }</td><td><a href="${pageContext.request.contextPath}/user/workmens_health_detal?hygieneId=${item.hygieneId}">详情</a></td></tr>
						</c:forEach>	
						</tbody>
				</table>
			</div>
		</main>
	<c:import url="public/footer.jsp"></c:import>
	</body>

</html>
