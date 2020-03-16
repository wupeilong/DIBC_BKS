<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset=utf-8>
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no">
	<title>监管记录</title>
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
				
				<!-- <a href="http://192.168.1.106:8848/wap_MCLZ/inspect_add.html" class="btn bg-primary"><i class="fa fa-plus"></i></a> -->
			</div>
		</div>
		
		<main class="main padding-side05">
			<div class="bg-warning margin-top2">
				<table class="table table-striped table-hover" cellspacing="" cellpadding="">
					<thead>
						<tr><th>企业名称</th><th>检查类型</th><th>检查时间</th><th>操作</th></tr>
					</thead>
					<tbody>
						<c:forEach items="${checkList}" var="f">
							<tr>
								<td>${f.unitName}</td>
								<td>
									<c:if test="${f.checkType==1}">
										单位自检
									</c:if>
									<c:if test="${f.checkType==2}">
										市监局专监
									</c:if>
									<c:if test="${f.checkType==3}">
										督查组检查
									</c:if>
								</td>
								<td>${f.dailyTime}</td>
								<td style="4em"><a href="${pageContext.request.contextPath}/inspect/inspect_detal?id=${f.id}">详情</a></td>
							</tr>
						</c:forEach>
						
					</tbody>
				</table>
			</div>
		</main>		
	<c:import url="public/footer.jsp"></c:import>
	</body>

</html>
