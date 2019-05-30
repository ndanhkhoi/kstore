<%@page import="java.util.HashMap"%>
<%@page import="com.ndanhkhoi.entity.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
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
		<script src="<c:url value="/resources/js/cart.js" />"></script>
		<title>Giỏ hàng</title>
	</head>
	<body class = "bg-index">
	
		 <script>
              new WOW().init();
         </script>
	
		<jsp:include page="_header.jsp"></jsp:include>
		
		<div class="container d-flex justify-content-center m-5">
			<div class="card p-5 wow bounceInUp">
				<h4 class="text-success text-center">Giỏ hàng của bạn</h4>
				<% if (session.getAttribute("cart") == null) { %>
					<center>
						<div class ='mt-5 font-weight-bold'>Không có sản phẩm nào trong giỏ hàng </div>
						<i class='material-icons d-block' style='font-size:72px;color:red'>cancel</i>
						<a href = '<%=request.getContextPath()%>' class='nav-link'>Quay lại trang chủ</a>
					</center>
				<% } else{
						HashMap<Product, Integer> cart = (HashMap) session.getAttribute("cart"); %>
					<table class='table table-striped mt-5'>
						<tr>
							<th>STT</th>
							<th>Mặt hàng</th>
							<th>Đơn giá</th>
							<th>Số lượng</th>
							<th></th>
						</tr>
						<%
						int i = 1;
						for (Product p : cart.keySet()) { %>
						<tr>
							<td><%=i%></td>
							<td><%=p.getName()%></td>
							<td class='text-danger font-weight-bold'><%=p.getPriceString()%></td>
							<td>
								<button onclick='adjust(<%=p.getId()%>, false)' class='btn btn-success'> - </button>
								<span class='p-3' id='number-<%=p.getId()%>'><%=cart.get(p)%></span>
								<button onclick='adjust(<%=p.getId()%>, true)' class='btn btn-success'> + </button>
							</td>
							<td> <a class='' href='customer-remove-form-cart/<%=p.getId()%>'>Xóa</a></td>
						</tr>
						<%	i++;
						} %>
					</table>
					<h4 class='mt-3 text-danger text-center'>Tổng giá: <span id='totalPrice'><%=session.getAttribute("totalPrice")%></span> </h4>
					<form action ='customer-confirm-order' method='post' class='mt-3 d-flex justify-content-between'>
						<a class='btn btn-info' href='<%=request.getContextPath()%>'>Tiếp tục mua</a>
						<input type='submit' value='Chốt đơn hàng' class='btn btn-warning text-white'>
					</form>
				<% } %>
			</div>
		</div>
		<jsp:include page="_footer.jsp"></jsp:include>
		
	</body>
</html>