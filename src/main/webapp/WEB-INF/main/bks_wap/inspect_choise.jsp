<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset=utf-8>
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no">
	<title>监管采集导航页</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/bks_wap/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/fonts/font-awesome-4.7.0/css/font-awesome.min.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/bks_wap/style.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/bks_wap/index.css"/>
	<script  type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.1.1.min.js"></script>
	<script  type="text/javascript" src="${pageContext.request.contextPath}/static/js/layui/layui.js"></script>		
</head>
	<body class="contain height100">
		<div class="navigation bg-primary">
			<div class="fb padding-side">
				<a href="javascript:history.go(-1)" class="text-white"><i class="fa fa-angle-left"></i></a>
			</div>
		</div>
		<main class="main height100 fc bg-warning">
			<!-- <div class="text-right padding-side"><a href="javascript:history.go(-1)" class="btn btn-primary"><i class="fa fa-angle-double-left"></i>返回</a></div> -->
			<div class="width100">
				<div class="padding-side margin-bot2">
					<a href="${pageContext.request.contextPath}/inspect/inspect_list" class="btn btn-info form-control">信息查看</a>
				</div>
				<div class="padding-side margin-bot2">
					<a href="${pageContext.request.contextPath}/inspect/inspect_add" class="btn btn-info form-control">商家自检</a>
				</div>
				<div class="padding-side margin-bot2">
					<a href="${pageContext.request.contextPath}/inspect/inspect_add" class="btn btn-info form-control">管局专检</a>
				</div>
				<div class="padding-side margin-bot2">
					<a href="${pageContext.request.contextPath}/inspect/inspect_add" class="btn btn-info form-control">督察专检</a>
				</div>
				<!-- <table class="table table-striped table-hover" cellspacing="" cellpadding="">
					<thead>
						<tr><th>序号</th><th>样品名称</th><th>抽检批次</th><th>检查结果</th><th>操作</th></tr>
					</thead>
					<tbody>
						<tr><td>1</td><td>贵阳市第一实验中学</td><td>未验收</td><td>data</td><td><a href="http://192.168.1.106:8848/wap_MCLZ/inspect_detal.html">详情</a></td></tr>
					</tbody>
				</table> -->
			</div>
		</main>		
	<c:import url="public/footer.jsp"></c:import>
	</body>

</html>
