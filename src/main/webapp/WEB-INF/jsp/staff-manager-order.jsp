<%@page import="com.ndanhkhoi.entity.OrderInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	List<OrderInfo> unpaidOrders = (List) request.getAttribute("unpaidOrders");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="<c:url value="/resources/css/main_styles.css" />">
<link rel="stylesheet"
	href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" />">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<script
	src="<c:url value="/resources/bootstrap/js/jquery-3.3.1.min.js" />"></script>
<script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js" />"></script>
<title>Quản lý đơn đặt hàng</title>
</head>
<body>
	<jsp:include page="dashboard-header.jsp"></jsp:include>
	<div class="container-fluid h-100">
		<div class="row h-100">
			<jsp:include page="dashbaord-navibar.jsp"></jsp:include>
			<div class="col-md-10 bg-light">
				<h4 class="text-danger m-3 text-center">Đơn đặt hàng chưa thanh
					toán</h4>
				<div class="d-flex justify-content-center">
					<div class="col-md-5 pt-4">
						<input class="form-control" id="txtTimKiem" type="text"
							placeholder="Nhập thông tin tìm kiếm" />
						<p id="count" class="text-center pt-3">Số kết quả:</p>
					</div>
				</div>
				<div class="d-flex justify-content-center mb-5">
					<div class="card col-md-9 p-3">
						<table class='table-scroll table table-striped table-hover'>
							<thead class="bg-dark">
								<tr class='text-white'>
									<th>Mã đặt hàng</th>
									<th>Ngày đặt hàng</th>
									<th>Giá trị</th>
									<th>Tên khách hàng</th>
									<th></th>
								</tr>
							</thead>
							<tbody id="myTable">
								<%
									for (OrderInfo o : unpaidOrders) {
								%>
								<tr>
									<td><%=o.getId()%></td>
									<td><%=o.getOrderDay()%></td>
									<td class='text-danger'><%=o.getTotalPriceString()%></td>
									<td><%=o.getProfile().getFullname()%></td>
									<td><a href='staff-export-bill/<%=o.getId()%>'><i
											class='material-icons'>check</i></a></td>
								</tr>
								<%
									}
								%>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="<c:url value="/resources/js/filtertable.js" />"></script>
</body>
</html>