<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="<c:url value="/resources/css/main_styles.css" />">
		<link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" />">
		<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
		<script src="<c:url value="/resources/bootstrap/js/jquery-3.3.1.min.js" />"></script>
		<script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js" />"></script>
		<title>Xuất hóa đơn</title>
	</head>
	<body>
		<jsp:include page="dashboard-header.jsp"></jsp:include>
		<div class="container-fluid h-100">
	 		<div class="row h-100">
				<jsp:include page="dashbaord-navibar.jsp"></jsp:include>
				<div class="col-md-2"></div>		
				<div class="col-md-6 m-5">		
					<jsp:include page="order-detail.jsp"></jsp:include>
				</div>
			</div>
		</div>
	</body>
</html>