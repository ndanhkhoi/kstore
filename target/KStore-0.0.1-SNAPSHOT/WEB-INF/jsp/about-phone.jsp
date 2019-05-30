<%@page import="java.util.Date"%>
<%@page import="com.ndanhkhoi.entity.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	Product product = (Product) request.getAttribute("product");
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
		<title>KStore - <%=product.getName()%></title>
	</head>
	<body class = "bg-index">
	
		 <script>
              new WOW().init();
         </script>	
	
		<jsp:include page="_header.jsp"></jsp:include>
		<div class="container mt-5 mb-5">
			<div class="row">
				<div class="col-md-5">
					<div class="card wow bounceInUp">
						<h3 class="text-danger p-3">Hình ảnh sản phẩm</h3>
						<h5 class="text-center mt-3"><%=product.getName()%></h5>
						<div class="row pl-5 pr-5">
							<div class="col-md-7">
								<img src="../product/<%=product.getId()%>-img1?t=<%=new Date().toString()%>" class="w-100">
							</div>
							<div class="col-md-5 d-flex align-content-around flex-wrap">
								<img src="../product/<%=product.getId()%>-img2?t=<%=new Date().toString()%>" class="w-100">
								<img src="../product/<%=product.getId()%>-img3?t=<%=new Date().toString()%>" class="w-100">
							</div>
						</div>
						<h3 class="text-danger text-center"><%=product.getPriceString()%> </h3>
						<%
							String orderBtn = new String();
							if (request.isUserInRole("ROLE_ADMIN") || request.isUserInRole("ROLE_STAFF")) 
								orderBtn = "d-none";
						%>
						<form action = "../customer-add-to-cart" method="post">
							<center>
								<input type='hidden' value = "<%=product.getId()%>" name='id' id='id'>
								<button class="btn btn-warning text-white font-weight-bold <%=orderBtn%>">Đặt hàng ngay</button>
							</center>
						</form>
						<p class="text-justify p-4 " style="text-indent:5%;"><%=product.getDescription()%></p>
					</div>
				</div>

				<div class="col-md-7 pl-5">
					<div class="card wow bounceInUp">
						<h3 class="text-danger p-3">Thông số kĩ thuật</h3>
						<table class="table table-striped w-75 ml-5">
							<tr>
								<th>OS: </th>
								<td><%=product.getOs()%></td>
							</tr>
							<tr>
								<th>Màn hình: </th>
								<td><%=product.getScreen()%></td>
							</tr>
							<tr>
								<th>Cam trước: </th>
								<td><%=product.getFrontCamera()%></td>
							</tr>
							<tr>
								<th>Cam sau: </th>
								<td><%=product.getBackCamera()%></td>
							</tr>
							<tr>
								<th>CPU: </th>
								<td><%=product.getCpu()%></td>
							</tr>
							<tr>
								<th>Ram: </th>
								<td><%=product.getRam() + "GB"%></td>
							</tr>
							<tr>
								<th>Bộ nhớ trong: </th>
								<td><%=product.getRom() + "GB"%></td>
							</tr>
							<tr>
								<th>Pin: </th>
								<td><%=product.getBattery()%></td>
							</tr>
							<tr>
								<th>Bảo mật: </th>
								<td><%=product.getSecurity()%></td>
							</tr>
							<tr>
								<th>Màu sắc: </th>
								<td><%=product.getColor()%></td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="_footer.jsp"></jsp:include>
	</body>
</html>