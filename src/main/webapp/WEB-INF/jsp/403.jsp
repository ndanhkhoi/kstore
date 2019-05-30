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
		<script src="<c:url value="/resources/bootstrap/js/jquery-3.3.1.min.js" />"></script>
		<script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js" />"></script>
		<title>403 Error</title>
	</head>
	<body>
		<div id = "div-logo">
			<div class="row">
			<!-- Logo -->
					<div class="col-lg-2">
							<div class="logo"><a href="<%=request.getContextPath()%>">KStore</a></div>
					</div>
			</div>
		</div>	   
		<center class="mt-5">
			<h3>Sorry! you do not have rights to view this page</h3>
		</center>
	</body>
</html>