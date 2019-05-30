<%@page import="java.util.Date"%>
<%@page import="com.ndanhkhoi.entity.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	List<Product> result = (List) request.getAttribute("result");
	String name = request.getAttribute("name").toString();
	String aboutPhoneUrl = request.getContextPath();
	aboutPhoneUrl += request.isUserInRole("ROLE_ADMIN") ? "/admin-view-phone/" : "/about-phone/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
		<link rel="stylesheet" href="<c:url value="/resources/css/main_styles.css" />">
		<link rel="stylesheet" href="<c:url value="/resources/css/animate.css" />">
		<link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" />">
		<script src="<c:url value="/resources/bootstrap/js/jquery-3.3.1.min.js" />"></script>
		<script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js" />"></script>
		<script src="<c:url value="/resources/js/wow.min.js" />"></script>
		<script src="<c:url value="/resources/js/home.js" />"></script>
		<title>Kết quả tìm kiếm</title>
	</head>
	<body class = "bg-index">
	
		 <script>
              new WOW().init();
         </script>
	
		<jsp:include page="_header.jsp"></jsp:include>
		
		<div class="container">
			<h3 class="m-3 mb-5 text-primary" id = "mi">Có <%=result.size()%> kết quả tìm kiếm cho “<%=name%>”</h3>
			<div class="row mt-3 d-flex flex-wrap justify-content-between">
			<% for (Product p : result) {%>
					<cell class = 'col-md-2 m-2 bg-white p-3 wow bounceInUp' onclick="aboutPhone('<%=aboutPhoneUrl + p.getId()%>')">
						<img src = 'product/<%=p.getId() + "-img1?t=" + new Date().toString()%>' class='img-thumbnail' style='border-style:none;' alt = 'img'>
						<div class='text-center font-weight-bold' style='height: 50px;'><%=p.getName()%></div>
						<h5 class='text-center text-danger'><%=p.getPriceString()%></h5>
					</cell>
			<% } %>
			</div>
		</div>
		<br><br>
		<jsp:include page="_footer.jsp"></jsp:include>
		
	</body>
</html>