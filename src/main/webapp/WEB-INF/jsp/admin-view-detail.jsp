<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="<c:url value="/resources/css/main_styles.css" />">
		<link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" />">
		<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
		<script src="<c:url value="/resources/bootstrap/js/jquery-3.3.1.min.js" />"></script>
		<script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js" />"></script>		
 		<title>Trang Admin</title>
	</head>
<body>

	<jsp:include page="dashboard-header.jsp"></jsp:include>
		
<!-- 	This is content page -->		
	<div class="container-fluid h-100">
	 		<div class="row h-100">
	 		
	 			<!-- This is column navi bar -->
				<jsp:include page="dashbaord-navibar.jsp"></jsp:include>
				
				<jsp:include page="view-profile.jsp"></jsp:include>

			</div>
		</div>
</body>
</html>