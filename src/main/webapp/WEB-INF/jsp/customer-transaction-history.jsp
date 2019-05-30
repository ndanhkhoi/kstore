<%@page import="java.util.HashMap"%>
<%@page import="com.ndanhkhoi.entity.OrderInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	HashMap<String, List<OrderInfo> > orders = new HashMap();
	orders.put("Đơn đặt hàng chờ thanh tóan",  (List) request.getAttribute("listOrder") );
	orders.put("Hóa đơn đã thanh toán",  (List) request.getAttribute("listOrderPaid") );
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="<c:url value="/resources/css/main_styles.css" />">
		<link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" />">
		<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
		<link rel="stylesheet" href="<c:url value="/resources/css/animate.css" />">
		<script src="<c:url value="/resources/js/wow.min.js" />"></script>
		<script src="<c:url value="/resources/bootstrap/js/jquery-3.3.1.min.js" />"></script>
		<script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js" />"></script>
		<title>Lịch sử giao dịch</title>
	</head>
	<body>

	<jsp:include page="_header.jsp"></jsp:include>
			
	<!--	 This is content page	 -->
		<div class="container-fluid">			
	 		<div class = "row m-5">
	 		<% for (String s : orders.keySet()){
	 			List<OrderInfo> listOrder = orders.get(s); %>
	 			<div class = "col-md-6 p-3 wow bounceInUp">
	 				<h4 class="text-danger"><%=s%></h4>
	 				<% if (listOrder.isEmpty()) {%> Không có đơn hàng chờ thanh toán
 					<% } else{ %>
 					<div class='my-table-scrollbar'>
 						<table class='table table-striped mt-3 p-2'>
 						<tr>
	 						<th>Mã đặt hàng</th>
	 						<th>Ngày đặt hàng</th>
	 						<th>Giá trị</th>
	 						<th colspan='2'></th>
 						</tr>
 						<% for (OrderInfo o : listOrder){  %>
						<tr>
	 						<td><%=o.getId()%></td>
	 						<td><%=o.getOrderDay()%></td>
	 						<td class='text-danger'><%=o.getTotalPriceString()%></td>
	 						<td><a href='customer-view-order/<%=o.getId()%>' class='p-0 btn btn-link'><i class='material-icons'>info</i></a></td>
	 						<td>
	 							<% if (o.getPaid() == 0) { %>
	 							<button onclick='cancel(<%=o.getId()%>)' class='p-0 btn btn-link'><i class='material-icons'>cancel</i></button>
	 							<% } %>
	 						</td>
 						</tr>
 						<% } %>
 						</table>
 					</div>
 					<%} %>
	 			</div>
 			<%} %>
	 		</div>
		</div>
	<jsp:include page="_footer.jsp"></jsp:include>
	<script>
	    new WOW().init();
		function cancel(id) {
			if (confirm("Xác nhận hủy? ")) {
				var xhttp = new XMLHttpRequest();
				xhttp.onreadystatechange = function() {
				  if (this.readyState == 4 && this.status == 200) {
					    var txt = this.responseText;
					    if (txt == "success") window.location.assign("customer-transaction-history");
					    else if (txt == "expired") alert("Không thể hủy đơn hàng đã order hơn 1 ngày");
					  }
				};
				xhttp.open("GET", "customer-cancel-order/" + id, false);
				xhttp.send(); 
			}
		}
	</script>
	</body>
</html>