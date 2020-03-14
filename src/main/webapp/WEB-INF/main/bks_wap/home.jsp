<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset=utf-8>
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no">
	<title></title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/bks_wap/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/fonts/font-awesome-4.7.0/css/font-awesome.min.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/bks_wap/style.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/bks_wap/index.css"/>
	<script  type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.1.1.min.js"></script>
	<script  type="text/javascript" src="${pageContext.request.contextPath}/static/js/layer/2.4/layer.js"></script>
</head>
<body class="bg-info contain">
		<main class="">
			<div class="">
				<div class=""><img src="${pageContext.request.contextPath}/static/images/bks_wap/banner.jpg" class="img-responsive"></div>
			</div>
			<div class="bg-success">
				<ul class="function_list list-unstyled clearfix">
					<li class=""><a href="${pageContext.request.contextPath}/unit/coopration_list"><div><i class="fa fa-info"></i><p class="padding-side05">企业信息</p></div></a></li>
					<li class=""><a href="${pageContext.request.contextPath}/user/workmens"><div><i class="fa fa-users"></i><p class="padding-side05">从业人员</p></div></a></li>
					<li class=""><a href="${pageContext.request.contextPath}/procurement/buy_list"><div><i class="fa fa-opencart"></i><p class="padding-side05">采购报送</p></div></a></li>
					<li class=""><a href="javascript:;" id="ai"><div><i class="fa fa-eye"></i><p class="padding-side05">加工制作检视</p></div></a></li>
					<li class=""><a href="${pageContext.request.contextPath}/dry/delivery"><div><i class="fa fa-truck"></i><p class="padding-side05">配送报备</p></div></a></li>
					<li class=""><a href="${pageContext.request.contextPath}/clean/clean_list"><div><i class="fa fa-shower"></i><p class="padding-side05">清洗/消毒记录</p></div></a></li>
					<li class=""><a href="${pageContext.request.contextPath}/inspect/inspect_choise"><div><i class="fa fa-edit"></i><p class="padding-side05">监管采集</p></div></a></li>
					<li class=""><a href="${pageContext.request.contextPath}/detection/detection_list"><div><i class="fa fa-paper-plane-o"></i><p class="padding-side05">多频检测</p></div></a></li>
					<li class=""><a href="javascript:alert('功能开发中……');"><div><i class="fa fa-crosshairs"></i><p class="padding-side05">视频监控</p></div></a></li>
				</ul>
			</div>
		</main>
		<c:import url="public/footer.jsp"></c:import>
		<script type="text/javascript">
			$("#ai").click(function () {
				alert("功能开发中……")
			})
		</script>
</body>
</html>
